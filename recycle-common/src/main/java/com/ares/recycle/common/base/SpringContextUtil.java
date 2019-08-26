package com.ares.recycle.common.base;

import org.springframework.context.ApplicationContext;

public class SpringContextUtil {
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext context) {
        SpringContextUtil.applicationContext = context;
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public static Object getBeanByClass(Class<?> className) {
        return applicationContext.getBean(className);
    }
}
