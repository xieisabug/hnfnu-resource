package com.hnfnu.zyw.service.system;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.system.FunctionDto;

public interface IFunctionService {
	public boolean add(FunctionDto function);

	public boolean delete(int id);

	public boolean update(FunctionDto function);

	public FunctionDto load(int id);

	
	/**
	 * ��ȡ�������й��ܣ�����Listװ��
	 * @return
	 */
	public List<FunctionDto> list();
	/**
	 *��ȡ�������й��ܣ���Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * @return
	 */
	public Map<String, Object> listFun();
	
}
