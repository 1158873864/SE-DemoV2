package service.impl;

import data.dao.DataFactory;
import data.dao.impl.DataFactoryImpl;
import data.service.UserDataService;
import data.service.impl.UserDataServiceImpl;
import po.UserPo;
import service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDataService userDataService;
	
	public UserServiceImpl(){
		userDataService = UserDataServiceImpl.getInstance();
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
