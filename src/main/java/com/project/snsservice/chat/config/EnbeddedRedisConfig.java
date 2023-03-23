package com.project.snsservice.chat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Configuration
public class EnbeddedRedisConfig {

    @Value("${spring.redis.port}")
    private int redisPort;


}
