package com.zh.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zh.api.service.demo.HelloInfoService;


@Controller
@RequestMapping("test")
public class TestController {
	@Autowired
	HelloInfoService helloInfoService;
	
	@RequestMapping("hello.do")
	public String hello(){
		//System.out.println("hello 你好");
		String s=helloInfoService.sayHello("DB1","张浩");
		System.out.println(s);
		return "test";
	}

}
