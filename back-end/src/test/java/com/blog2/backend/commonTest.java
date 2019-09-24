package com.blog2.backend;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Author: goodtimp
 * @Date: 2019/9/23 9:56
 * @description :  公共继承测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class commonTest {
    @Before
    public void init() {
        System.out.println("-----------------开始测试-----------------");
    }

    @After
    public void after() {
        System.out.println("-----------------测试结束-----------------");
    }

}
