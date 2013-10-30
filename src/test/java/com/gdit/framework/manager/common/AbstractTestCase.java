package com.gdit.framework.manager.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstractTestCase {

	protected ApplicationContext context = null;

	public AbstractTestCase() {
		context = new ClassPathXmlApplicationContext(getConfigurations());
	}

	public String[] getConfigurations() {

		return new String[] {
				"classpath:config/spring/spring-core.xml",
				"classpath:data/*-data.xml"
		};

	}

}
