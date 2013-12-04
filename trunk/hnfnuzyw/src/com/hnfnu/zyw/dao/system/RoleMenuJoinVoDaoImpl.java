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
		// ´ò¿ªSession
		Session session = this.getSession();
		// ¿ªÊ¼ÊÂÎñ
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("roleId", roleId);
			q.executeUpdate();
			if (roleMenuJoins != null) {
				// Ñ­»·£¬²åÈë¼ÇÂ¼
				for (int i = 0; i < roleMenuJoins.size(); i++) {
					RoleMenuJoinDto roleMenuJoin = roleMenuJoins.get(i);

					// ÔÚSession¼¶±ð»º´æuserRoleJoinÊµÀý
					session.save(roleMenuJoin);
					// Ã¿µ±ÀÛ¼ÓÆ÷ÊÇ20µÄ±¶ÊýÊ±£¬½«SessionÖÐµÄÊý¾ÝË¢ÈëÊý¾Ý¿â£¬²¢Çå¿ÕSession»º´æ
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
