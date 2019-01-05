package com.zh.core.timertask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class TestTask {
	Logger log=Logger.getLogger(TestTask.class);
	public void sayHello(){
		log.info("进入quarz-testTask");
		System.out.println("hello "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
