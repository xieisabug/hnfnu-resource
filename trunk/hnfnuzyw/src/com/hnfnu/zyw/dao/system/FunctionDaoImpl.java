package com.hnfnu.zyw.dao.system;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.FunctionDto;

@Repository("functionDao")
public class FunctionDaoImpl extends BaseDao<FunctionDto> implements
		IFunctionDao {

}
