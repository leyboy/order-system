package com.orders.dao;


import org.apache.ibatis.annotations.Mapper;

import com.orders.entity.Window;

@Mapper
public interface WindowMapper {
    int deleteByPrimaryKey(String windowId);

    int insert(Window record);

    int insertSelective(Window record);

    Window selectByPrimaryKey(String windowId);

    int updateByPrimaryKeySelective(Window record);

    int updateByPrimaryKey(Window record);
  
}