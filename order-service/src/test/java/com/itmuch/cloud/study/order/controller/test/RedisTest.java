package com.itmuch.cloud.study.order.controller.test;

import com.itmuch.cloud.study.order.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() throws Exception {

//        stringRedisTemplate.opsForValue().set("mark","good luck");

//        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getUserName(), user);

        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getUserName(), user);

        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getUserName(), user);

        System.out.println(redisTemplate.opsForValue().get("超人").getAge().longValue());

//        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
//        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
//        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

    }
}
