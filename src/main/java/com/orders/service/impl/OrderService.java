package com.orders.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.orders.dao.OrderMapper;
import com.orders.entity.Customer;
import com.orders.entity.Menu;
import com.orders.entity.Order;
import com.orders.entity.Window;
import com.orders.service.BaseService;
import com.orders.util.DateUtils;
import com.orders.util.OrderCodeUtils;
import com.orders.util.OrdersConstants;
import com.orders.util.RandomUtils;
import com.orders.util.UUID;
import com.orders.vo.MenuOrderVo;
import com.orders.vo.OrderSaveVo;
import com.orders.vo.OrderShowVo;
import com.orders.vo.OrderVo1;

@Service("orderService")
public class OrderService extends BaseService<OrderMapper, Order, String> {

	/**
	 * 取货号
	 **/
	private static Integer count = 1;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private WindowService windowService;

	@Autowired
	private MenuService menuService;

	private static Logger logger = LoggerFactory.getLogger(OrderService.class);

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
	 **/
	public void saveCustomerOrder(OrderSaveVo orderVo) {
		List<MenuOrderVo> menuOrderVos = orderVo.getMenuOrderVos();
		if (!CollectionUtils.isEmpty(menuOrderVos)) {
			Date currentDate = new Date(System.currentTimeMillis());
			logger.info("menuOrderVos:{}", Arrays.asList(menuOrderVos));
			String orderCode = OrderCodeUtils.generateOrderCode(currentDate);
			for (MenuOrderVo menuOrderVo : menuOrderVos) {
				saveCustomerOrderHelper1(orderVo, currentDate, orderCode, menuOrderVo);
			}
			count++;
		}
	}

	private Order saveCustomerOrderHelper1(OrderSaveVo orderVo, Date currentDate, String orderCode,
			MenuOrderVo menuOrderVo) {
		Order saveOrder = new Order();
		saveOrder.setWindowId(menuOrderVo.getWindowId()); // 设置窗口Id
		saveOrder.setOrderTime(currentDate); // 设置下单时间
		saveOrder.setOrderId(UUID.randomUUID()); // 设置订单主键
		saveOrder.setMenuId(menuOrderVo.getMenuId()); // 设置menuId
		saveOrder.setOrderDishNumber(menuOrderVo.getOrderDishNumber()); // 设置订购菜品的数量
		saveOrder.setOrderCode(orderCode);// 设置订单号
		saveOrder.setOrderPickNumber(count); // 设置取货号
		Customer customer=customerService.login(null, orderVo.getCustomerNumber());
		saveOrder.setCustomerId(customer.getCustomerId());// 设置顾客Id
		saveOrder.setOrderState(0); // 设置订单状态
		this.getDao().insertSelective(saveOrder);
		return saveOrder;
	}

	/**
	 * 根据订单号获取订单详情
	 **/
	public OrderShowVo getCustomerOrderByOrderCode(String orderCode, String customerId, String windowId) {
		List<OrderShowVo> orderShowVos = this.getCustomerOrWindowOrderShowVos(customerId, windowId);
		for (OrderShowVo orderShowVo : orderShowVos) {
			if (orderCode.equals(orderShowVo.getOrderCode())) {
				return orderShowVo;
			}
		}
		return null;
	}

	/**
	 * 根据顾客Id或者窗口Id获取订单号
	 **/
	public List<String> getCustomerOrWindowOrderCodes(String customerId, String windowId) {
		return this.getDao().listCustomerOrWindowOrderCodes(customerId, windowId);
	}

	/**
	 * 获取窗口或者顾客的总订单
	 **/
	public List<OrderShowVo> getCustomerOrWindowOrderShowVos(String customerNumber, String windowId) {
		List<OrderShowVo> orderShowVos = new ArrayList<>();
		Customer customerTmp=customerService.login(null, customerNumber);
		List<String> customerOrderCodes = this.getDao().listCustomerOrWindowOrderCodes(customerTmp.getCustomerId(), windowId);
		logger.info("customerOrderCodes:{}", Arrays.asList(customerOrderCodes));
		for (String orderCode : customerOrderCodes) {

			List<Order> orders = this.getDao().getCustomerOrderByOrderCode(orderCode);
			Order helpOrder = orders.get(0);
			logger.info("helpOrder:{}", helpOrder);
			OrderShowVo orderShowVo = new OrderShowVo();
			Customer customer = customerService.getByPrimaryKey(helpOrder.getCustomerId());
			orderShowVo.setCustomerName(customer.getCustomerName());// 设置顾客姓名
		
			orderShowVo.setCustomerNumber(customer.getCustomerNumber()); // 设置顾客学号
			orderShowVo.setOrderPickNumber(helpOrder.getOrderPickNumber());// 设置取货号
			orderShowVo.setOrderCode(orderCode); // 设置订单号
			orderShowVo
					.setOrderTime(DateUtils.dateToString(helpOrder.getOrderTime(), DateUtils.yyyy_MM_dd_HH_mm_ss_EN));
			List<MenuOrderVo> menuOrderVos = new ArrayList<>();

			int totalManey = 0;//总价钱
			double discount=OrdersConstants.DISCOUNT_ARRAY[RandomUtils.nextInt(4)];
			for (Order order : orders) { // 设置菜品
				MenuOrderVo menuOrderVo = new MenuOrderVo();
				Menu menu = menuService.getByPrimaryKey(order.getMenuId());
				Window window=windowService.getByPrimaryKey(order.getWindowId());
				menuOrderVo.setMenuId(menu.getMenuId()); // 设置菜名Id
				menuOrderVo.setOrderDishNumber(order.getOrderDishNumber()); // 设置订购菜品数量
				menuOrderVo.setMenuDishPrice(menu.getMenuDishPrice()); // 设置菜品价格
				menuOrderVo.setMenuDishName(menu.getMenuName()); // 设置菜品名
				menuOrderVo.setWindowName(window.getWindowName()); //设置窗口名
				menuOrderVos.add(menuOrderVo);
				totalManey += (menuOrderVo.getMenuDishPrice() * menuOrderVo.getOrderDishNumber()*
						discount);
			}
			orderShowVo.setDiscount(discount);//设置折扣
			orderShowVo.setMenuOrderVos(menuOrderVos);// 设置菜品集合
			orderShowVo.setTotalManey(totalManey); // 设置总价钱
			logger.info("orderShowVo:{}", orderShowVo);
			orderShowVos.add(orderShowVo);
		}
		return orderShowVos;
	}
	
	 
}
