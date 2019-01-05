package com.zh.server.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.zh.api.service.demo.HelloInfoService;
import com.zh.server.utils.log4j.MyJUnit4ClassRunner;


@RunWith(MyJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext-all.xml" })
public class HelloInfoTest {
	
	@Autowired
	HelloInfoService helloInfoService;
	
	@Test
	public void TestDemo(){
		String str=helloInfoService.sayHello("DB1","Test张浩");
		System.out.println(str);
		str=helloInfoService.sayHello("DB1","Test张浩");
		System.out.println(str);
		
	}
	
	@Test
	public void TestUpdate() throws Exception{
		int num=helloInfoService.updateName("", "qq2");
		System.out.println(num);
		num=helloInfoService.updateName("", "ww2");
		System.out.println(num);
		
	}

}
