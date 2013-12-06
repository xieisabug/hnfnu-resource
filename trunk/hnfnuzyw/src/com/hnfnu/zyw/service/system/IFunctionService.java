package com.hnfnu.zyw.service.system;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.system.FunctionDto;

public interface IFunctionService {
	public boolean add(FunctionDto function);

	public boolean delete(FunctionDto function);

	public boolean update(FunctionDto function);

	public FunctionDto load(FunctionDto function);

	
	/**
	 * 获取表中所有功能，是用List装的
	 * @return
	 */
	public List<FunctionDto> list();
	/**
	 *获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	 * @return
	 */
	public Map<String, Object> listFun();
	
}
