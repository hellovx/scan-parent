package com.zh.server.service.impl.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zh.api.entity.demo.Info;
import com.zh.api.service.demo.HelloInfoService;
import com.zh.server.mapper.demo.InfoMapper;
import com.zh.server.utils.db.DataSourceContextHolder;


@Service("helloInfoService")
public class HelloInfoServiceImpl implements HelloInfoService {
	
	Logger log=Logger.getLogger(HelloInfoServiceImpl.class);
	@Autowired
	InfoMapper infoMapper; 

	@Override
	public String sayHello(String dbType,String str) {
		// TODO Auto-generated method stub
		log.info("log进入");
		System.out.println("server调用:"+str);
		System.out.println("service调用infoMapper");
		
		DataSourceContextHolder.setDbType(dbType);
		Info info=infoMapper.selectByPrimaryKey(1);
		System.out.println(info.getName());
		
		return "hello "+str;
	}

	@Override
	public int updateName(String dbType,String name) throws Exception {
		//DataSourceContextHolder.setDbType(dbType);
		// TODO Auto-generated method stub
		Info info=infoMapper.selectByPrimaryKey(1);
		info.setName(name);
		int num=infoMapper.updateByPrimaryKey(info);
		
		//info.setName(info.getName()+"throw");
		//infoMapper.updateByPrimaryKey(info);
		//if(true){
		//throw new Exception("测试Exception");
		//}
		
		return num;
	}

}
