package data.dao;

import java.util.List;

import po.OrderPo;

public interface OrderDao {
	
	/**
	 * @return	从数据文件中读取订单数据
	 */
	public List<OrderPo> readFromFile();
	
	/**
	 * 向数据文件中写入订单数据
	 * @param list	
	 */
	public void writeInfoFile(List<OrderPo> list);

}
