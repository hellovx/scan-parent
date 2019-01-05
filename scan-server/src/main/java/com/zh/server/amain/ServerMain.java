package com.zh.server.amain;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zh.server.utils.spring.SpringUtils;

public class ServerMain {
	
	static Logger log=Logger.getLogger(ServerMain.class);
	
    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure(getClassResourcePath() + "/properties/log4j.properties");
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "classpath:spring/applicationContext-all.xml" });
        SpringUtils.setSpringContext(context);
        context.start();
        log.info("start up success");
        try {
            System.in.read();   // 按任意键退出
        } catch (IOException e) {
            e.printStackTrace();
        } 
    	System.out.println(getClassResourcePath());
    }
    
    public static String getClassResourcePath() throws Exception{
    	//System.out.println(ServerMain.class.getResource("").getPath());
    	return ServerMain.class.getResource("/").getPath();
    }
}
