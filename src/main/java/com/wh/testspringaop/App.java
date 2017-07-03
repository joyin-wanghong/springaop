package com.wh.testspringaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * aaaa
 */
public class App {
	public static void main(String[] args) {
		// GenericXmlApplicationContext context = new
		// GenericXmlApplicationContext();
		// context.setValidating(false);
		// context.load("classpath*:applicationContext*.xml");
		// context.refresh();

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/springmvc.xml");// 此文件放在SRC目录下

		TestBean testbean = (TestBean)context.getBean("testbean");
		testbean.outStr("aa");
	}


}
