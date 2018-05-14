package com.orders.dao;

import org.apache.ibatis.annotations.Mapper;

import com.orders.entity.Customer;

@Mapper
public interface CustomerMapper {
    int deleteByPrimaryKey(String customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}