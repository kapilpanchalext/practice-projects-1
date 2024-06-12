package com.app.badge.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExamScheduleBean {
	private int id; 
	private int assessments_id;
	private int timebound_id;
	private int schedule_id;
	private String max_score;
}