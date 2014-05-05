package com.hnfnu.zyw.dao.resources;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.GroupDto;

@Repository("groupDao")
public class GroupDaoImpl extends BaseDao<GroupDto> implements IGroupDao {

}
