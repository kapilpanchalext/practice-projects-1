package com.app.dashboard.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.app.dashboard.bean.SalesByCategoryBean;

public class SalesByCategoryReader {
	public List<SalesByCategoryBean> readInputsFromFile(String filePath) {
		List<SalesByCategoryBean> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            SalesByCategoryBean salesByCategory = null;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.startsWith("{") || line.startsWith("}")) {
                    continue;
                }

                String[] keyValue = line.split(":", 2);
                if (keyValue.length < 2) {
                    continue;
                }

                String key = keyValue[0].trim();
                String value = keyValue[1].trim().replace(",", "");

                if (salesByCategory == null) {
                    salesByCategory = new SalesByCategoryBean();
                }

                switch (key) {
                    case "shoes":
                        salesByCategory.setShoes(Integer.parseInt(value));
                        break;
                    case "clothing":
                        salesByCategory.setClothing(Integer.parseInt(value));
                        break;
                    case "accessories":
                        salesByCategory.setAccessories(Integer.parseInt(value));
                        break;
                    case "misc":
                        salesByCategory.setMisc(Integer.parseInt(value));
                        break;
                }
            }

            if (salesByCategory != null) {
                products.add(salesByCategory);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
	}
}
