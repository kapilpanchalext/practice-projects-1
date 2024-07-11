package com.app.badge.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.app.badge.bean.OpenBadgesUsersBean;

public class BadgeMasterkeyMappingReader {
	public List<OpenBadgesUsersBean> readInputsFromFile(String filePath) {
        List<OpenBadgesUsersBean> badgesCriteriaParamList = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
            	String[] parts = line.split(",");
                if (parts.length == 2) {
                    String badgeId = parts[0].trim().replace("'", "");
                    String consumerProgramStructureId = parts[1].trim().replace("'", "");
                    
                    OpenBadgesUsersBean badgeCriteriaParamBean = new OpenBadgesUsersBean();
                    badgeCriteriaParamBean.setBadgeId(Integer.valueOf(badgeId));
                    badgeCriteriaParamBean.setConsumerProgramStructureId(Integer.valueOf(consumerProgramStructureId));
                    badgesCriteriaParamList.add(badgeCriteriaParamBean);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return badgesCriteriaParamList;
	}
}
