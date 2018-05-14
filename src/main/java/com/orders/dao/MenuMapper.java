package com.orders.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.orders.entity.Menu;

@Mapper
public interface MenuMapper {
	
    int deleteByPrimaryKey(String menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
   
    List<Menu> listMenusByCondition(@Param("condition") Menu condition,
         @Param("pageSize")	Integer pageSize,@Param("pageNum") Integer pageNum);
}