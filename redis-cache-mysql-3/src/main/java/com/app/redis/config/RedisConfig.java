package com.app.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/*
@Configuration
public class RedisConfig extends CachingConfigurerSupport{

//	@Value("${spring.redis.host}")
//    private String redisHost;

//    @Value("${spring.redis.port}")
//    private int redisPort;
//
//    @Value("${spring.redis.timeout}")
//    private Duration redisCommandTimeout;
//
//    @Value("${spring.redis.pool.max-active}")
//    private int maxPool;

    @Bean
    LettuceConnectionFactory redisConnectionFactory() {
    	
//    	System.err.println("REDIS HOST: " + redisHost);
//    	System.err.println("REDIS PORT: " + redisPort);
//    	System.err.println("REDIS COMMAND TIMEOUT: " + redisCommandTimeout);
//    	System.err.println("MAX POOL: " + maxPool);
        
    	final ClientOptions clientOptions = ClientOptions.builder().build();
        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .commandTimeout(Duration.ofSeconds(3000))
                .clientOptions(clientOptions).build();
        
        System.err.println("CLIENT OPTIONS: " + clientOptions);        
        System.err.println("CLIENT CONFIG: " + clientConfig);
        
        RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration("localhost", 6379);
        System.err.println("SERVER CONFIG: " + serverConfig);
        
        LettuceConnectionFactory factory = new LettuceConnectionFactory(serverConfig, clientConfig);
        System.err.println("FACTORY: " + factory);
        
        return factory;
    }
    
    @Bean(name = "redisTemplate")
    RedisTemplate<String, Employee> redisTemplate() {
        final RedisTemplate<String, Employee> redisTemplate = new RedisTemplate<>();
        
        redisTemplate.setConnectionFactory(redisConnectionFactory()); //redisConnectionFactory() //connectionFactory()
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        
        System.err.println("REDIS TEMPLATE: " + redisTemplate);
        
        return redisTemplate;
    }


}*/

@Configuration
public class RedisConfig {

	@Bean(name = "redisTemplate")
	RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory){
		final RedisTemplate<?, ?> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}
}