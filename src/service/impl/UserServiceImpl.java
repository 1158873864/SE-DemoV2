package service.impl;

import data.dao.UserDao;
import data.dao.impl.UserDaoImpl;
import data.datahelper.DataFactory;
import data.datahelper.impl.DataFactoryImpl;
import po.UserPo;
import service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDataService;
	
	public UserServiceImpl(){
		userDataService = UserDaoImpl.getInstance();
	}

	public UserPo getUser(int userId) {
		// TODO Auto-generated method stub
		return userDataService.getUser(userId);
	}

	public boolean addUserCredit(int userId,int credit) {
		UserPo userPo = getUser(userId);
		userPo.setCredit(userPo.getCredit()+credit);
		return userDataService.updateUser(userPo);
	}

}
