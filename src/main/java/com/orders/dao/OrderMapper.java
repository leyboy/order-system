package com.orders.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.orders.entity.Order;
import com.orders.vo.OrderVo1;

@Mapper
public interface OrderMapper {
	
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    /**
     * 获取窗口每种菜品的订单订的数量
     * @param windowId
     * 			订单数
     * **/
    List<OrderVo1> listOrderVo1s(@Param("windowId") String windowId);
}