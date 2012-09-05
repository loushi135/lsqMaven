package com.lsq.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppContext {

	private static AppContext instance;

	private ApplicationContext appContext;

	public synchronized static AppContext getInstance() {
		if (instance == null) {
			instance = new AppContext();
		}
		return instance;
	}

	private AppContext() {
		this.appContext = new ClassPathXmlApplicationContext("../spring/applicationContext.xml");
	}

	public ApplicationContext getAppContext() {
		return appContext;
	}
}