package com.blog2.backend;

import com.blog2.backend.model.entity.User;
import com.blog2.backend.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRedis() {
        User user = new User();
        user.setUserId(1L);
        user.setPermission(1);
        user.setPhone("phone");
        user.setUserName("name");
        user.setUserPassword("123");
        redisUtil.set(user.getUserId().toString(), user);
        User temp = (User) redisUtil.get(user.getUserId().toString());
        System.out.println(temp.toString());
    }

    @Test
    public void testRedis2() {
        redisUtil.set("1", "1");
        redisUtil.get("1");
    }
}
