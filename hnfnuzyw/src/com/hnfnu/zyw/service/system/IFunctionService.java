package com.hnfnu.zyw.service.system;

import java.util.List;

import com.hnfnu.zyw.dto.system.FunctionDto;

public interface IFunctionService {
	public boolean add(FunctionDto function);

	public boolean delete(int id);

	public boolean update(FunctionDto function);

	public FunctionDto load(int id);

	/**
	 * 查询数据库所有记录
	 * @return
	 */
	public List<FunctionDto> list();
}
