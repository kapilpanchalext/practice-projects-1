package com.app.redis.bean;


import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "todo")
@Table(name = "todo", schema = "rediscacheexample")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@RedisHash
public class TodoBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "todoId", sequenceName = "todo_sequence")
	private Long id;
	private String title;

	@Builder.Default
	private Boolean completed = false;
	private Long order;
	private String url;
}