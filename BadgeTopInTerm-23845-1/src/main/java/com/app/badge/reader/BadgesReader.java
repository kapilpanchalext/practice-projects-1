package com.app.badge.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.app.badge.bean.OpenBadgeBean;

public class BadgesReader {
	public List<OpenBadgeBean> readInputsFromFile(String filePath) {
        List<OpenBadgeBean> badgesList = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
            	String[] parts = line.split(",");
                if (parts.length == 11) {
                    String badgeId = parts[0].trim().replace("'", "");
                    String badgeName = parts[1].trim().replace("'", "");
                    String badgeDescription = parts[2].trim().replace("'", "");
                    String issuerName = parts[3].trim().replace("'", "");
                    String attachment = parts[4].trim().replace("'", "");
                    String status = parts[5].trim().replace("'", "");
                    String version = parts[6].trim().replace("'", "");
                    String createdBy = parts[7].trim().replace("'", "");
                    String lastModifiedBy = parts[8].trim().replace("'", "");
                    String createdDate = parts[9].trim().replace("'", "");
                    String lastModifiedDate = parts[10].trim().replace("'", "");
                    
                    OpenBadgeBean badgeBean = new OpenBadgeBean();
                    badgeBean.setBadgeId(Integer.valueOf(badgeId));
                    badgeBean.setBadgeName(badgeName);
                    badgeBean.setBadgeDescription(badgeDescription);
                    badgeBean.setIssuername(issuerName);
                    badgeBean.setAttachment(attachment);
                    badgeBean.setStatus(Integer.valueOf(status));
                    badgeBean.setVersion(version);
                    badgeBean.setCreatedBy(createdBy);
                    badgeBean.setLastModifiedBy(lastModifiedBy);
                    badgesList.add(badgeBean);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return badgesList;
	}
}
