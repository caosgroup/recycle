package com.ares.recycle.common.base;

/**
 * 描述
 *
 * @author wangqiaomu
 * @date 2019-07-12 14:31
 **/
public interface Describe {

    /**
     * 获取别名
     *
     * @return 别名
     */
    String alias();

    /**
     * 获取别名
     *
     * @return {@link Describe#alias()}
     */
    default String decribe() {
        return alias();
    }

}
