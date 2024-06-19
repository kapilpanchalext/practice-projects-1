package com.app.dashboard.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.app.dashboard.bean.AffiliateStatBean;

public class DataAffiliateStatReader {
	public List<AffiliateStatBean> readInputsFromFile(String filePath) {
		List<AffiliateStatBean> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            AffiliateStatBean user = null;
            boolean readingTransactions = false;
            List<String> affiliateSales = null;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (line.startsWith("_id")) {
                    if (user != null) {
                        users.add(user);
                    }
                    user = new AffiliateStatBean();
                }

                if (readingTransactions) {
                    if (line.startsWith("]")) {
                        readingTransactions = false;
                        user.setAffiliateSales(affiliateSales);
                        continue;
                    } else {
                        affiliateSales.add(line.replace("\"", "").replace(",", "").trim());
                        continue;
                    }
                }

                String[] keyValue = line.split(":", 2);
                if (keyValue.length < 2) {
                    continue;
                }

                String key = keyValue[0].trim();
                String value = keyValue[1].trim().replace("\"", "").replace(",", "");

                switch (key) {
                    case "_id":
                        user.setAffiliateId(value);
                        break;
                    case "userId":
                        user.setUserId(value);
                        break;
                    case "affiliateSales":
                        readingTransactions = true;
                        affiliateSales = new ArrayList<>();
                        break;
                }
            }

            if (user != null) {
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
	}
}
