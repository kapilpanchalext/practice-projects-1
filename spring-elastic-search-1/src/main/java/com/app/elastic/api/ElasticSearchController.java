package com.app.elastic.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.elastic.bean.ProductBean;
import com.app.elastic.dao.ElasticSearchQuery;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;

@RestController
@RequestMapping(path = "/api/v1")
public class ElasticSearchController {

	@Autowired
	private ElasticSearchQuery elasticSearchQuery;

	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello() {		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Hello From Elastic Search API!");
	}

	@PostMapping(path = "/add-update")
	public ResponseEntity<String> addUpdateProduct(@RequestBody ProductBean productBean) throws 
								ElasticsearchException, IOException{
		String response = elasticSearchQuery.createOrUpdateDocument(productBean);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(path = "/getDocument")
	public ResponseEntity<ProductBean> getDocumentById(@RequestParam String productId) throws IOException{
		ProductBean productBean = elasticSearchQuery.getDocumentById(productId);
		return ResponseEntity.status(HttpStatus.OK).body(productBean);
	}
	
	@DeleteMapping(path = "/delete")
	public ResponseEntity<String> deleteDocumentById(@RequestParam String productId) throws IOException{
		String response = elasticSearchQuery.deleteDocumentById(productId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(path = "/searchDocument")
	public ResponseEntity<List<ProductBean>> searchAllDocument() throws IOException{
		List<ProductBean> productBeans = elasticSearchQuery.searchAllDocuments();
		return ResponseEntity.status(HttpStatus.OK).body(productBeans);		
	}
}