package com.tc.train.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisCache {
    @Autowired
    private RedisTemplate redisTemplate;

    public <T> T getCacheObject(final String key){
        ValueOperations<String,T> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    public <T> void setCacheObject(final String key, final T value, Integer timeout, TimeUnit timeUnit){
        log.info("key:{}",key);
        redisTemplate.opsForValue().set(key,value,timeout,timeUnit);
    }
}