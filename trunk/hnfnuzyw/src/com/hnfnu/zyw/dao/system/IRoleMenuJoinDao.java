package com.hnfnu.zyw.dao.system;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.RoleMenuJoinDto;

public interface IRoleMenuJoinDao extends IBaseDao<RoleMenuJoinDto> {

	//ͨ����ɫid�Ͳ˵�id�õ�һ��RoleMenuJoinʵ��
	
	public RoleMenuJoinDto uniqueLoad(String hql) throws Exception;
	
}
