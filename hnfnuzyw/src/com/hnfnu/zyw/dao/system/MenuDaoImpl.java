package com.hnfnu.zyw.dao.system;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.MenuDto;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDao<MenuDto> implements IMenuDao {

}
