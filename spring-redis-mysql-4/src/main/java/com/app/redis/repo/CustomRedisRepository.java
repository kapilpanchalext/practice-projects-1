package com.app.redis.repo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.app.redis.bean.StudentBean;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class CustomRedisRepository {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
//	public void addToHashMap(String key, String hashKey, Object value) {
//		redisTemplate.opsForHash().put(key, hashKey, value.toString());
//	}

    public void addToHashMap(String key, String hashId, StudentBean studentBean) {
//        String hashKeyPrefix = key + ":" + hashId;
        Field[] fields = studentBean.getClass().getDeclaredFields();
        
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String fieldName = field.getName();
                Object fieldValue = field.get(studentBean);
//                String hashKey = hashKeyPrefix + ":" + fieldName;
                if (Objects.nonNull(fieldValue)) {
                	System.err.println("FIELD: " + fieldValue);
                	 redisTemplate.opsForHash().put(key, fieldName, fieldValue.toString());
                }               
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

//	public Object getFromHashMap(String key, String hashKey) {
//		return redisTemplate.opsForHash().get(key, hashKey);
//	}

    public StudentBean getFromHashMap(String key, String hashId) {
//        String hashKeyPrefix = key + ":" + hashId;
        Field[] fields = StudentBean.class.getDeclaredFields();
        Map<String, String> fieldValues = new HashMap<>();

        for (Field field : fields) {
            String fieldName = field.getName();
//            String hashKey = hashKeyPrefix + ":" + fieldName;
            String value = (String) redisTemplate.opsForHash().get(key, fieldName);
            fieldValues.put(fieldName, value);
        }

        try {
            return objectMapper.convertValue(fieldValues, StudentBean.class);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public void addToSortedSet(String sortedSetKey, Object value, double score) {
		redisTemplate.opsForZSet().add(sortedSetKey, value, score);		
	}
	
	public Set<Object> getRangeFromSortedSet(String sortedSetKey, long start, long end){
		return redisTemplate.opsForZSet().range(sortedSetKey, start, end);
	}
}
