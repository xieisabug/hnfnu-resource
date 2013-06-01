package com.hnfnu.zyw.service.system;

import com.hnfnu.zyw.dto.system.UserRoleJoinDto;

public interface IUserRoleJoinService {

	public boolean add(UserRoleJoinDto userRoleJoin);

	public boolean delete(int id);

	public boolean update(UserRoleJoinDto userRoleJoin);

	public UserRoleJoinDto load(int id);

	// ͨ��userId����ɾ�����û��Ѿ��ҽӵ����н�ɫ

	public boolean deleteByUserId(int userId);

	// ��������û���ɫ�ҽӼ�¼
	public boolean addUserRoleJoins(String userRoleIds);

}
