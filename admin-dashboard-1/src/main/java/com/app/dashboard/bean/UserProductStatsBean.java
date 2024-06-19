package com.app.dashboard.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProductStatsBean {
	private int id;
	private String userId;
	private String productId;
    private String name;
    private String description;
    private String category;
    private double quantity;
    private double price;
}
