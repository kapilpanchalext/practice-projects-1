package com.app.badge.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenBadgesTopInSemesterDto implements Serializable {
	private int userId;	
	private String sapid;
	private int rank;
	private int totalMarks;
	private int outOfMarks;
	private int sem;
	private int subjectCount;
	private int consumerProgramStructureId;
}
