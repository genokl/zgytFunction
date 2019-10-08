package cn.zgyt.aop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.zgyt.entiry.user.MyException;
import cn.zgyt.repository.MyExceptionRepository;

@Aspect
@Component
public class WebLogAspect {
    
	public static List<MyException> exceptionLog=new ArrayList<MyException>();
	
	@Autowired
	private MyExceptionRepository rep;
	
    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    
    @Pointcut("execution(public * cn.zgyt.controller.*.*(..))")//切入点描述 这个是controller包的切入点
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称
    
    
//    @Before("controllerLog()") //在切入点的方法run之前要干的
//    public void logBeforeController(JoinPoint joinPoint) {
//        
//        
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
//        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
//        
//         // 记录下请求内容
//        logger.info("################URL : " + request.getRequestURL().toString());
//        logger.info("################HTTP_METHOD : " + request.getMethod());
//        logger.info("################IP : " + request.getRemoteAddr());
//        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
//        
//        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
//        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        //logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
//        //logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象
//
//    }
    @AfterThrowing(value="controllerLog()", throwing = "e") //在切入点的方法run之前要干的
    public void logAfterController(JoinPoint joinPoint,Exception e) {
    	
    	RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
    	HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
    	
    	MyException exception = new MyException();
    	exception.setUrl(request.getRequestURL().toString());
    	exception.setMethod(request.getMethod());
    	exception.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    	exception.setArgs(Arrays.toString(joinPoint.getArgs()));
    	exception.setIp(request.getRemoteAddr());
    	exception.setExceptionName(e.toString());
    	exception.setCreateDate(new Date());
//    	rep.save(exception);
    	if(!exceptionLog.contains(exception)) {
    		exceptionLog.add(exception);
    	}
    	// 记录下请求内容
    }
   

}