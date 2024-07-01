package com.app.hooks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlacesBean {
	private String id;
    private String title;
    private Image image;
    private double lat;
    private double lon;
}