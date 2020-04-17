package com.bila.demo.spring.clazz.local_variable_table_parameter_name_discoverer;

import java.lang.reflect.Method;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

/**
 * @Author: Magician
 * @Desc: 获取方法的参数名列表
 * @Date: 2020/01/03
 * @Modify By:
 */
public class LocalVariableTableParameterNameDiscovererDemo {

    private static final LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer =
        new LocalVariableTableParameterNameDiscoverer();

    public static void main(String[] args) {
        Method[] methods = LocalVariableTableParameterNameDiscovererDemo.class.getMethods();
        for(Method method : methods) {
            String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
            if(parameterNames != null) {
                StringBuffer buffer = new StringBuffer();
                for(String string : parameterNames){
                    buffer.append(string).append("\t");
                }
                System.out.println(buffer.toString());
            } else {
                System.out.println("no param -" + method.getName());
            }

        }
    }

    public static void t1(LocalVariableTableParameterNameDiscovererDemo v1) {
        System.out.println(v1);
    }
}
