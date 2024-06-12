package com.java.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.app.badge.bean.ExamRegistrationBean;

public class ExamRegistrationReader {
	public List<ExamRegistrationBean> readInputsFromFile(String filePath) {
        List<ExamRegistrationBean> examRegistrationBeanList = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
            	String[] parts = line.split(",");
                if (parts.length == 6) {
                    String sapid = parts[0].trim().replace("'", "");
                    String program = parts[1].trim().replace("'", "");
                    String month = parts[2].trim().replace("'", "");
                    String year = parts[3].trim().replace("'", "");
                    String sem = parts[4].trim().replace("'", "");
                    String consumerProgramStructureId = parts[5].trim().replace("'", "");

                    ExamRegistrationBean examRegistrationBean = new ExamRegistrationBean();
                    examRegistrationBean.setSapid(sapid);
                    examRegistrationBean.setProgram(program);
                    examRegistrationBean.setMonth(month);
                    examRegistrationBean.setYear(year=="NULL"? -1 : Integer.valueOf(year));
                    examRegistrationBean.setSem(sem=="NULL"? -1 : Integer.valueOf(sem));
                    examRegistrationBean.setConsumerProgramStructureId(consumerProgramStructureId=="NULL"? -1 : Integer.valueOf(consumerProgramStructureId));

                    examRegistrationBeanList.add(examRegistrationBean);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return examRegistrationBeanList;
	}
}
