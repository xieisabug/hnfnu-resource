package com.hnfnu.zyw.service.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ITopicSourceJoinDao;
import com.hnfnu.zyw.dto.resources.TopicSourceJoinDto;

@Service("topicSourceJoinService")
public class TopicSourceJoinServiceImpl implements ITopicSourceJoinService {
	// 操作user_role_join表的dao
	@Autowired
	@Qualifier("topicSourceJoinDao")
	public ITopicSourceJoinDao topicSourceJoinDao;

	public boolean add(TopicSourceJoinDto topicSourceJoin) {
		try {
			topicSourceJoinDao.add(topicSourceJoin);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			topicSourceJoinDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(TopicSourceJoinDto topicSourceJoin) {
		try {
			topicSourceJoinDao.update(topicSourceJoin);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public TopicSourceJoinDto load(int id) {
		try {
			return topicSourceJoinDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteByTopicId(int topicId) {
		try {
			return topicSourceJoinDao.deleteByTopicId(topicId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addTopicSourceJoins(String topicSourceIds, int topicId) {
		// if (topicSourceIds != null && !topicSourceIds.equals("")) {

		// int topicId = Integer.parseInt(ids[0]);

		List<TopicSourceJoinDto> topicSourceJoins = new ArrayList<TopicSourceJoinDto>();
		// 当该用户没有角色时
		if (topicSourceIds == null || topicSourceIds.equals("")) {
			topicSourceJoins = null;
		} else {
			String[] ids = topicSourceIds.split(",");
			for (int i = 0; i < ids.length; i++) {
				TopicSourceJoinDto dto = new TopicSourceJoinDto(null, topicId,
						Integer.parseInt(ids[i]));
				topicSourceJoins.add(dto);
			}
		}

		try {
			return topicSourceJoinDao.addTopicSourceJoins(topicId,
					topicSourceJoins);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int[] QueryAllSourceidsByTopicId(int topicId) {
		
		String hql = "from TopicSourceJoinDto where topicId ="+topicId;
		List<TopicSourceJoinDto> list;
		try {
			list = topicSourceJoinDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		int[] r = new int[list.size()];
		
		for(int i = 0 ;i < list.size();i++){
			TopicSourceJoinDto dto = list.get(i);
			r[i] = dto.getsourceId();
		}
		return r;
	}
}
