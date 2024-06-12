package com.java.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.app.badge.bean.ExamScheduleBean;

public class ExamScheduleDataFileReader {
	public List<ExamScheduleBean> readInputsFromFile(String filePath) {
        List<ExamScheduleBean> examScheduleBeanList = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
            	String[] parts = line.split(",");
                if (parts.length == 5) {
                    String id = parts[0].trim().replace("'", "");
                    String assessments_id = parts[1].trim().replace("'", "");
                    String timebound_id = parts[2].trim().replace("'", "");
                    String schedule_id = parts[3].trim().replace("'", "");
                    String max_score = parts[4].trim().replace("'", "");
                    
                    ExamScheduleBean examScheduleBean = new ExamScheduleBean();
                    examScheduleBean.setId(Integer.valueOf(id));
                    examScheduleBean.setAssessments_id(Integer.valueOf(assessments_id));
                    examScheduleBean.setTimebound_id(Integer.valueOf(timebound_id));
                    examScheduleBean.setSchedule_id(Integer.valueOf(schedule_id));
                    examScheduleBean.setMax_score(max_score);
                    
                    examScheduleBeanList.add(examScheduleBean);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return examScheduleBeanList;
	}
}
