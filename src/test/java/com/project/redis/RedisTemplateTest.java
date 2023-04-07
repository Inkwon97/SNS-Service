package com.project.redis;

import com.project.AbstractIntegrationContainerBaseTest;
import com.project.snsservice.config.RedisConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;

@Import(RedisConfig.class)
@SpringBootConfiguration
public class RedisTemplateTest extends AbstractIntegrationContainerBaseTest {

}
