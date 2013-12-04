package com.hnfnu.zyw.dao.system;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.ParameterDto;

@Repository("parameterDao")
public class ParameterDaoImpl extends BaseDao<ParameterDto> implements IParameterDao {

}
