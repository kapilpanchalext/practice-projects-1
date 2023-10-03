package com.app.redis.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@RedisHash(value = "ToDo")
public class Todo {

	@Id
	private Long id;
	
	private String title;
	
	@Builder.Default
	private Boolean completed = false;
	
	private Long order;
	private String url;
	
}
