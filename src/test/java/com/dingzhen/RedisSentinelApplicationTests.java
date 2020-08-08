package com.dingzhen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.PostConstruct;

@SpringBootTest
class RedisSentinelApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    StringRedisTemplate redisTemplate;

    ValueOperations<String, String> stringRedis;

    @PostConstruct
    public void init(){
        stringRedis=redisTemplate.opsForValue();
    }


    @Test
    public void testString (){
        stringRedis.set("name", "dingzhen");
        System.out.println(stringRedis.get("name"));
    }


}
