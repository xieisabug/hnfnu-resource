package com.hnfnu.zyw.dao.website;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.vo.RoleMenuVo;

@Repository("loginDao")
public class LoginDaoImpl extends BaseDao<RoleMenuVo> implements ILoginDao {
}
