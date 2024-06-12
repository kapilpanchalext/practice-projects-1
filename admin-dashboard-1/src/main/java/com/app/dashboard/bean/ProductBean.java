package com.app.dashboard.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductBean {
	private String id;
    private String name;
    private double price;
    private String description;
    private String category;
    private double rating;
    private int supply;
}
