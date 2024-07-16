package com.app.badge.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.app.badge.bean.OpenBadgeCriteriaBean;

public class BadgeIssuedReader {
	public List<OpenBadgeCriteriaBean> readInputsFromFile(String filePath) {
        List<OpenBadgeCriteriaBean> badgesCriteriaList = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
            	String[] parts = line.split(",");
                if (parts.length == 8) {
                    String criteriaId = parts[0].trim().replace("'", "");
                    String badgeId = parts[1].trim().replace("'", "");
                    String criteriaType = parts[2].trim().replace("'", "");
                    String criteriaDescription = parts[3].trim().replace("'", "");
                    String createdBy = parts[4].trim().replace("'", "");
                    String lastModifiedBy = parts[5].trim().replace("'", "");
                    String createdDate = parts[6].trim().replace("'", "");
                    String lastModifiedDate = parts[7].trim().replace("'", "");
                    
                    OpenBadgeCriteriaBean badgeCriteriaBean = new OpenBadgeCriteriaBean();
                    badgeCriteriaBean.setCriteriaId(Integer.valueOf(criteriaId));
                    badgeCriteriaBean.setBadgeId(Integer.valueOf(badgeId));
                    badgeCriteriaBean.setCriteriatype(Integer.valueOf(criteriaType));
                    badgeCriteriaBean.setCriteriaDescription(criteriaDescription);
                    badgeCriteriaBean.setCreatedBy(createdBy);
                    badgeCriteriaBean.setLastModifiedBy(lastModifiedBy);
                    badgesCriteriaList.add(badgeCriteriaBean);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return badgesCriteriaList;
	}
}
