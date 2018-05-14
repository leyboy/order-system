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
    
    /**
     * 根据情况列出不同菜品
     * @param condition
     * 			查询条件
     * @param pageNum
     * 			当前页
     * @param pageSize
     * 			每页的记录数
     * **/
    List<Menu> listMenusByCondition(@Param("condition") Menu condition,
    	 @Param("pageSize")	Integer pageSize,@Param("pageNum") Integer pageNum);
}