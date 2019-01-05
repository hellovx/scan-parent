package com.zh.server.utils.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
    private static ApplicationContext context = null;

    public static void setSpringContext(ApplicationContext ac) {
        context = ac;
    }

    static {
        initSpringContext();
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }

    /**
     * 初始化Spring环境，主要是用于Main方法使用
     */
    private static void initSpringContext() {
        context = new ClassPathXmlApplicationContext(
                new String[] { "classpath:spring/applicationContext-all.xml" });
    }
}
