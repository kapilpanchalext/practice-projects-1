package com.app.redis.bean;

import java.util.UUID;

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
@RedisHash(value = "TODO")
public class TodoBean {

	@Id
	@Builder.Default
	private UUID id = UUID.randomUUID();
	
	private String title;
	
	@Builder.Default
	private Boolean completed = false;
	
	private Long order;
	private String url;
}