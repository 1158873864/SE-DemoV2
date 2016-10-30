package data.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import po.OrderPo;
import data.dao.OrderDao;

public class OrderDaoImpl implements OrderDao{

	public List<OrderPo> readFromFile() {
		File file = new File("TxtData/order.txt");
		List<OrderPo> list = new ArrayList<OrderPo>();
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String str = br.readLine();
			
			while (str != null) {
				
				String[] data = str.split(";");
				int orderId = Integer.valueOf(data[0]);
				int hotelId = Integer.valueOf(data[1]) ;
				int orderUserId = Integer.valueOf(data[2]);
				int orderStatus = Integer.valueOf(data[3]);
				String orderEntryTime = data[4];
				String orderLastTime = data[5];
				String orderInfo=data[6];
				int orderPrice = Integer.valueOf(data[7]);
				
				OrderPo order=new OrderPo(orderId, hotelId, orderUserId, orderStatus, orderEntryTime, orderLastTime,orderInfo,orderPrice);
				list.add(order);
				
				str = br.readLine();
				
			}

			br.close();
			
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void writeInfoFile(List<OrderPo> list) {
		//写入数据
		File file = new File("TxtData/order.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			for (OrderPo orderPo : list) {
				String str = orderPo.getId()+";"+orderPo.getHotelId()+";"+orderPo.getUserId()+";"
			+orderPo.getStatus()+";"+orderPo.getEntryTime()+";"+orderPo.getLastTime()+";"+orderPo.getOrderInfo()+";"+orderPo.getPrice();
				writer.write(str);
				writer.write("\r\n");
			}
			
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
