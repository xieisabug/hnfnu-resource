package com.hnfnu.zyw.dao.resources;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.SourceCategoryJoinDto;

@Repository("sourceCategoryJoinDao")
public class SourceCategoryJoinDaoImpl extends BaseDao<SourceCategoryJoinDto>
		implements ISourceCategoryJoinDao {

	public boolean deleteBySourceId(int sourceId) throws Exception {
		Session session = this.getSession();
		String hql = "delete SourceCategoryJoinDto where sourceId=:sourceId";
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("sourceId", sourceId);
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

}
