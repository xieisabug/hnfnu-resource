package com.hnfnu.zyw.dao.resources;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.TopicSourceJoinDto;

@Repository("topicSourceJoinDao")
public class TopicSourceJoinDaoImpl extends BaseDao<TopicSourceJoinDto> implements
ITopicSourceJoinDao{
	
	
	public boolean  deleteByTopicId(int subtitleId) throws Exception {

		Session session = this.getSession();
		String hql = "delete TopicSourceJoinDto where subtitleId=:subtitleId";
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("subtitleId", subtitleId);
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

	public boolean addTopicSourceJoins(int subtitleId,List<TopicSourceJoinDto> topicSourceJoins) {
		
		String hql = "delete TopicSourceJoinDto where subtitleId=:subtitleId";
		// 打开Session
		Session session = this.getSession();
		// 开始事务
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("subtitleId", subtitleId);
			q.executeUpdate();
			if(topicSourceJoins != null){
			// 循环，插入记录
			for (int i = 0; i < topicSourceJoins.size(); i++) {
				TopicSourceJoinDto topicSourceJoin = topicSourceJoins.get(i);

				// 在Session级别缓存userRoleJoin实例
				session.save(topicSourceJoin);
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

}
