package com.orders.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RequestInfoFilter用来拦截请求响应时间
 **/
public class RequestInfoFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(RequestInfoFilter.class);

	/**
	 * 忽略拦截的文件类型
	 **/
	private static final List<String> IGNORE_LIST = new ArrayList<>();

	public void init(FilterConfig filterConfig) throws ServletException {
		IGNORE_LIST.add("js");
		IGNORE_LIST.add("css");
		IGNORE_LIST.add("png");
		IGNORE_LIST.add("ico");
		IGNORE_LIST.add("gif");
		IGNORE_LIST.add("jpg");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		try {
			long startTime = System.currentTimeMillis();
			String uri = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());
			if (!isIgnore(uri)) {
				logger.info("==================== RequestInfoFilter Start ====================");
				logger.info(request.getMethod() + " : " + uri); // 打印请求的url
				logger.info("session存活时间：" + request.getSession().getMaxInactiveInterval());// 打印请求session最大存活时间
				this.logHeaders(request); //http请求头信息
				this.logParams(request);  //http请求参数
				this.logAttr(request);  //http请求附加信息
				chain.doFilter(request, response);
				long endTime = System.currentTimeMillis();
				logger.info(request.getMethod() + " " + "耗时：" + (endTime - startTime) + " ms");
				logger.info("==================== RequestInfoFilter End ====================");
			} else {
				chain.doFilter(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 打印头信息日志
	 **/
	private void logHeaders(HttpServletRequest request) {
		Map<String, String> headerMap = new HashMap<>();
		Enumeration<String> headers = request.getHeaderNames();

		while (headers.hasMoreElements()) {
			String headName = (String) headers.nextElement();
			if (headName != null && !"".equals(headName)) {
				headerMap.put(headName, request.getHeader(headName));
			}
		}

		headerMap.put("RemoteHost", request.getRemoteHost() + ":" + request.getRemotePort());
		logger.info("请求头信息: "+headerMap.toString());
	}

	/**
	 * 打印HTTP参数信息
	 **/
	private void logParams(HttpServletRequest request) {
		Map<String, String> maps = new HashMap<>();
		Enumeration<String> keys = request.getParameterNames();

		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			if (StringUtils.isNotEmpty(key)) {
				String values = request.getParameter(key);
				maps.put(key, values);
			}
		}
		logger.info(maps.toString());
	}

	/**
	 * 打印额外属性信息
	 **/
	private void logAttr(HttpServletRequest request) {
		Map<String, Object> maps = new HashMap<>();
		Enumeration<String> keys = request.getAttributeNames();

		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			if (StringUtils.isNotEmpty(key)) {
				Object values = request.getAttribute(key);
				maps.put(key, values);
			}
		}
		logger.info(maps.toString());
	}

	private static final boolean isIgnore(String url) {
		boolean ignore = false;
		int index = url.lastIndexOf(".");
		if (index > 0) {
			String subfix = url.substring(index + 1, url.length());
			if (IGNORE_LIST.contains(subfix)) {
				ignore = true;
			}
		}
		return ignore;
	}
}