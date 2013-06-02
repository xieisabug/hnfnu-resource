package com.hnfnu.zyw.dao.system;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.RoleMenuJoinDto;

@Repository("roleMenuJoinDao")
public class RoleMenuJoinDaoImpl extends BaseDao<RoleMenuJoinDto> implements
		IRoleMenuJoinDao {

	public RoleMenuJoinDto uniqueLoad(String hql) throws Exception {
		Query u = this.getSession().createQuery(hql);
		RoleMenuJoinDto d = (RoleMenuJoinDto) u.uniqueResult();
		return d;
	}

}
