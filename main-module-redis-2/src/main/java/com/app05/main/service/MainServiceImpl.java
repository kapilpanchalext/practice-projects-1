package com.app05.main.service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app05.departmentserviceredis.model.DepartmentDetails;
import com.app05.main.VO.ResponseTemplateVO;
import com.app05.main.model.MainData;
import com.app05.main.repo.MainRepo;
import com.app05.userserviceredis.model.UserDetails;

import lombok.var;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainRepo repo;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	public RestTemplate restTemplate;

	@Override
	public MainData saveMainData(MainData data) {		
		return repo.saveAndFlush(data);
	}

	@Override
	public ResponseTemplateVO getMainDataById(Long mainId) {		
		var key = "main_" + mainId;
        final ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        final boolean hasKey = redisTemplate.hasKey(key);
        
        ResponseTemplateVO vo = new ResponseTemplateVO();
        
        if (hasKey) {
            final MainData post = (MainData) operations.get(key);
            System.err.println("MainServiceImpl.findMainById() : cache post >> " + post.toString());
            UserDetails userDetails = restTemplate.getForObject("http://localhost:9002/api/v1/get-user/" + post.getUserId(), UserDetails.class);
            DepartmentDetails departmentDetails = restTemplate.getForObject("http://localhost:9003/api/v1/get-department/" + post.getDepartmentId(), DepartmentDetails.class);
            vo.setMainData(post);
            vo.setUserDetails(userDetails);
            vo.setDepartmentDetails(departmentDetails);
            return vo;
        }
        
        final Optional<MainData> mainData = repo.findById(mainId);
        if(mainData.isPresent()) {
            operations.set(key, mainData.get(), 10000, TimeUnit.SECONDS);
            System.err.println("MainServiceImpl.findMainById() : cache insert >> " + mainData.get().toString());
            
            UserDetails userDetails = restTemplate.getForObject("http://localhost:9002/api/v1/get-user/" + mainData.get().getUserId(), UserDetails.class);
            DepartmentDetails departmentDetails = restTemplate.getForObject("http://localhost:9003/api/v1/get-department/" + mainData.get().getDepartmentId(), DepartmentDetails.class);
            
            vo.setMainData(mainData.get());
            vo.setUserDetails(userDetails);
            vo.setDepartmentDetails(departmentDetails);
            return vo;
        } else {
            throw new RuntimeException("Error");
        }
	}
}