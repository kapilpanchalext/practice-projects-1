package com.app.elastic.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.elastic.bean.ProductBean;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.DeleteRequest;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

@Repository
public class ElasticSearchQuery {

	@Autowired
	private ElasticsearchClient client;

	private final String indexName = "products";

	public String createOrUpdateDocument(ProductBean productBean) throws ElasticsearchException, IOException {
		IndexResponse response = client.index(i -> i.index(indexName).id(productBean.getId()).document(productBean));

		if (response.result().name().equals("Created")) {
			return new StringBuilder("Document created Successfully!").toString();
		} else if (response.result().name().equals("Updated")) {
			return new StringBuilder("Document updated Successfully!").toString();
		}
		return new StringBuilder("Error Creating Document!").toString();
	}

	public ProductBean getDocumentById(String productId) throws IOException {
		ProductBean productBean = null;

		GetResponse<ProductBean> response = client.get(g -> g.index(indexName).id(productId), ProductBean.class);

		if (response.found()) {
			productBean = response.source();
			System.err.println("Product Bean: " + productBean.getName());
		} else {
			System.err.println("Product Not Found!");
		}
		return productBean;
	}

	public String deleteDocumentById(String productId) throws IOException {
		DeleteRequest request = DeleteRequest.of(d -> d.index(indexName).id(productId));

		DeleteResponse response = client.delete(request);

		if (Objects.nonNull(response.result()) && !response.result().name().equals("Not Found")) {
			return new StringBuilder("Product with Id: " 
						+ response.id() 
						+ " has been deleted").toString();
		}
		System.err.println("Product Not Found!");
		
		return new StringBuilder("Product with Id: " 
						+ response.id() 
						+ " does not exist").toString();
	}
	
	public List<ProductBean> searchAllDocuments() throws IOException {
		SearchRequest request = SearchRequest.of(s -> s.index(indexName));
		SearchResponse response = client.search(request, ProductBean.class);
		
		List<Hit> hits = response.hits().hits();
		List<ProductBean> products = new ArrayList<>();
		
		for(Hit object: hits) {
			System.err.println((ProductBean) object.source());
			products.add((ProductBean) object.source());
		}
		return products;
	}
}
