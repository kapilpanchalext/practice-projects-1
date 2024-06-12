package com.app.badge.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MBAPassFail {
	private String timeboundId;
    private String sapid;
    private int schedule_id;
    private String attempt;
    private String sem;
    private String iaScore;
    private String teeScore;
    private String graceMarks;
    private String isPass;
    private String failReason;
    private String isResultLive;
    private String status;
    private String grade;
    private String points;
    private String prgm_sem_subj_id;
}
