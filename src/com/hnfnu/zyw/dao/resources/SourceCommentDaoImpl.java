package com.hnfnu.zyw.dao.resources;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.SourceCommentDto;

@Repository("sourceCommentDao")
public class SourceCommentDaoImpl extends BaseDao<SourceCommentDto> implements
ISourceCommentDao  {

	public boolean deleteByIdAndParentId(int id) {
		Session session = this.getSession();
		String hql = "delete from SourceCommentDto where id=:id and parentId=:parentId";
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("id", id);
			q.setParameter("parentId", id);
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
