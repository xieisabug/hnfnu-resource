package com.hnfnu.zyw.service.system;

import java.util.Map;

public interface IUserRoleVoService {

	/**
	 * ͨ���û�id�õ����û��Ѿ�ӵ�еĽ�ɫ,�ͻ�δӵ�еĽ�ɫ������Mapֵ��
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> roleByUser(int id);

}
