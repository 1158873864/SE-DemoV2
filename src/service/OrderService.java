package service;

import java.util.List;

import po.OrderPo;

public interface OrderService {
	
	/**
	 * @param hotelId
	 * @return	获取酒店所有订单列表
	 */
	public List<OrderPo> getAllOrders(int hotelId);
	
	/**
	 * @param hotelId
	 * @return	获取酒店未执行订单列表
	 */
	public List<OrderPo> getUnfinishedOrders(int hotelId);
	
	/**
	 * @param hotelId
	 * @return	获取酒店已执行订单列表
	 */
	public List<OrderPo> getFinishedOrders(int hotelId);
	
	/**
	 * @param hotelId
	 * @return	获取酒店异常订单列表
	 */
	public List<OrderPo> getAbnormalOrders(int hotelId);
	
	/**
	 * @param orderId
	 * @return	获取酒店订单
	 */
	public OrderPo getOrder(int orderId);
	
	/**
	 * @param orderId
	 * @return	执行正常订单
	 */
	public boolean finishOrder(int orderId);
	
	/**
	 * @param orderId
	 * @param delayTime
	 * @return	延期异常订单
	 */
	public boolean delayOrder(int orderId,String delayTime);
	

}
