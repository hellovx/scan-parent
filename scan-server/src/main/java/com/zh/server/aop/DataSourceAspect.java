package com.zh.server.aop;

import java.util.HashMap;
import java.util.Map;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.zh.server.utils.db.DataSourceContextHolder;


/**
 * 2018.05.28
 * @author zhanghao
 *
 *注意：@order 定义aop执行顺序，要优于aop事务层
 */

@Component
@Aspect
@Order(1)
public class DataSourceAspect {

	@Pointcut("execution(* com.liantuo.server.service.impl..*.*(..))")
	public void aspectjMethod() {
	}

	// service方法执行之前被调用
	@Before(value = "aspectjMethod()")
	public void before(JoinPoint joinPoint) throws Throwable {
/*		System.out.println("---------------");
        System.out.println("@Before：目标方法为：" + 
        		joinPoint.getSignature().getDeclaringTypeName() + 
                "." + joinPoint.getSignature().getName());
        System.out.println("@Before：参数为：" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("@Before：被织入的目标对象为：" + joinPoint.getTarget());*/
        
/*        Object[] array= joinPoint.getArgs();
        if(null!=array&&array.length>0){
        	System.out.println((String)array[0]);
        	DataSourceContextHolder.setDbType((String)array[0]);
        }*/
        
        
        String classType = joinPoint.getTarget().getClass().getName();   
        Class<?> clazz = Class.forName(classType);  
        String clazzName = clazz.getName();    
        String methodName = joinPoint.getSignature().getName(); //获取方法名称   
        Object[] array= joinPoint.getArgs();//参数集
        
        //获取参数名称和值  
        Map<String,Object > nameAndArgs = getFieldsName(this.getClass(), clazzName, methodName,array);   
        //System.out.println(nameAndArgs.toString()); 
        //System.out.println(nameAndArgs.get("dbType"));
        if(null!=nameAndArgs&&null!=nameAndArgs.get("dbType")&&!"".equals((String)nameAndArgs.get("dbType"))){
        	//System.out.println("进入dbtype");
        	DataSourceContextHolder.setDbType((String)nameAndArgs.get("dbType"));
        }else{
        	DataSourceContextHolder.setDbType("DB1");
        }
        
	}
	
	//获取参数名称和值
	private Map<String,Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws NotFoundException {   
        Map<String,Object > map=new HashMap<String,Object>();  
          
        ClassPool pool = ClassPool.getDefault();    
        //ClassClassPath classPath = new ClassClassPath(this.getClass());    
        ClassClassPath classPath = new ClassClassPath(cls);    
        pool.insertClassPath(classPath);    
            
        CtClass cc = pool.get(clazzName);    
        CtMethod cm = cc.getDeclaredMethod(methodName);    
        MethodInfo methodInfo = cm.getMethodInfo();  
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();    
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);    
        if (attr == null) {    
            // exception    
        }    
       // String[] paramNames = new String[cm.getParameterTypes().length];    
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;    
        for (int i = 0; i < cm.getParameterTypes().length; i++){    
            map.put( attr.variableName(i + pos),args[i]);//paramNames即参数名    
        }    
          
        //Map<>  
        return map;    
    } 

}
