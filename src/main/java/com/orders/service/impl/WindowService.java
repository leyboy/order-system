package com.orders.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.orders.dao.WindowMapper;
import com.orders.entity.Menu;
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

	public List<Menu> listMenusByCondition(Menu condition, Integer pageSize, Integer pageNum) {
		return this.getDao().listMenusByCondition(condition, pageSize, pageNum);
	}
	
	
	public Integer countMenusByCondition(Menu condition){
		return this.getDao().countMenusByCondition(condition);
	}
}
