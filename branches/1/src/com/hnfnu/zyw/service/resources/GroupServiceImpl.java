package com.hnfnu.zyw.service.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.IGroupDao;
import com.hnfnu.zyw.dto.resources.GroupDto;

@Service("groupService")
public class GroupServiceImpl implements IGroupService{
	@Autowired
	@Qualifier("groupDao")
	public IGroupDao groupDao;

	public boolean add(GroupDto group) {
		try {
			groupDao.add(group);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			groupDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(GroupDto group) {
		try {
			groupDao.update(group);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public GroupDto load(int id) {
		try {
			return groupDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<GroupDto> list() {
		
		String hql = "from GroupDto";
		List<GroupDto> groups = null;
		try {
			groups = groupDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groups;
	}

	public Map<String, Object> listGroup() {
		String hql = "from GroupDto";
		Map<String, Object> groupList = new HashMap<String, Object>();
		List<GroupDto> l = null;

		try {
			l = groupDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		groupList.put("Rows", l);
		groupList.put("Total", l.size());
		return groupList;
	}
}
