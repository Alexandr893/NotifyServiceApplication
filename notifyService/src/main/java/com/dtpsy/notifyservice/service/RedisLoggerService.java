package com.dtpsy.notifyservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RedisLoggerService {
    private final StringRedisTemplate stringRedisTemplate;

    public void saveContent(String content) {
        String uniqueId = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(uniqueId, content);
        System.out.println("Сообщение c текстом '" + content + "' Оставил пользователь с ключом  '" + uniqueId + "'");
    }
}
