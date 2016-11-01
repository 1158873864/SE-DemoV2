package presentation.controller;

import java.util.ArrayList;
import java.util.List;

import po.OrderPo;
import po.UserPo;
import presentation.view.ProcessOrderView;
import presentation.view.ProcessOrderViewControllerService;
import service.OrderService;
import service.UserService;
import service.impl.OrderServiceImpl;
import service.impl.UserServiceImpl;
import vo.OrderVo;

public class ProcessOrderViewControllerImpl implements ProcessOrderViewControllerService{
	
	private OrderService orderService;
	
	private UserService userService;
	
	private ProcessOrderView view;
	
	public ProcessOrderViewControllerImpl(){
		orderService = new OrderServiceImpl();
		userService = new UserServiceImpl();
	}
	
	public void setView(ProcessOrderView view){
		this.view = view;
	}
	
	/**
	 * @return	获取酒店所有订单
	 */
	public List<OrderVo> getAllOrders(int hotelId){
		List<OrderVo> list = new ArrayList<OrderVo>();
		List<OrderPo> orderList = orderService.getAllOrders(hotelId);
		for (OrderPo orderPo : orderList) {
			int userId = orderPo.getUserId();
			UserPo userPo = userService.getUser(userId);
			String userInfo = userPo.getUsername()+"("+userPo.getCredit()+")";
			OrderVo orderVo = new OrderVo(orderPo,userInfo);
			list.add(orderVo);
		}
		return list;
	}
	
	/**
	 * @param hotelId
	 * @return	获取酒店未执行订单
	 */
	public List<OrderVo> getUnfinishedOrders(int hotelId){
		List<OrderVo> list = new ArrayList<OrderVo>();
		List<OrderPo> orderList = orderService.getUnfinishedOrders(hotelId);
		for (OrderPo orderPo : orderList) {
			int userId = orderPo.getUserId();
			UserPo userPo = userService.getUser(userId);
			String userInfo = userPo.getUsername()+"("+userPo.getCredit()+")";
			OrderVo orderVo = new OrderVo(orderPo,userInfo);
			list.add(orderVo);
		}
		return list;
	}
	
	/**
	 * @param hotelId
	 * @return	获取酒店已执行订单
	 */
	public List<OrderVo> getFinishedOrders(int hotelId){
		List<OrderVo> list = new ArrayList<OrderVo>();
		List<OrderPo> orderList = orderService.getFinishedOrders(hotelId);
		for (OrderPo orderPo : orderList) {
			int userId = orderPo.getUserId();
			UserPo userPo = userService.getUser(userId);
			String userInfo = userPo.getUsername()+"("+userPo.getCredit()+")";
			OrderVo orderVo = new OrderVo(orderPo,userInfo);
			list.add(orderVo);
		}
		return list;
	}
	
	/**
	 * @param hotelId
	 * @return	获取酒店异常订单
	 */
	public List<OrderVo> getAbnormalOrders(int hotelId){
		List<OrderVo> list = new ArrayList<OrderVo>();
		List<OrderPo> orderList = orderService.getAbnormalOrders(hotelId);
		for (OrderPo orderPo : orderList) {
			int userId = orderPo.getUserId();
			UserPo userPo = userService.getUser(userId);
			String userInfo = userPo.getUsername()+"("+userPo.getCredit()+")";
			OrderVo orderVo = new OrderVo(orderPo,userInfo);
			list.add(orderVo);
		}
		return list;
	}
	
	/**
	 * @param orderId
	 * @return	对未执行订单进行处理
	 */
	public boolean processUnfinishedOrder(int orderId){
		OrderPo orderPo = orderService.getOrder(orderId);
		if(orderService.finishOrder(orderId)){
			int userId = orderPo.getUserId();
			int credit = orderPo.getPrice();
			return userService.addUserCredit(userId, credit);
		}
		return false;
		
	}
	
	/**
	 * @param orderId
	 * @param delayTime
	 * @return	为异常订单办理延期入住
	 */
	public boolean processAbnormalOrder(int orderId,String delayTime){
		OrderPo orderPo = orderService.getOrder(orderId);
		if(orderService.delayOrder(orderId, delayTime)){
			int userId = orderPo.getUserId();
			int credit = orderPo.getPrice();
			return userService.addUserCredit(userId, credit);
		}
		return false;
		
	}

	/**
	 * 打开订单延期界面
	 */
	public void openDelayView(int index) {
		
		view.openDelayView(index);
		
	}
	
	
	
}
