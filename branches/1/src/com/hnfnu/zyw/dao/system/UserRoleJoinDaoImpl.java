package com.hnfnu.zyw.dao.system;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.UserRoleJoinDto;

@Repository("userRoleJoinDao")
public class UserRoleJoinDaoImpl extends BaseDao<UserRoleJoinDto> implements
		IUserRoleJoinDao {

	public boolean deleteByUserId(int userId) throws Exception {

		Session session = this.getSession();
		String hql = "delete UserRoleJoinDto where userId=:userId";
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("userId", userId);
			q.executeUpdate();
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return false;
		} finally {
			session.close();
		}
		return true;

	}

	public boolean addUserRoleJoins(int userId,List<UserRoleJoinDto> userRoleJoins) {
		
		String hql = "delete UserRoleJoinDto where userId=:userId";
		// 打开Session
		Session session = this.getSession();
		// 开始事务
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("userId", userId);
			q.executeUpdate();
			if(userRoleJoins != null){
			// 循环，插入记录
			for (int i = 0; i < userRoleJoins.size(); i++) {
				UserRoleJoinDto userRoleJoin = userRoleJoins.get(i);

				// 在Session级别缓存userRoleJoin实例
				session.save(userRoleJoin);
				// 每当累加器是20的倍数时，将Session中的数据刷入数据库，并清空Session缓存
				if (i % 20 == 0) {
					session.flush();
					session.clear();
					t.commit();
					t = session.beginTransaction();
				}
			}
			}
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return false;
		} finally {
			session.close();
		}

		return true;
	}
	
	
	//
}
