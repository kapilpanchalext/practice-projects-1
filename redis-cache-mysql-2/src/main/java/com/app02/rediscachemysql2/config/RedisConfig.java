package com.app02.rediscachemysql2.config;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;

import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import io.lettuce.core.ClientOptions;

@Configuration
public class RedisConfig extends CachingConfigurerSupport{

	@Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.timeout}")
    private Duration redisCommandTimeout;

    @Value("${spring.redis.pool.max-active}")
    private int maxPool;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
    	
    	System.err.println("REDIS HOST: " + redisHost);
    	System.err.println("REDIS PORT: " + redisPort);
    	System.err.println("REDIS COMMAND TIMEOUT: " + redisCommandTimeout);
    	System.err.println("MAX POOL: " + maxPool);
        
    	final ClientOptions clientOptions = ClientOptions.builder().build();
        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .commandTimeout(redisCommandTimeout)
                .clientOptions(clientOptions).build();
        
        System.err.println("CLIENT OPTIONS: " + clientOptions);        
        System.err.println("CLIENT CONFIG: " + clientConfig);
        
        RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration(redisHost, redisPort);
        System.err.println("SERVER CONFIG: " + serverConfig);
        
        LettuceConnectionFactory factory = new LettuceConnectionFactory(serverConfig, clientConfig);
        System.err.println("FACTORY: " + factory);
        
        return factory;
    }
    
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        
        redisTemplate.setConnectionFactory(redisConnectionFactory()); //redisConnectionFactory() //connectionFactory()
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        
        System.err.println("REDIS TEMPLATE: " + redisTemplate);
        
        return redisTemplate;
    }
}
