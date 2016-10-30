package service;

import po.UserPo;

public interface UserService {
	
	/**
	 * @param userId
	 * @return	获取用户数据
	 */
	public UserPo getUser(int userId);
	
	/**
	 * @param credit
	 * @return	增加用户信用值
	 */
	public boolean addUserCredit(int userId,int credit);

}
