package com.hnfnu.zyw.dao.system;

import java.util.ArrayList;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.UserDto;

public interface IUserDao extends IBaseDao<UserDto>{

	//根据任意字段得到一个用户信息
	public UserDto getUser(String hql) throws Exception;
	
	//修改密码
	public void updatePwd(int id,String newPassword ) throws Exception;
	/**
	 * 批量给用户充值资源币
	 * @param count
	 * @param studentIds
	 * @return
	 */
	public int addUserBalance(int count,String userIds);
	/**
	 * 批量给用户重置密码
	 * @param count
	 * @param studentIds
	 * @return
	 */
	/*public int changeManyPasswd(String passwd,String userIds);*/
	
	/**
	 * 批量注册用户
	 * @param count
	 * @param studentIds
	 * @return
	 */
	public boolean addUsers(ArrayList<UserDto> users);
	
	/**
	 * 批量给用户修改密码
	 * @param users
	 * @return
	 */
	public boolean editManyPassword(ArrayList<UserDto> users);
	
	/**
	 * 批量给用户重置资源币，不管用户原有的资源币
	 */
	public int setUserBalance(int count,String userIds);
	
	/**
	 * 批量删除用户,0是删除不成功，1是成功
	 */
	public int deleteUsers(String userIds);
	
	public int getTotalCount(String hql);
	
}
