package com.ares.recycle.common.constant;

/**
 * @author Joem Wong
 * @date 2019-04-13 10:50
 **/
public class LogConstant {

    /**
     * 日志格式: [ARMS_LOG] | 监控大类 | 监控指标名称 | 监控指标值 | 监控指标标签
     */
    public static final String ARMS_LOG = "[ARMS_LOG]|{}|{}|{}|{}";
    /**
     * 日志格式:[方法名] | 入参 | 出参 | 描述/统计数据
     */
    public static final String LOG_FORMAT = "[{}]|{}|{}|{}";

    private static final String LOG_E_FORMAT = "[%s]|%s|%s|%s";

    public static String generateErrorLog(String func, String in, String out, String msg) {
        return String.format(LOG_E_FORMAT, func, in, out, msg);
    }
}
