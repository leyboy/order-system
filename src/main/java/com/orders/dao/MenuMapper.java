package com.orders.dao;


import org.apache.ibatis.annotations.Mapper;

import com.orders.entity.Menu;

@Mapper
public interface MenuMapper {
	
    int deleteByPrimaryKey(String menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}