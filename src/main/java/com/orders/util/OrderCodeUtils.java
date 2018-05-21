package com.orders.util;

import java.util.Date;

public class OrderCodeUtils {

	/**
	 * 生成订单号:格式:当前时间+随机5位数字
	 * **/
	public static String generateOrderCode(Date date){
		String orderCode="";
		String dateString=DateUtils.dateToString(date, DateUtils.yyyy_MM_dd_HH_mm_ss);
		orderCode+=(dateString+RandomUtils.randomNumberString(5));
		return orderCode;
	}
}
