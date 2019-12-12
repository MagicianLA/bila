package com.bila.demo.spring.clazz.annotationbeanutils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2019/12/12
 * @Modify By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FooAnnotition {

    long id();
    String name();
}
