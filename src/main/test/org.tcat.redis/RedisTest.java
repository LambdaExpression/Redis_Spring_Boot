package org.tcat.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * 第一种类型 自动注入
 * Created by Lin on 2016/11/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() throws Exception {
        // 30s后过时
        stringRedisTemplate.opsForValue().set("aaa", "111", 30, TimeUnit.SECONDS);
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
        //正则
        System.out.println(stringRedisTemplate.opsForValue().getOperations().keys("a*"));
    }
}
