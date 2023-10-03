package com.app.tips.bean;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash(value = "program")
public class Program implements Serializable{
	
	@Id
	@Builder.Default
	private UUID programId = UUID.randomUUID();
	
	private String programName;
	
	private Integer programDuration;
}
