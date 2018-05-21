package com.orders.service.impl;

import org.springframework.stereotype.Service;

import com.orders.dao.WindowMapper;
import com.orders.entity.Window;
import com.orders.service.BaseService;

@Service(value = "windowService")
public class WindowService extends BaseService<WindowMapper, Window, String> {

	@Override
	public Integer deleteByPrimaryKey(String primaryKey) {
		// TODO Auto-generated method stub
		return this.getDao().deleteByPrimaryKey(primaryKey);
	}

	@Override
	public Integer insert(Window record) {
		// TODO Auto-generated method stub
		return this.getDao().insert(record);
	}

	@Override
	public Integer insertSelective(Window record) {
		// TODO Auto-generated method stub
		return this.getDao().insertSelective(record);
	}

	@Override
	public Window getByPrimaryKey(String primaryKey) {
		// TODO Auto-generated method stub
		return this.getDao().selectByPrimaryKey(primaryKey);
	}

	@Override
	public Integer updateByPrimaryKeySelective(Window record) {
		// TODO Auto-generated method stub
		return this.getDao().updateByPrimaryKey(record);
	}

	@Override
	public Integer updateByPrimaryKey(Window record) {
		// TODO Auto-generated method stub
		return this.getDao().updateByPrimaryKey(record);
	}

	/**
	 * 根据窗口名登录
	 **/
	public Window loginWindow(String windowName) {
		Window findWindow = this.getDao().getWindowByWindowName(windowName);
		return findWindow;
	}
}
