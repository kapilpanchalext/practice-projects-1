package com.app.badge.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OpenBadgesTopInProgramDto {
	private String sapid;
	private String program;
	private Integer rank;
	private Integer totalMarks;
	private Integer outOfMarks;
	private Integer sem;
	private Integer subjectCount;
	private String examMonth;
	private String acadMonth;
	private Integer year;
}
