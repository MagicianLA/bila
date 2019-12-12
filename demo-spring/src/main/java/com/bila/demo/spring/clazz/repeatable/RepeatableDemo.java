package com.bila.demo.spring.clazz.repeatable;

import java.util.Arrays;

import com.bila.demo.spring.clazz.repeatable.annotation.PeriodAnn;
import com.bila.demo.spring.clazz.repeatable.annotation.PeriodAnns;
import org.springframework.core.annotation.AnnotationUtils;

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
        /*
         * 方式一：推荐，java8后支持
         */
        PeriodAnn[] periodAnnArr = RepeatableDemo.class.getAnnotationsByType(PeriodAnn.class);
        for(PeriodAnn periodAnn : periodAnnArr) {
            System.out.println(periodAnn.toString());
        }

        System.out.println("====");

        /*
         * 参考资料：https://www.jianshu.com/p/4f65fae2510b
         * 方式二
         * 注意：如果RepeatableDemo上只有一个@PeriodAnn注解时，不会编译成PeriodAnns，所以按PeriodAnns.class取为null
         */
        PeriodAnns annotations = AnnotationUtils.getAnnotation(RepeatableDemo.class, PeriodAnns.class);

        // 如果只有一个PeriodAnn注解的情况，只能根据PeriodAnn获取
        // AnnotationUtils.getAnnotation(RepeatableDemo.class, PeriodAnn.class);

        Arrays.stream(annotations.value()).forEach(System.out::println);
    }
}
