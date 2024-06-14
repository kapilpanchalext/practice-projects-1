package com.app.dashboard.bean;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataTransactionBean {
	private String id;
    private String userId;
    private double cost;
    private List<String> products;
    
    @Builder.Default
    private LocalDate createdDate = LocalDate.now();
}
