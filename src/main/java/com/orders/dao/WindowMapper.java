package com.orders.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.orders.entity.Menu;
import com.orders.entity.Window;

@Mapper
public interface WindowMapper {
    int deleteByPrimaryKey(String windowId);

    int insert(Window record);

    int insertSelective(Window record);

    Window selectByPrimaryKey(String windowId);

    int updateByPrimaryKeySelective(Window record);

    int updateByPrimaryKey(Window record);
    
    List<Menu> listMenusByCondition(@Param("condition") Menu condition,
            @Param("pageSize")	Integer pageSize,@Param("pageNum") Integer pageNum);
    
    
    Integer countMenusByCondition(@Param("condition") Menu condition);
}