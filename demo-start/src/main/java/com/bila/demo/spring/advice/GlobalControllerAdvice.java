package com.bila.demo.spring.advice;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2020/04/17
 * @Modify By:
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    /**
     * 处理异常
     * @param e
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleException(Exception e) {
        e.printStackTrace();
        Map<String, String> map = new HashMap<>();
        map.put("code", "error");
        map.put("msg", e.getMessage());
        return map;
    }

    /**
     * 数据绑定：
     * 全局数据绑定功能可以用来做一些初始化的数据操作，我们可以将一些公共的数据定义在添加了@ControllerAdvice 注解的类中，
     * 这样，在每一个 Controller 的接口中，就都能够访问导致这些数据。
     * @return
     */
    @ModelAttribute(name = "md")
    public Map<String,Object> mydata() {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 99);
        map.put("gender", "男");
        return map;
    }

    /**
     * 全局数据预处理
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
            if (Objects.nonNull(value) && !"".equals(value)) {
                Date date = strToDate(value, "yyyy-MM-dd");
                setValue(date);
            }
            }
        });
    }


    private Date strToDate(String dataStr, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = format.parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
