package com.wh.testspringaop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class TestBean {
	protected Log logger= LogFactory.getLog(TestBean.class);
	public String outStr(String var) {
		logger.info("开始运行原程序，参数"+var);
		return "返回结果"+var;
	}
}
