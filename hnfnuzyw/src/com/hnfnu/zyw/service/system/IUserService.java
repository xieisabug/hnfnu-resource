package com.hnfnu.zyw.service.system;

import java.util.Map;

import com.hnfnu.zyw.dto.system.UserDto;

public interface IUserService {
	public boolean add(UserDto user);

	public boolean delete(int id);

	public boolean update(UserDto user);

	public UserDto load(int id);

	/**
	 * ��ѯ���ݿ����м�¼,��Mapװ���������ڷ�ҳ��ʾ
	 * 
	 * @return
	 */
	public Map<String, Object> list();
	
}
