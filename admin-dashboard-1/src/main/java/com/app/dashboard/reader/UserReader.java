package com.app.dashboard.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.app.dashboard.bean.UserBean;

public class UserReader {
	public List<UserBean> readInputsFromFile(String filePath) {
		List<UserBean> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            UserBean user = null;
            boolean readingTransactions = false;
            List<String> transactions = null;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (line.startsWith("_id")) {
                    if (user != null) {
                        users.add(user);
                    }
                    user = new UserBean();
                }

                if (readingTransactions) {
                    if (line.startsWith("]")) {
                        readingTransactions = false;
                        user.setTransactions(transactions);
                        continue;
                    } else {
                        transactions.add(line.replace("\"", "").replace(",", "").trim());
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
                        user.setId(value);
                        break;
                    case "name":
                        user.setName(value);
                        break;
                    case "email":
                        user.setEmail(value);
                        break;
                    case "password":
                        user.setPassword(value);
                        break;
                    case "city":
                        user.setCity(value);
                        break;
                    case "state":
                        user.setState(value);
                        break;
                    case "country":
                        user.setCountry(value);
                        break;
                    case "occupation":
                        user.setOccupation(value);
                        break;
                    case "phoneNumber":
                        user.setPhoneNumber(value);
                        break;
                    case "transactions":
                        readingTransactions = true;
                        transactions = new ArrayList<>();
                        break;
                    case "role":
                        user.setRole(value);
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
