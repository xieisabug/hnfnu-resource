package com.hnfnu.zyw.dao.system;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.RoleDto;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDao<RoleDto> implements IRoleDao {

}
