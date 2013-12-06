package com.hnfnu.zyw.service.system;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.system.ParameterDto;

public interface IParameterService {
	
	boolean add(ParameterDto parameter);//增加一个参数

	boolean update(ParameterDto parameter);//修改一个参数

	ParameterDto load(ParameterDto parameter);//获取一个参数

	boolean delete(ParameterDto parameter);//删除一个参数
	
	List<ParameterDto> listAll();  

	Map<String, Object> list();
	
}
