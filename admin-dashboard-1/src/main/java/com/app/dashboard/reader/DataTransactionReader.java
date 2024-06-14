package com.app.dashboard.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.app.dashboard.bean.DataTransactionBean;
import com.app.dashboard.bean.UserBean;

public class DataTransactionReader {
	public List<DataTransactionBean> readInputsFromFile(String filePath) {
		List<DataTransactionBean> dataTransactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            DataTransactionBean dataTransaction = null;
            boolean readingProducts = false;
            List<String> products = null;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (line.startsWith("_id")) {
                    if (dataTransaction != null) {
                        dataTransactions.add(dataTransaction);
                    }
                    dataTransaction = new DataTransactionBean();
                }

                if (readingProducts) {
                    if (line.startsWith("]")) {
                        readingProducts = false;
                        dataTransaction.setProducts(products);
                        continue;
                    } else {
                        products.add(line.replace("\"", "").replace(",", "").trim());
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
                        dataTransaction.setId(value);
                        break;
                    case "userId":
                        dataTransaction.setUserId(value);
                        break;
                    case "cost":
                        dataTransaction.setCost(Double.valueOf(value));
                        break;
                    case "products":
                        readingProducts = true;
                        products = new ArrayList<>();
                        break;
                }
            }

            if (dataTransaction != null) {
                dataTransactions.add(dataTransaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataTransactions;
    }
}
