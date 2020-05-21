package com.bila.demo.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2020/05/15
 * @Modify By:
 */
@SpringBootTest
public class MyApplicationListenerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void test() {
        ContextRefreshedEvent event = new ContextRefreshedEvent(webApplicationContext);
        webApplicationContext.publishEvent(event);

    }
}
