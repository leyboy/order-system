package com.orders.dao;

import org.apache.ibatis.annotations.Mapper;

import com.orders.entity.Order;

@Mapper
public interface OrderMapper {
	
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}