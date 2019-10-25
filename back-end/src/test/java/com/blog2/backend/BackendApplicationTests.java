package com.blog2.backend;

import com.blog2.backend.model.entity.User;
import com.blog2.backend.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.blog2.backend.enums.TokenEnum.REFRESH_TOKEN_EXPIRE_TIME;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {

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
        RedisUtil.set(user.getUserId().toString(), user);
        User temp = (User) RedisUtil.get(user.getUserId().toString());
        System.out.println(temp.toString());
    }

    @Test
    public void testRedis2() {
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        System.out.println(Long.parseLong(REFRESH_TOKEN_EXPIRE_TIME.getCode()));
        RedisUtil.set("222", currentTimeMillis, Long.parseLong(REFRESH_TOKEN_EXPIRE_TIME.getCode()) * 1000L);
    }
}
