package com.orders.service.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.orders.dao.OrderMapper;
import com.orders.entity.Customer;
import com.orders.entity.Order;
import com.orders.entity.Window;
import com.orders.service.BaseService;
import com.orders.util.OrderCodeUtils;
import com.orders.util.UUID;
import com.orders.vo.MenuOrderVo;
import com.orders.vo.OrderSaveVo;
import com.orders.vo.OrderShowVo;
import com.orders.vo.OrderVo1;

@Service("orderService")
public class OrderService extends BaseService<OrderMapper, Order, String> {
	
	/**
	 * 取货号
	 * **/
	private static Integer count=1;
	
	/**
	 * 订单缓存区
	 * **/
	private static Map<String, OrderShowVo> orderShowMap;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private WindowService windowService;
	
	
	private static Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	
	static{
		orderShowMap=new HashMap<>(100);
	}

	@Override
	public Integer deleteByPrimaryKey(String primaryKey) {
		// TODO Auto-generated method stub
		return this.getDao().deleteByPrimaryKey(primaryKey);
	}

	@Override
	public Integer insert(Order record) {
		// TODO Auto-generated method stub
		return this.getDao().insert(record);
	}

	@Override
	public Integer insertSelective(Order record) {
		// TODO Auto-generated method stub
		return this.getDao().insertSelective(record);
	}

	@Override
	public Order getByPrimaryKey(String primaryKey) {
		// TODO Auto-generated method stub
		return this.getDao().selectByPrimaryKey(primaryKey);
	}

	@Override
	public Integer updateByPrimaryKeySelective(Order record) {
		// TODO Auto-generated method stub
		return this.getDao().updateByPrimaryKey(record);
	}

	@Override
	public Integer updateByPrimaryKey(Order record) {
		// TODO Auto-generated method stub
		return this.getDao().updateByPrimaryKey(record);
	}

	public List<OrderVo1> listOrderVo1s(String windowId) {
		return this.getDao().listOrderVo1s(windowId);
	}
	
	
	
	/**
	 * 保存顾客订单
	 * **/
	public void saveCustomerOrder(OrderSaveVo orderVo){
		List<MenuOrderVo> menuOrderVos = orderVo.getMenuOrderVos();
		Order saveOrderTemp=null;
		int totalManey=0;
		if (!CollectionUtils.isEmpty(menuOrderVos)) {
			Date currentDate = new Date(System.currentTimeMillis());
			logger.info("menuOrderVos:{}",Arrays.asList(menuOrderVos));
			String orderCode=OrderCodeUtils.generateOrderCode(currentDate);
			for (MenuOrderVo menuOrderVo : menuOrderVos) {
				totalManey+=(menuOrderVo.getMenuDishPrice()*menuOrderVo.getOrderDishNumber());
				saveOrderTemp=saveCustomerOrderHelper1(orderVo, currentDate, orderCode, menuOrderVo);
			}
			count++;
		} 
		
		//展示订单到缓存中
		OrderShowVo orderShowVo=new OrderShowVo();
		orderShowVo.setMenuOrderVos(menuOrderVos);
		Customer customer=customerService.getByPrimaryKey(orderVo.getCustomerId());
		orderShowVo.setCustomer(customer);
		Window window=windowService.getByPrimaryKey(orderVo.getWindowId());
		orderShowVo.setWindow(window);
		orderShowVo.setTotalManey(totalManey);
		orderShowVo.setOrderCode(saveOrderTemp.getOrderCode());
		orderShowVo.setOrderTime(orderVo.getOrderTimeShow());
		logger.info("orderShowVo:{},orderCode:{},totalManey:{}",orderShowVo,saveOrderTemp.getOrderCode(),
				orderShowVo.getTotalManey());
		orderShowMap.put(saveOrderTemp.getOrderCode(), orderShowVo);
	}
	
	
	private Order saveCustomerOrderHelper1(OrderSaveVo orderVo,Date currentDate,String orderCode,
			MenuOrderVo menuOrderVo){
		Order saveOrder = new Order();
		saveOrder.setWindowId(orderVo.getWindowId()); //设置窗口Id
		saveOrder.setOrderTime(currentDate); // 设置下单时间
		saveOrder.setOrderId(UUID.randomUUID()); //设置订单主键
		saveOrder.setMenuId(menuOrderVo.getMenuId()); // 设置menuId
		saveOrder.setOrderDishNumber(menuOrderVo.getOrderDishNumber()); // 设置订购菜品的数量
		saveOrder.setOrderCode(orderCode);// 设置订单号
		saveOrder.setOrderPickNumber(count); // 设置取货号
		saveOrder.setCustomerId(orderVo.getCustomerId());//设置顾客Id
		saveOrder.setOrderState(0);  //设置订单状态
		this.getDao().insertSelective(saveOrder);
		return saveOrder;
	}
	
	
	/**
	 * 根据订单号获取订单详情
	 * **/
	public OrderShowVo getCustomerOrderByOrderCode(String orderCode){
		logger.info("orderShowVo:{}",orderShowMap.get(orderCode));
		return orderShowMap.get(orderCode);
	}
	
	
	/**
	 * 获取顾客总订单
	 * **/
	public List<OrderShowVo> getCustomerOrdersByCustomerId(String customerId){
		Map<String, OrderShowVo> map=orderShowMap;
		List<OrderShowVo> orderShowVos=new ArrayList<>();
		for(Map.Entry<String, OrderShowVo> orderShowVoEntry : map.entrySet()){
			OrderShowVo orderShowVo=orderShowVoEntry.getValue();
			if(customerId.equals(orderShowVo.getCustomer().getCustomerId())){
				orderShowVos.add(orderShowVo);
			}
		}
		return orderShowVos;
	}
	

	/**
	 * 获取窗口的总订单
	 * 
	 * @param windowId
	 *            窗口id
	 **/
	public List<OrderShowVo> getWindowOrders(String windowId) {
		Map<String, OrderShowVo> map=orderShowMap;
		List<OrderShowVo> orderShowVos=new ArrayList<>();
		for(Map.Entry<String, OrderShowVo> orderShowVoEntry : map.entrySet()){
			OrderShowVo orderShowVo=orderShowVoEntry.getValue();
			if(windowId.equals(orderShowVo.getWindow().getWindowId())){
				orderShowVos.add(orderShowVo);
			}
		}
		return orderShowVos;
	}
}
