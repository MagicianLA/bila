package com.bila.demo.spring.controlleradvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Magician
 * @Desc:
 *  @ControllerAdvice
 *   全局异常处理
 *   全局数据绑定
*    全局数据预处理
 * @Date: 2020/04/17
 * @Modify By:
 */
@RestController
@RequestMapping("/advice")
public class ControllerAdviceDemoController {

    @RequestMapping("/test")
    public Map<String, String> adviceTest(Date date,
                                          @RequestParam(value = "flag", required = false, defaultValue = "false") Boolean flag,
                                          Model model) {
        System.out.println(model.getAttribute("md"));
        System.out.println(date);

        if (flag) {
            int i = 1 / 0;
        }

        Map<String, String> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "success");
        return map;
    }

}
