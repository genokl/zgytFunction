package cn.zgyt.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/***
 * spring管理bean的工具类
 * 
 * @author wxy
 *
 */
public class SpringUtil implements DisposableBean, ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	public void setApplicationContext(ApplicationContext paramApplicationContext) {
		applicationContext = paramApplicationContext;
	}

	public void destroy() {
		applicationContext = null;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	/**
	 * 根据Bean名称获取实例
	 * 
	 * @param name
	 *            Bean注册名称
	 * 
	 * @return bean实例
	 * 
	 * @throws BeansException
	 */
	public static Object getBean(String paramString) {
		return applicationContext.getBean(paramString);
	}
}
