package com.app.badge.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.app.badge.bean.OpenBadgesTopInSemesterDto;

public class TermCountReader {
	public List<OpenBadgesTopInSemesterDto> readInputsFromFile(String filePath) {
        List<OpenBadgesTopInSemesterDto> badgesList = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
            	String[] parts = line.split(",");
                if (parts.length == 25) {
                	String cpsId = parts[1].trim().replace("'", "");
                    String sem = parts[3].trim().replace("'", "");
                    
                    OpenBadgesTopInSemesterDto badgeBean = new OpenBadgesTopInSemesterDto();
                    badgeBean.setConsumerProgramStructureId(Integer.valueOf(cpsId));
                    badgeBean.setSem(Integer.valueOf(sem));
                    badgesList.add(badgeBean);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return badgesList;
	}
}
