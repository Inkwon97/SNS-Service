package com.project.redis;

import com.project.AbstractIntegrationContainerBaseTest;
import com.project.global.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.StringRedisTemplate;

@Import(RedisConfig.class)
@SpringBootConfiguration
public class RedisTemplateTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private final String KEY = "keyword";

    @Test
    public void 검색어_저장 () {
        //given
        String keyword = "한남동";
        String keyword2 = "서촌 맛집";

        //when
        stringRedisTemplate.opsForZSet().add(KEY, keyword, 1);
        stringRedisTemplate.opsForZSet().incrementScore(KEY, keyword, 1);
        stringRedisTemplate.opsForZSet().incrementScore(KEY, keyword, 1);

        //then
        System.out.println(stringRedisTemplate.opsForZSet().popMax(KEY));
        System.out.println();


    }
}
