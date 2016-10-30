package data.dao.impl;

import data.dao.DataFactory;
import data.dao.OrderDao;
import data.dao.UserDao;
import data.service.OrderDataService;
import data.service.UserDataService;
import data.service.impl.OrderDataServiceImpl;
import data.service.impl.UserDataServiceImpl;

public class DataFactoryImpl implements DataFactory{

	public OrderDao getOrderDao() {
		OrderDao orderDao = new OrderDaoImpl();
		//OrderDao orderDao = new OrderDaoMysqlImpl();
		return orderDao;
	}

	public UserDao getUserDao() {
		UserDao userDao = new UserDaoImpl();
		//UserDao userDao = new UserDaoMysqlImpl();
		return userDao;
	}

	

}
