package com.hnfnu.zyw.dao;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.User;

@Repository("userHibernateDao")
public class UserHibernateDao extends BaseDao<User> implements IUserHibernateDao{

}
