package com.app.drive.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class File {

	private String kind;
    private String id;
    private String name;
    private String mimeType;	
}