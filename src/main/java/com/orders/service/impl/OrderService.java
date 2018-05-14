package com.orders.service.impl;

import org.springframework.stereotype.Service;


import com.orders.dao.OrderMapper;
import com.orders.entity.Order;
import com.orders.service.BaseService;

@Service("orderService")
public class OrderService extends BaseService<OrderMapper, Order, String> {

	@Override
	public Integer deleteByPrimaryKey(String primaryKey) {
		// TODO Auto-generated method stub
		return this.getDao().deleteByPrimaryKey(primaryKey);
	}

	@Override
	public Integer insert(Order record) {
		// TODO Auto-generated method stub
		return this.getDao().insert(record);
	}

	@Override
	public Integer insertSelective(Order record) {
		// TODO Auto-generated method stub
		return this.getDao().insertSelective(record);
	}

	@Override
	public Order getByPrimaryKey(String primaryKey) {
		// TODO Auto-generated method stub
		return this.getDao().selectByPrimaryKey(primaryKey);
	}

	@Override
	public Integer updateByPrimaryKeySelective(Order record) {
		// TODO Auto-generated method stub
		return this.getDao().updateByPrimaryKey(record);
	}

	@Override
	public Integer updateByPrimaryKey(Order record) {
		// TODO Auto-generated method stub
		return this.getDao().updateByPrimaryKey(record);
	}

}
