package com.bila.demo.spring.clazz.annotationbeanutils;

import com.bila.demo.spring.clazz.annotationbeanutils.annotation.FooAnnotition;
import lombok.Data;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2019/12/12
 * @Modify By:
 */
@Data
@FooAnnotition(id = 123L, name = "Hell AnnotationBeanUtils")
public class FooBean {
    /**
     * ID
     */
    private Long id;
    /**
     * Name
     */
    private String name;
}
