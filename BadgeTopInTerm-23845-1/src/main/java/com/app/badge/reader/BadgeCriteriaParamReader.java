package com.app.badge.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.app.badge.bean.OpenBadgeCriteriaBean;

public class BadgeCriteriaParamReader {
	public List<OpenBadgeCriteriaBean> readInputsFromFile(String filePath) {
        List<OpenBadgeCriteriaBean> badgesCriteriaParamList = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
            	String[] parts = line.split(",");
                if (parts.length == 8) {
                    String criteriaParamId = parts[0].trim().replace("'", "");
                    String criteriaId = parts[1].trim().replace("'", "");
                    String criteriaName = parts[2].trim().replace("'", "");
                    String criteriaValue = parts[3].trim().replace("'", "");
                    String createdBy = parts[4].trim().replace("'", "");
                    String lastModifiedBy = parts[5].trim().replace("'", "");
                    String createdDate = parts[6].trim().replace("'", "");
                    String lastModifiedDate = parts[7].trim().replace("'", "");
                    
                    OpenBadgeCriteriaBean badgeCriteriaParamBean = new OpenBadgeCriteriaBean();
                    badgeCriteriaParamBean.setCriteriaParamId(Integer.valueOf(criteriaParamId));
                    badgeCriteriaParamBean.setCriteriaId(Integer.valueOf(criteriaId));
                    badgeCriteriaParamBean.setCriteriaName(criteriaName);
                    badgeCriteriaParamBean.setCriteriaValue(Integer.valueOf(criteriaValue));
                    badgeCriteriaParamBean.setCreatedBy(createdBy);
                    badgeCriteriaParamBean.setLastModifiedBy(lastModifiedBy);
                    badgesCriteriaParamList.add(badgeCriteriaParamBean);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return badgesCriteriaParamList;
	}
}
