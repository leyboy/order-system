package com.orders.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.List;

public class GsonUtil {

	public static Gson getGson() {
		return (new GsonBuilder()).serializeNulls().setDateFormat(OrdersConstants.DATE_FORMAT).create();
	}

	public static String toJson(Object obj) {
		return getGson().toJson(obj);
	}

	public static String toJson(Object obj, Type type) {
		return getGson().toJson(obj, type);
	}

	public static <T> String t2Json(T t) {
		return getGson().toJson(t);
	}

	public static <T> T json2T(String jsonString, Class<T> clazz) {
		return getGson().fromJson(jsonString, clazz);
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> json2Collection(String jsonStr, Type type) {
		return (List<T>) getGson().fromJson(jsonStr, type);
	}

	public static <T> T fromJson(String jsonStr, Type type) {
		return getGson().fromJson(jsonStr, type);
	}

	public static <T> T fromJson(String jsonStr, Class<T> clazz) {
		return getGson().fromJson(jsonStr, clazz);
	}
}