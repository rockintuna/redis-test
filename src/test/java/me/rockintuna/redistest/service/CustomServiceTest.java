package me.rockintuna.redistest.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class CustomServiceTest {

    @Autowired
    private CustomService customService;

    @Value("${spring.data.redis.password}")
    private String password;

    @Test
    @Order(1)
    void setKeyValue() {
        String key = "1";
        String value = "spring redis";
        customService.setKeyValue(key, value);
    }

    @Test
    @Order(2)
    void getValue() {
        String key = "1";
        String value = customService.getValue(key);
        assertThat(value).isEqualTo("spring redis");
    }

    @Test
    @Order(3)
    void addKeyValueWithSet() {
        customService.addKeyValueWithSet("set1", "1");
        customService.addKeyValueWithSet("set1", "2");
        customService.addKeyValueWithSet("set1", "3");
        customService.addKeyValueWithSet("set1", "4");
        customService.addKeyValueWithSet("set1", "5");
        customService.addKeyValueWithSet("set1", "6");
        customService.addKeyValueWithSet("set1", "7");
    }

    @Test
    @Order(4)
    void isContainsValueWithSet() {
        Boolean bool1 = customService.isContainsValueWithSet("set1", "2");
        assertThat(bool1).isTrue();
        Boolean bool2 = customService.isContainsValueWithSet("set1", "10");
        assertThat(bool2).isFalse();
    }

    @Test
    @Order(5)
    void getValueSetWithSet() {
        Set<String> set1 = customService.getValueSetWithSet("set1");
        assertThat(set1.size()).isEqualTo(7);
    }
}