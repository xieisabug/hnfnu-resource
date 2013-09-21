package com.hnfnu.zyw.dao.resources;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.SourceCategoryJoinDto;
import com.hnfnu.zyw.dto.resources.SourceDto;

@Repository("sourceDao")
public class SourceDaoImpl extends BaseDao<SourceDto> implements ISourceDao {

	public boolean update(SourceDto source, String categoryIdList)
			throws Exception {
		
		ISourceCategoryJoinDao sourceCategoryJoinDao = new SourceCategoryJoinDaoImpl();
		Session session = this.getSession();
		//先删除原先的挂接关系
		String hql = "delete SourceCategoryJoinDto where sourceId=:sourceId";
		Transaction t = null;
		try {
			//开启事务
			t = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("sourceId", source.getId());
			q.executeUpdate();
			
			this.add(source);
			if (categoryIdList != null && !categoryIdList.equals("")) {
				String[] categoryIds = categoryIdList.split(";");
				for (int i = 0; i < categoryIds.length; i++) {
					SourceCategoryJoinDto sc = new SourceCategoryJoinDto();
					sc.setCategoryId(Integer.parseInt(categoryIds[i]));
					sc.setSourceId(source.getId());
					sourceCategoryJoinDao.add(sc);
				}
			}
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
