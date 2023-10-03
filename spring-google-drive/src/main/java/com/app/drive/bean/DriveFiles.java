package com.app.drive.bean;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriveFiles implements Serializable{

	private static final long serialVersionUID = -7041604479570917675L;
	
	private String kind;
    private String nextPageToken;
    private String incompleteSearch;
    private List<File> files;
}