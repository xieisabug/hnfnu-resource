package com.hnfnu.zyw.service.system;

import java.util.List;

public interface IRoleMenuJoinService {

	//���ݽ�ɫid,�õ��ý�ɫ�ѹҽӵĲ˵���δ�ҽӵĲ˵���
	public List<Object> roleMenuInit(int roleId);
	
	//����ǰ̨������id�ַ����������洢
	public boolean addRoleMenuJoins(String joinIds);
	
}
