package com.hnfnu.zyw.dao.system;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.RoleMenuJoinDto;

public interface IRoleMenuJoinDao extends IBaseDao<RoleMenuJoinDto> {

	// ͨ����ɫid�Ͳ˵�id�õ�һ��RoleMenuJoinʵ��

	public RoleMenuJoinDto uniqueLoad(String hql) throws Exception;
	
	
	//������ӽ�ɫ�ĹҽӵĲ˵������֮ǰͨ����ɫidɾ���ý�ɫ�����йҽӼ�¼
	public boolean addRoleMenuJoins(int roleId,
			List<RoleMenuJoinDto> roleMenuJoins) throws Exception;

}
