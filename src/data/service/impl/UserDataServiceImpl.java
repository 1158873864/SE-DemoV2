package data.service.impl;

import java.util.List;

import po.UserPo;
import data.dao.DataFactory;
import data.dao.UserDao;
import data.dao.impl.DataFactoryImpl;
import data.dao.impl.UserDaoImpl;
import data.service.UserDataService;

public class UserDataServiceImpl implements UserDataService{
	
	private List<UserPo> list;
	
	private UserDao userDao;
	
	private DataFactory dataFactory;
	
	private static UserDataServiceImpl userDataServiceImpl;
	
	public static UserDataServiceImpl getInstance(){
		if(userDataServiceImpl == null){
			userDataServiceImpl = new UserDataServiceImpl();
		}
		return userDataServiceImpl;
	}
	
	public UserDataServiceImpl(){
		if(list == null){
			dataFactory = new DataFactoryImpl();
			userDao = dataFactory.getUserDao();
			list = userDao.readFromFile();
		}
	}
	
	public UserPo getUser(int userId) {
		for (UserPo userPo : list) {
			if(userPo.getId() == userId){
				return userPo;
			}
		}
		return null;
	}

	public boolean updateUser(UserPo userPo) {
		for (UserPo up : list) {
			if(up.getId() == userPo.getId()){
				up = userPo;
				userDao.writeInfoFile(list);
				return true;
			}
		}
		return false;
	}

}
