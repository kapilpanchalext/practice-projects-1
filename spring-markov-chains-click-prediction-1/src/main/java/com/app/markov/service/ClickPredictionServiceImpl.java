package com.app.markov.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ClickPredictionServiceImpl implements ClickPredictionService {

	private Map<String, List<String>> clickProbabilities = new HashMap<>();
	private Random random = new Random();

	public ClickPredictionServiceImpl() {
		initializeClickProbabilities();
	}

	private void initializeClickProbabilities() {
		 clickProbabilities.put("home", List.of("products", "about", "contact"));
	     clickProbabilities.put("products", List.of("home", "about", "product-details"));
	     clickProbabilities.put("about", List.of("home", "products"));
	     clickProbabilities.put("contact", List.of("home"));
	     clickProbabilities.put("product-details", List.of("products"));		
	}

	@Override
	public String predictNextClick(String clickHandler) {
		List<String> nextClicks = clickProbabilities.get(clickHandler);
		
		if(nextClicks == null || nextClicks.isEmpty()) {
			return "home";
		}
		
		return nextClicks.get(random.nextInt(nextClicks.size()));
	}
}
