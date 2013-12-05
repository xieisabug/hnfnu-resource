package com.hnfnu.zyw.dao.website;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.website.UserOperateDto;

@Repository("userOperateDao")
public class UserOperateDaoImpl extends BaseDao<UserOperateDto> implements IUserOperateDao {
}
