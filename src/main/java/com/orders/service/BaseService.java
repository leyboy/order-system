package com.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Base service <br>
 * T1:泛型T1是dao类或者接口 <br>
 * T2:泛型T2是插入或者更新的实体类 <br>
 * T3:泛型T3是删除或者单个查询的类型
 **/
@Component
public abstract class BaseService<T1, T2, T3> {

	@Autowired
	private T1 dao;

	/**
	 * 获得DAO层对象
	 * 
	 * @return Returns dao层对象
	 **/
	public T1 getDao() {
		return dao;
	}

	/**
	 * 按主键删除
	 * 
	 * @param primaryKey
	 *            按主键删除记录
	 **/
	public abstract Integer deleteByPrimaryKey(T3 primaryKey);

	/**
	 * 完全插入记录
	 * 
	 * @param record
	 *            需要插入的记录
	 * @return 插入记录的数
	 **/
	public abstract Integer insert(T2 record);

	/**
	 * 选择性插入记录
	 * 
	 * @param record
	 *            需要插入的记录
	 * @return 插入记录的数
	 **/
	public abstract Integer insertSelective(T2 record);

	/**
	 * 按主键查询记录
	 * @param primaryKey
	 * 			主键
	 * @return 返回当前主键的记录
	 * **/
	public abstract T2 getByPrimaryKey(T3 primaryKey);

	/**
	 * 更新记录
	 * 
	 * @param record
	 *            需要更新的记录
	 * @return 更新记录的数
	 **/
	public abstract Integer updateByPrimaryKeySelective(T2 record);

	/**
	 * 选择性更新记录
	 * 
	 * @param record
	 *            需要更新的记录
	 * @return 更新记录的数
	 **/
	public abstract Integer updateByPrimaryKey(T2 record);
}
