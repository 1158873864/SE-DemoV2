package data.service.impl;

import java.util.ArrayList;
import java.util.List;

import po.OrderPo;
import data.dao.DataFactory;
import data.dao.OrderDao;
import data.dao.impl.DataFactoryImpl;
import data.dao.impl.OrderDaoImpl;
import data.service.OrderDataService;

public class OrderDataServiceImpl implements OrderDataService{
	
	private List<OrderPo> list;
	
	private OrderDao orderDao;
	
	private DataFactory dataFactory;
	
	private static OrderDataServiceImpl orderDataServiceImpl;
	
	public static OrderDataServiceImpl getInstance(){
		if(orderDataServiceImpl == null){
			orderDataServiceImpl = new OrderDataServiceImpl();
		}
		return orderDataServiceImpl;
	}
	
	public OrderDataServiceImpl(){
		if(list == null){
			dataFactory = new DataFactoryImpl();
			orderDao = dataFactory.getOrderDao();
			list = orderDao.readFromFile();
		}
	}

	public OrderPo getOrder(int orderId) {
		for (OrderPo orderPo : list) {
			if(orderPo.getId() == orderId){
				return orderPo;
			}
		}
		return null;
	}

	public List<OrderPo> getOrders(int hotelId) {
		List<OrderPo> orderList = new ArrayList<OrderPo>();
		for (OrderPo orderPo : list) {
			if(orderPo.getHotelId() == hotelId){
				orderList.add(orderPo);
			}
		}
		return orderList;
	}

	public boolean updateOrder(OrderPo orderPo) {
		for (OrderPo op : list) {
			if(op.getId() == orderPo.getId()){
				op = orderPo;
				orderDao.writeInfoFile(list);
				return true;
			}
		}
		return false;
	}

	public boolean addOrderPo(OrderPo orderPo) {
		/*
		 * 列表中添加订单并写入数据文件中
		 */
		return false;
	}

	public boolean deleteOrderPo(int orderId) {
		/*
		 * 列表中删除订单并更新数据文件
		 */
		return false;
	}

}
