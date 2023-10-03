package com.app.markov.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.markov.service.ClickPredictionService;

@RestController
@RequestMapping(path = "/api/v1")
public class ClickPredictionController {

	@Autowired
	private ClickPredictionService service;
	
	@GetMapping(path = "/get-next-click-prediction")
	public ResponseEntity<String> getNextClickPrediction(@RequestBody String clickHandler){		
		String prediction = service.predictNextClick(clickHandler);		
		return ResponseEntity.status(HttpStatus.OK).body(prediction);
	}
}
