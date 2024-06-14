package com.app.dashboard.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlotDataBean {
	private String id;
    private String colour;
    private List<PlotCoordinates> data;
}
