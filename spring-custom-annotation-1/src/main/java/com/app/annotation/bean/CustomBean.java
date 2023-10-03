package com.app.annotation.bean;

import java.io.Serializable;

import com.app.annotation.library.UUIDGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomBean implements Serializable{

	@UUIDGenerator
	private String id;
	
}
