package com.bila.demo.spring.clazz.repeatable.annotation;

import java.lang.annotation.Repeatable;

import lombok.Data;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2019/12/12
 * @Modify By:
 */
@Repeatable(PeriodAnns.class)
public @interface PeriodAnn {
    String daily() default "";
    String wtd() default "";
    String mtd() default "";
    String ytd() default "";

}
