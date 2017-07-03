package com.wh.testspringaop;

import org.springframework.core.Ordered;

public class MyAspect implements Ordered {

	
	public int getOrder() {
		return 0;
	}
	
	
	public void excute(){
		System.out.println("执行增强方法。");
	}

}
