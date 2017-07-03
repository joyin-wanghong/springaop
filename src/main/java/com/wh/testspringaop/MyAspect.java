package com.wh.testspringaop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;

public class MyAspect implements Ordered {

	public Log logger = LogFactory.getLog(MyAspect.class);
	public int getOrder() {
		return 0;
	}
	
	/**
	 * 增强方法
	 *@param pj 
	 *@author 汪宏
	 *@date 2017年7月3日 下午2:17:16 
	 *@comment
	 */
	public Object excute(ProceedingJoinPoint pj){
		logger.info("开始执行增强方法。");
		//调用原方法
		Object[] arg = pj.getArgs();				//获取原方法参数
		arg[0] = "xxxxk";							//修改参数
		Object returnvlue = null;
		try {
			returnvlue = pj.proceed(arg);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		logger.info("实际的返回值："+returnvlue);
		
		logger.info("执行增强方法结束。");
		
		return returnvlue;			//注意：这里一定要反回一个值，要不然，调用原方法就没有返回值了。当然这里也可以修改返回值。
	}

}
