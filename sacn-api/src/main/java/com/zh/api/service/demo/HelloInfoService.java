package com.zh.api.service.demo;

public interface HelloInfoService {
	
	public String sayHello(String dbType,String str);
	public int updateName(String dbType,String name) throws Exception;

}
