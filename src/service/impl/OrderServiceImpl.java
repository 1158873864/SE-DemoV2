package service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import data.datahelper.DataFactory;
import data.datahelper.impl.DataFactoryImpl;
import po.OrderPo;
import service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	private OrderDao orderDataService;
	
	public OrderServiceImpl(){
		orderDataService = OrderDaoImpl.getInstance();
	}

	public List<OrderPo> getAllOrders(int hotelId) {
		return orderDataService.getOrders(hotelId);
	}

	public List<OrderPo> getUnfinishedOrders(int hotelId) {
		List<OrderPo> list = new ArrayList<OrderPo>();
		List<OrderPo> orders = getAllOrders(hotelId);
		for (OrderPo orderPo : orders) {
			if(orderPo.getStatus() == 0){
				list.add(orderPo);
			}
		}
		return list;
	}

	public List<OrderPo> getFinishedOrders(int hotelId) {
		List<OrderPo> list = new ArrayList<OrderPo>();
		List<OrderPo> orders = getAllOrders(hotelId);
		for (OrderPo orderPo : orders) {
			if(orderPo.getStatus() == 1){
				list.add(orderPo);
			}
		}
		return list;
	}

	public List<OrderPo> getAbnormalOrders(int hotelId) {
		List<OrderPo> list = new ArrayList<OrderPo>();
		List<OrderPo> orders = getAllOrders(hotelId);
		for (OrderPo orderPo : orders) {
			if(orderPo.getStatus() == 2){
				list.add(orderPo);
			}
		}
		return list;
	}

	public OrderPo getOrder(int orderId) {
		return orderDataService.getOrder(orderId);
	}

	public boolean finishOrder(int orderId) {
		OrderPo orderPo = orderDataService.getOrder(orderId);
		if(orderPo != null){
			//检查订单状态是否为未执行
			if(orderPo.getStatus() == 0){
				//修改订单状态
				orderPo.setStatus(1);
				//设置订单执行时间
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String time=format.format(date);
				orderPo.setEntryTime(time);
				//修改订单
				return orderDataService.updateOrder(orderPo);
				
			}
		}
		return false;
	}

	public boolean delayOrder(int orderId, String delayTime) {
		OrderPo orderPo = orderDataService.getOrder(orderId);
		if(orderPo != null){
			//检查订单状态是否为异常订单
			if(orderPo.getStatus() == 2){
				//修改订单状态
				orderPo.setStatus(0);
				//修改订单最晚执行时间
				orderPo.setLastTime(delayTime);
				//修改订单
				return orderDataService.updateOrder(orderPo);
			}
		}
		return false;
	}
	

}
