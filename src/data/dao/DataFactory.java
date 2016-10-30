package data.dao;

import data.service.OrderDataService;
import data.service.UserDataService;

public interface DataFactory {
	
	public OrderDao getOrderDao();
	
	public UserDao getUserDao();

}
