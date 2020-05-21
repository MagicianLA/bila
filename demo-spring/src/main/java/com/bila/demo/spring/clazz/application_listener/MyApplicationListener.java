package com.bila.demo.spring.clazz.application_listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2020/05/15
 * @Modify By:
 */
@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(event);

        System.out.println("====");
    }
}
