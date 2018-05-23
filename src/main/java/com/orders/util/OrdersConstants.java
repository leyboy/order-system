package com.orders.util;


/**
 * Orders constants
 **/
public class OrdersConstants {

	/**
	 * 拦截Controller层的切点表达式(拦截)
	 **/
	public final static String CONTROLLER_POINTCUT_EXECUTION = "execution(* com.orders.controller.*.*(..))";

	/**
	 * 拦截Service层性能的切点表达式
	 **/
	public final static String SERVICE_POINTCUT_EXECUTION = "execution(* com.orders.service.impl.*.*(..))";

	/*
	 * 拦截各模块下的Controller层的切点表达式(适合多模块项目) public final static String
	 * CONTROLLER_POINTCUT_EXECUTION =
	 * "(execution(* com.orders.*.controller.*.*(..)))";
	 */

	/**
	 * date format
	 **/
	public final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * random discount
	 **/
	public final static double[] DISCOUNT_ARRAY = { 0.9, 0.8, 0.7, 0.6, 0.5 };

}
