package com.wh.testspringaop;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;

//@Aspect 可以不用加这个注解，因为已经在springmvc.xml里面指定了
//其它几种注解：@AfterReturning,@Around,@Before,@After
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
	 *@comment	这个方法为around类型的切入点，由springmvc.xml里做了绑定，所以不用加注解
	 */
	public Object excute(ProceedingJoinPoint pj){
		logger.info("around:开始执行增强方法。");
		//调用原方法
		Object[] arg = pj.getArgs();				//获取原方法参数
		arg[0] = "xxxxk";							//修改参数
		Object returnvlue = null;
		try {
			returnvlue = pj.proceed(arg);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		logger.info("around:实际的返回值："+returnvlue);
		
		logger.info("around:执行增强方法结束。");
		
		return returnvlue;			//注意：这里一定要反回一个值，要不然，调用原方法就没有返回值了。当然这里也可以修改返回值。
	}
	
	/**
	 * 测试Before增强类型
	 *@param point 
	 *@author 汪宏
	 *@date 2017年7月3日 下午2:55:59 
	 *@comment
	 */
	public void before(JoinPoint point){
		logger.info("before:执行原方法前执行增强方法。");
		logger.info("@Before：目标方法为：" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
		logger.info("@Before：参数为：" + Arrays.toString(point.getArgs()));
		logger.info("@Before：被织入的目标对象为：" + point.getTarget());
	}
	
	/**
	 * 测试AfterReturning增强类型
	 * 注意：AfterReturning只有在目标方法正确执行后才会被植入
	 *@author 汪宏
	 *@date 2017年7月3日 下午2:56:42 
	 *@comment
	 */
	public void afterreturning(JoinPoint point,Object returnvalue){
		logger.info("afterreturning:增强方法"+returnvalue);
	}
	
	/**
	 * 测试AfterReturning增强类型
	 * 注意： After增强处理不管目标方法如何结束（正确还是异常），它都会被织入
	 *@author 汪宏
	 *@date 2017年7月3日 下午2:56:42 
	 *@comment
	 */
	public void after(JoinPoint point){
		logger.info("after:增强方法");
	}
	

}
