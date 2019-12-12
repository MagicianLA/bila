package com.bila.demo.spring.clazz.repeatable;

import com.bila.demo.spring.clazz.repeatable.annotation.PeriodAnn;

/**
 * @Author: Magician
 * @Desc: Repeatable注解，表明标记的注解可以多次应用于相同的声明或类型
 * @Date: 2019/12/12
 * @Modify By:
 */
@PeriodAnn(daily = "2019-1-1")
@PeriodAnn(daily = "2019-12-12",mtd = "2019-12")
public class RepeatableDemo {

    /**
     * java8之后添加了@Repeatable注解
     * java8之后添加了getAnnotationsByType方法
     * @param args
     */
    public static void main(String[] args) {
        PeriodAnn[] periodAnnArr = RepeatableDemo.class.getAnnotationsByType(PeriodAnn.class);
        for(PeriodAnn periodAnn : periodAnnArr) {
            System.out.println(periodAnn.toString());
        }
    }
}
