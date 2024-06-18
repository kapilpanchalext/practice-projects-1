package com.app.dashboard.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesByCategoryBean {

	private int shoes;
    private int clothing;
    private int accessories;
    private int misc;
}
