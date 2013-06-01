package com.hnfnu.zyw.dao.system;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.UserRoleJoinDto;

public interface IUserRoleJoinDao extends IBaseDao<UserRoleJoinDto> {

	//ͨ��userId����ɾ�����û��Ѿ��ҽӵ����н�ɫ

	public boolean deleteByUserId(int userId) throws Exception;
	
	//��������û���ɫ�ҽӼ�¼,�����֮ǰ��ɾ�����û��Ľ�ɫ
	public boolean addUserRoleJoins(int userId,List<UserRoleJoinDto> userRoleJoins) throws Exception;
}
