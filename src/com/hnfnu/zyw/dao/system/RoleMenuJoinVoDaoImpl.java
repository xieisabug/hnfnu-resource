package com.hnfnu.zyw.dao.system;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.RoleMenuJoinDto;

@Repository("roleMenuJoinDao")
public class RoleMenuJoinVoDaoImpl extends BaseDao<RoleMenuJoinDto> implements
		IRoleMenuJoinDao {

	public RoleMenuJoinDto uniqueLoad(String hql){
		Session session = null;
		RoleMenuJoinDto d = null;
		try{
		session = this.getSession(); 
		Query u = session.createQuery(hql);
		d = (RoleMenuJoinDto) u.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
		return d;
	}

	public boolean addRoleMenuJoins(int roleId,
			List<RoleMenuJoinDto> roleMenuJoins) {
		String hql = "delete RoleMenuJoinDto where roleId=:roleId";
		// 打开Session
		Session session = this.getSession();
		// 开始事务
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("roleId", roleId);
			q.executeUpdate();
			if (roleMenuJoins != null) {
				// 循环，插入记录
				for (int i = 0; i < roleMenuJoins.size(); i++) {
					RoleMenuJoinDto roleMenuJoin = roleMenuJoins.get(i);

					// 在Session级别缓存userRoleJoin实例
					session.save(roleMenuJoin);
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
			session.close();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

}
