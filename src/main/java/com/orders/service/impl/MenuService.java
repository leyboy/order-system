package com.orders.service.impl;


import org.springframework.stereotype.Service;

import com.orders.dao.MenuMapper;
import com.orders.entity.Menu;
import com.orders.service.BaseService;

@Service("menuService")
public class MenuService extends BaseService<MenuMapper,Menu,String> {
	

	@Override
	public Integer deleteByPrimaryKey(String primaryKey) {
		// TODO Auto-generated method stub
		return this.getDao().deleteByPrimaryKey(primaryKey);
	}

	@Override
	public Integer insert(Menu record) {
		// TODO Auto-generated method stub
		return this.getDao().insert(record);
	}

	@Override
	public Integer insertSelective(Menu record) {
		// TODO Auto-generated method stub
		return this.getDao().insertSelective(record);
	}

	@Override
	public Menu getByPrimaryKey(String primaryKey) {
		// TODO Auto-generated method stub
		return this.getDao().selectByPrimaryKey(primaryKey);
	}

	@Override
	public Integer updateByPrimaryKeySelective(Menu record) {
		// TODO Auto-generated method stub
		return this.getDao().updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer updateByPrimaryKey(Menu record) {
		// TODO Auto-generated method stub
		return this.getDao().updateByPrimaryKey(record);
	}

}
