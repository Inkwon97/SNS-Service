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

    @Autowired
    private RedisTemplate redisTemplate;
    private static String KEY = "ingwon";

    @Test
    public void 검색어_저장 () {

        HashOperations<String, Object, Object> valueOperations = redisTemplate.opsForHash();
        String key = "stringKey";
        String value = "hello";

        valueOperations.put(KEY, key, value);

        Object o = valueOperations.get(KEY, key);
        System.out.println(o);
        Assertions.assertThat(value).isEqualTo(o);
        System.out.println();


    }
}
