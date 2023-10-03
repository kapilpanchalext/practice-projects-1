package com.app.redis.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.redis.bean.TodoBean;
import com.app.redis.dao.RedisDao;
import com.app.redis.repo.RedisRepository;

@Service
public class RedisServiceImpl implements RedisService{
	
	@Autowired
	private RedisRepository repo;
	
	@Autowired
	private RedisDao dao;

	@Override
	public Iterable<TodoBean> getResponseFromRedis() {
		long startRedisFetch = System.nanoTime();
		Iterable<TodoBean> redisStatus = repo.findAll();
		long endRedisFetch = System.nanoTime();
		System.err.println("REDIS FETCH TIME: " + ((endRedisFetch-startRedisFetch)));
		long startSQLFetch = System.nanoTime();
		List<TodoBean> daoStatus = dao.findAllList();
		long endSQLFetch = System.nanoTime();
		System.err.println("DATABASE FETCH TIME: " + ((endSQLFetch-startSQLFetch)));
//		System.err.println("DAOSTATUS: " + daoStatus);
		return redisStatus;
	}

	@Override
	public TodoBean addRedisData(TodoBean bean) {
		long startRedistime = System.nanoTime();
		for(int i=0;i<100;i++) {
			bean.setId(UUID.randomUUID());
			repo.save(bean);
		}
		long endRedisTime = System.nanoTime();
		System.err.println("SAVE TIME REDIS NANOSECONDS: " + ((endRedisTime-startRedistime)));

		long startDaotime = System.nanoTime();
		for(int i=0;i<100;i++) {
			bean.setId(UUID.randomUUID());
			int status = dao.addTodoBean(bean);
		}
		
		long endDaoTime = System.nanoTime();
		System.err.println("SAVE TIME DAO NANOSECONDS: " + ((endDaoTime-startDaotime)));
		
		return repo.save(bean);
	}

	@Override
	public List<TodoBean> addRedisDataList(List<TodoBean> beanList) {
		
		return (List<TodoBean>) repo.saveAll(beanList);
	}
}