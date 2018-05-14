package com.orders.util;

public final class PageUtils {

	public final static int DEFAULT_PER_PAGE_SIZE = 10;

	/**
	 * 获取总页数
	 **/
	public static int getTotalPages(int perPageSize, int totalCount) {
		int totalPages = 0;
		if (totalCount % perPageSize == 0) {
			totalPages = totalCount / perPageSize;
		} else {
			totalPages = (totalCount / perPageSize) + 1;
		}
		return totalPages;
	}
}
