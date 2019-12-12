package com.bila.demo.spring.clazz.repeatable.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2019/12/12
 * @Modify By:
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PeriodAnns {
    PeriodAnn[] value();
}
