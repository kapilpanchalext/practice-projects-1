package com.app.badge.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader1 {
	public List<String> readInputsFromFile(String filePath) {
        List<String> mbaPassfailBeanList = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
            	String[] parts = line.split(",");
                if (parts.length == 15) {
//                    String timeboundId = parts[0].trim().replace("'", "");
//                    String sapid = parts[1].trim().replace("'", "");
//                    String schedule_id = parts[2].trim().replace("'", "");
//                    String attempt = parts[3].trim().replace("'", "");
//                    String sem = parts[4].trim().replace("'", "");
//                    String iaScore = parts[5].trim().replace("'", "");
//                    String teeScore = parts[6].trim().replace("'", "");
//                    String graceMarks = parts[7].trim().replace("'", "");
//                    String isPass = parts[8].trim().replace("'", "");
//                    String failReason = parts[9].trim().replace("'", "");
//                    String isResultLive = parts[10].trim().replace("'", "");
//                    String status = parts[11].trim().replace("'", "");
//                    String grade = parts[12].trim().replace("'", "");
//                    String points = parts[13].trim().replace("'", "");
//                    String prgm_sem_subj_id = parts[14].trim().replace("'", "");
//                    
//                    MBAPassFail mbaPassFailBean = new MBAPassFail();
//                    mbaPassFailBean.setTimeboundId(timeboundId);
//                    mbaPassFailBean.setSapid(sapid);
//                    mbaPassFailBean.setSchedule_id(schedule_id.equalsIgnoreCase("NULL")? 0 : Integer.valueOf(schedule_id));
//                    mbaPassFailBean.setAttempt(attempt);
//                    mbaPassFailBean.setSem(sem);
//                    mbaPassFailBean.setIaScore(iaScore);
//                    mbaPassFailBean.setTeeScore(teeScore);
//                    mbaPassFailBean.setGraceMarks(graceMarks);
//                    mbaPassFailBean.setIsPass(isPass);
//                    mbaPassFailBean.setFailReason(failReason);
//                    mbaPassFailBean.setIsResultLive(isResultLive);
//                    mbaPassFailBean.setStatus(status);
//                    mbaPassFailBean.setGrade(grade);
//                    mbaPassFailBean.setPoints(points);
//                    mbaPassFailBean.setPrgm_sem_subj_id(prgm_sem_subj_id);
//                    mbaPassfailBeanList.add(mbaPassFailBean);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mbaPassfailBeanList;
	}
}
