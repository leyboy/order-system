package com.orders.aspect.service;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.orders.util.OrdersConstants;

@Aspect
@Component
public class TimeAspect {
	
	private static Logger logger = LoggerFactory.getLogger(TimeAspect.class);

	/**
	 * 匹配service层的方法
	 */
	@Pointcut(value = OrdersConstants.SERVICE_POINTCUT_EXECUTION)
	private void servicePointcut() {
	}

	@Around(value = "servicePointcut()")
	public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime=System.currentTimeMillis();
		Object result=joinPoint.proceed();
		long endTime=System.currentTimeMillis();
		logger.info(joinPoint.getTarget().getClass()+"."+joinPoint.getSignature().getName()
				+"方法耗时: {}",(endTime-startTime)+"ms");
		return result;
	}
}
