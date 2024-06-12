package com.app.dashboard.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.app.dashboard.bean.ProductBean;

public class ProductReader {
	public List<ProductBean> readInputsFromFile(String filePath) {
		List<ProductBean> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            ProductBean product = null;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (line.startsWith("_id")) {
                    if (product != null) {
                        products.add(product);
                    }
                    product = new ProductBean();
                }

                String[] keyValue = line.split(":", 2);
                if (keyValue.length < 2) {
                    continue;
                }

                String key = keyValue[0].trim();
                String value = keyValue[1].trim().replace("\"", "").replace(",", "");
                
                switch (key) {
                    case "_id":
                        product.setId(value);
                        break;
                    case "name":
                        product.setName(value);
                        break;
                    case "price":
                        product.setPrice(Double.valueOf(value));
                        break;
                    case "description":
                        product.setDescription(value);
                        break;
                    case "category":
                        product.setCategory(value);
                        break;
                    case "rating":
                        product.setRating(Double.valueOf(value));
                        break;
                    case "supply":
                        product.setSupply(Integer.valueOf(value));
                        break;
                }
            }

            if (product != null) {
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
	}
}
