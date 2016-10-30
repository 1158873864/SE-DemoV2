package data.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import po.UserPo;
import data.dao.UserDao;

public class UserDaoImpl implements UserDao{

	public List<UserPo> readFromFile() {
		List<UserPo> list = new ArrayList<UserPo>();
		File file = new File("TxtData/user.txt");
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String str = br.readLine();
			
			while (str != null) {
				
				String[] data = str.split(";");
				
				int userId = Integer.valueOf(data[0]);
				String username=data[1];
				String phone=data[2];
				int credit=Integer.valueOf(data[3]);
				
				UserPo userPo=new UserPo(userId, username, phone, credit);
				list.add(userPo);
				
				str = br.readLine();
				
			}

			br.close();
			
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void writeInfoFile(List<UserPo> list) {
		//写入用户数据
		File file = new File("TxtData/user.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			for (UserPo userPo : list) {
				String str = userPo.getId()+";"+userPo.getUsername()+";"+userPo.getPhone()+";"+userPo.getCredit();
				writer.write(str);
				writer.write("\r\n");
			}
			
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
