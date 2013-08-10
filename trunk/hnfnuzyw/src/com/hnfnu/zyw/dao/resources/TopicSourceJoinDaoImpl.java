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
	
	
	public boolean  deleteByTopicId(int topicId) throws Exception {

		Session session = this.getSession();
		String hql = "delete TopicSourceJoinDto where topicId=:topicId";
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("topicId", topicId);
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

	public boolean addTopicSourceJoins(int topicId,List<TopicSourceJoinDto> topicSourceJoins) {
		
		String hql = "delete TopicSourceJoinDto where topicId=:topicId";
		// ��Session
		Session session = this.getSession();
		// ��ʼ����
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("topicId", topicId);
			q.executeUpdate();
			if(topicSourceJoins != null){
			// ѭ���������¼
			for (int i = 0; i < topicSourceJoins.size(); i++) {
				TopicSourceJoinDto topicSourceJoin = topicSourceJoins.get(i);

				// ��Session���𻺴�userRoleJoinʵ��
				session.save(topicSourceJoin);
				// ÿ���ۼ�����20�ı���ʱ����Session�е�����ˢ�����ݿ⣬�����Session����
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
