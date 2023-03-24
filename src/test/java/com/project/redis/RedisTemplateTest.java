package com.project.redis;

import com.project.AbstractIntegrationContainerBaseTest;
import com.project.snsservice.global.config.RedisConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Import(RedisConfig.class)
@SpringBootConfiguration
public class RedisTemplateTest extends AbstractIntegrationContainerBaseTest {

}
