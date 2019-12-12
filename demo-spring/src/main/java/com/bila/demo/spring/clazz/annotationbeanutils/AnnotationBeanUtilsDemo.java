package com.bila.demo.spring.clazz.annotationbeanutils;

import com.bila.demo.spring.clazz.annotationbeanutils.annotation.FooAnnotition;
import org.springframework.beans.annotation.AnnotationBeanUtils;

/**
 * @Author: Magician
 * @Desc: AnnotationBeanUtils工具类Demo
 * @Date: 2019/12/12
 * @Modify By:
 */
public class AnnotationBeanUtilsDemo {
    /**
     * AnnotationBeanUtils：将注解内容赋值给对象
     * @param args
     */
    public static void main(String[] args) {
        FooBean fooBean = new FooBean();
        FooAnnotition annotation = FooBean.class.getAnnotation(FooAnnotition.class);
        AnnotationBeanUtils.copyPropertiesToBean(annotation, fooBean);
        System.out.println(fooBean);
    }
}
