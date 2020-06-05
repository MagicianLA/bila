package com.bila.demo.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.util.StringUtils;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2020/05/29
 * @Modify By:
 */
public class GenericTokenParser {
    /**
     *
     * 将字符串text中由openToken和closeToken组成的占位符依次替换为args数组中的值
     * @param openToken
     * @param closeToken
     * @param text
     * @param args
     * @return
     */
    public static String parse(String openToken, String closeToken, String text, Map<String, Object> args) {
        if (StringUtils.isEmpty(text)) {
            return text;
        }
        if (Objects.isNull(args) || args.size() == 0) {
            return text;
        }

        int offset = 0;
        int start = text.indexOf(openToken, offset);
        if (start == -1) {
            return text;
        }

        final StringBuilder builder = new StringBuilder();
        StringBuilder expression = null;

        char[] src = text.toCharArray();
        int openTokenLength = openToken.length();
        while (start > -1) {
            if (start > 0 && src[start - 1] == '\\') {
                builder.append(src, offset, start - offset - 1).append(openToken);
                offset = start + openTokenLength;
            } else {
                if (Objects.isNull(expression)) {
                    expression = new StringBuilder();
                } else {
                    expression.setLength(0);
                }
                builder.append(src, offset, start - offset);
                offset = start + openTokenLength;
                int end = text.indexOf(closeToken, offset);
                while (end > -1) {
                    if (end > offset && src[end - 1] == '\\') {
                        expression.append(src, offset, end - offset - 1).append(closeToken);
                        offset = end + closeToken.length();
                        end = text.indexOf(closeToken, offset);
                    } else {
                        expression.append(src, offset, end - offset);
                        break;
                    }
                }
                if (end == -1) {
                    builder.append(src, start, src.length - start);
                    offset = src.length;
                } else {
                    String varKey = text.substring(start + openTokenLength, end);
                    builder.append(args.get(varKey));
                    offset = end + closeToken.length();
                }
            }
            start = text.indexOf(openToken, offset);
        }

        if (offset < src.length) {
            builder.append(src, offset, src.length - offset);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("NAME", "张三");
        paramMap.put("RESULT", "GOOD");
        System.out.println(parse("{", "}", "TEST\\{}我的名字是${NAME},结果是${RESULT}，可信度是%{}", paramMap));
    }
}

