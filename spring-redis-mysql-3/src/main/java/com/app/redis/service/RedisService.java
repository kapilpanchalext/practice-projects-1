package com.app.redis.service;

import java.util.List;

import com.app.redis.bean.TodoBean;

public interface RedisService {

	Iterable<TodoBean> getResponseFromRedis();

	TodoBean addRedisData(TodoBean bean);

	List<TodoBean> addRedisDataList(List<TodoBean> beanList);
}
