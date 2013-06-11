package com.hnfnu.zyw.dao.website;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.vo.RoleMenuVo;

@Repository("loginDao")
public class LoginDao extends HibernateDaoSupport {
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public List getMenusByUserId(int userId) {
		SQLQuery query = getSession()
				.createSQLQuery("{call proc_get_menus(?)}");
		query.setInteger(0, userId);
		query.list();
		//List list = query.list();
		return list;
	}

}
