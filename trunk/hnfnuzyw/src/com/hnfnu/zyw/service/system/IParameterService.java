package com.hnfnu.zyw.service.system;

import java.util.Map;

import com.hnfnu.zyw.dto.system.ParameterDto;

public interface IParameterService {
	
	boolean add(ParameterDto parameter);//����һ������

	boolean update(ParameterDto parameter);//�޸�һ������

	ParameterDto load(ParameterDto parameter);//��ȡһ������

	boolean delete(ParameterDto parameter);//ɾ��һ������

	Map<String, Object> list();
	
}
