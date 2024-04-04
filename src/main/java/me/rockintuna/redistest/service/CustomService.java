package me.rockintuna.redistest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<String, String> redisSetTemplate;

    public void setKeyValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void addKeyValueWithSet(String key, String value) {
        redisSetTemplate.opsForSet().add(key, value);
    }

    public Boolean isContainsValueWithSet(String key, String value) {
        return redisSetTemplate.opsForSet().isMember(key, value);
    }

    public Set<String> getValueSetWithSet(String key) {
        return redisSetTemplate.opsForSet().members(key);
    }
}
