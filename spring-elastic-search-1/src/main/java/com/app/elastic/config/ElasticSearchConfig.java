package com.app.elastic.config;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;

@Configuration
public class ElasticSearchConfig {
	
	@Bean
	RestClient getRestClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
		final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic","changeit"));
		
		SSLContextBuilder sslBuilder = SSLContexts
				.custom()
				.loadTrustMaterial(null, (x509Certificates, s) -> true);
		
		SSLContext sslContext = sslBuilder.build();
		
		RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "https"))
				.setHttpClientConfigCallback(new HttpClientConfigCallback() {

					@Override
					public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
						return httpClientBuilder
								.setSSLContext(sslContext)
								.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
								.setDefaultCredentialsProvider(credentialsProvider);
					}					
				})
				.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
					
					@Override
					public Builder customizeRequestConfig(Builder requestConfigBuilder) {
						return requestConfigBuilder
								.setConnectTimeout(5000)
								.setSocketTimeout(12000);
					}
				})
				.build();
		return restClient;
	}
	
	@Bean
	ElasticsearchTransport getElasticSearchTransport() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		ElasticsearchTransport transport = new RestClientTransport(getRestClient(), new JacksonJsonpMapper());
		return transport;
	}
	
	@Bean
	ElasticsearchClient getElasticSearchClient() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		ElasticsearchClient client = new ElasticsearchClient(getElasticSearchTransport());
		return client;
	}
	// https://stackoverflow.com/questions/67463983/how-to-implement-ssl-with-self-signed-certificates-on-spring-boot-against-elasti

}
