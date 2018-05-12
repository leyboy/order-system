package com.orders.service.impl;

import org.springframework.stereotype.Service;

import com.orders.dao.CustomerMapper;
import com.orders.entity.Customer;
import com.orders.service.BaseService;

@Service("customerService")
public class CustomerService extends BaseService<CustomerMapper,Customer,Integer> {

	@Override
	public Integer deleteByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return this.getDao().deleteByPrimaryKey(primaryKey);
	}

	@Override
	public Integer insert(Customer record) {
		// TODO Auto-generated method stub
		return this.getDao().insert(record);
	}

	@Override
	public Integer insertSelective(Customer record) {
		// TODO Auto-generated method stub
		return this.getDao().insertSelective(record);
	}

	@Override
	public Customer getByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return this.getDao().selectByPrimaryKey(primaryKey);
	}

	@Override
	public Integer updateByPrimaryKeySelective(Customer record) {
		// TODO Auto-generated method stub
		return this.getDao().updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer updateByPrimaryKey(Customer record) {
		// TODO Auto-generated method stub
		return this.getDao().updateByPrimaryKey(record);
	}

}
