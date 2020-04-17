package com.bila.demo.log;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2020/01/15
 * @Modify By:
 */
public interface IBilaConf {
    /**
     * set log Level
     * @param level
     */
    //void setLevel(Level level);

    /**
     * add RollingFileAppender
     * @param appenderName
     * @param fileName
     */
    void addAppender(String appenderName, String fileName);

    /**
     * 设置日志是否Attach到Parent
     * @param additivity
     */
    void setAdditivity(boolean additivity);
}
