package presentation.view;

import java.util.List;

import vo.OrderVo;

public interface ProcessOrder {
	
	public List<OrderVo> getAllOrders(int hotelId);
	
	public List<OrderVo> getUnfinishedOrders(int hotelId);
	
	public List<OrderVo> getFinishedOrders(int hotelId);
	
	public List<OrderVo> getAbnormalOrders(int hotelId);
	
	public boolean processUnfinishedOrder(int orderId);
	
	public boolean processAbnormalOrder(int orderId,String delayTime);
	
	public void openDelayView(int orderNo);
}
