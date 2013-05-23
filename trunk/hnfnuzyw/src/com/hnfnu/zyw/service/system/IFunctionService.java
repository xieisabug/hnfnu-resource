package com.hnfnu.zyw.service.system;

import java.util.List;

import com.hnfnu.zyw.dto.system.FunctionDto;

public interface IFunctionService {
	public boolean add(FunctionDto function);

	public boolean delete(int id);

	public boolean update(FunctionDto function);

	public FunctionDto load(int id);

	/**
	 * ��ѯ���ݿ����м�¼
	 * @return
	 */
	public List<FunctionDto> list();
}
