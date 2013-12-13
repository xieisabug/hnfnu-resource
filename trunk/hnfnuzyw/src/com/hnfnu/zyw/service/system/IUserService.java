package com.hnfnu.zyw.service.system;

import java.util.Map;

import com.hnfnu.zyw.dto.system.UserDto;

public interface IUserService {
	public boolean add(UserDto user);

	public boolean delete(int id);

	public boolean update(UserDto user);

	public UserDto load(int id);

	/**
	 * 查询数据库所有记录,用Map装，方便用于分页显示
	 * 
	 * @return
	 */
	public Map<String, Object> list();
	
	public boolean updatePwd(int id,String newPassword);
	/**
	 * 验证用户名是否已经存在
	 * @param username
	 * @return
	 */
	public boolean validateUserName(String username);
	public int addUserBalance(int balanceCount, String userIds);
	/*
	 * 解析excel表批量给用户注册
	 */
	public Map<String, Object> addUsers(String url);
}
