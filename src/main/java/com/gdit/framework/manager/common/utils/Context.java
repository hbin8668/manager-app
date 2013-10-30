package com.gdit.framework.manager.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {
	
	private static String configs = "config/spring/spring-core.xml";
	
	private static ApplicationContext context = null;


	private Context() {
	}

	private static void init() {
		if (context == null) {
			synchronized (Context.class) {
				if (context == null) {
					context = new ClassPathXmlApplicationContext(configs);
				}
			}
		}
	}

	
	public static Object getBean(String beanId) {
		init();
//		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		return context.getBean(beanId);
	}
	
	public static <T> T getBean(String beanName, Class<T> t) {
		init();
		return (T) context.getBean(beanName, t);
	}
	
	
	
}
