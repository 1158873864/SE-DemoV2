package data.dao;

import java.util.List;

import po.UserPo;

public interface UserDao {
	
	/**
	 * @return	从数据文件中读取用户数据
	 */
	public List<UserPo> readFromFile();
	
	/**
	 * 向数据文件中写入用户数据
	 * @param list
	 */
	public void writeInfoFile(List<UserPo> list);

}
