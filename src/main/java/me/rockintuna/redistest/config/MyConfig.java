package me.rockintuna.redistest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Set;

// refer : https://docs.spring.io/spring-data/redis/reference/redis/template.html
@Configuration
class MyConfig {

  @Bean
  RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {

    RedisTemplate<String, String> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);
    return template;
  }

  @Bean
  RedisTemplate<String, String> redisSetTemplate(RedisConnectionFactory connectionFactory) {
    RedisTemplate<String, String> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new StringRedisSerializer());
    return template;
  }
}