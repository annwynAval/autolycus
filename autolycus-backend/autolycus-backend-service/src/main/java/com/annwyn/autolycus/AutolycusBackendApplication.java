package com.annwyn.autolycus;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

@SpringBootApplication(scanBasePackages = "com.annwyn.autolycus", exclude = {
        JdbcTemplateAutoConfiguration.class
})
public class AutolycusBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutolycusBackendApplication.class, args);
    }

//    @Bean
//    public RedisSerializer<String> keySerializer() {
//        return new StringRedisSerializer();
//    }
//
//    @Bean
//    public RedisSerializer<Serializable> valueSerializer(ObjectMapper objectMapper) {
//        Jackson2JsonRedisSerializer<Serializable> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Serializable.class);
//        jsonRedisSerializer.setObjectMapper(objectMapper);
//        return jsonRedisSerializer;
//    }
//
//    @Bean
//    public RedisTemplate<String, Serializable> redisTemplate(RedisConnectionFactory connectionFactory, RedisSerializer<String> keySerializer, RedisSerializer<Serializable> valueSerializer) {
//        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        redisTemplate.setKeySerializer(keySerializer);
//        redisTemplate.setHashKeySerializer(keySerializer);
//        redisTemplate.setValueSerializer(valueSerializer);
//        redisTemplate.setHashValueSerializer(valueSerializer);
//
//        return redisTemplate;
//    }

}
