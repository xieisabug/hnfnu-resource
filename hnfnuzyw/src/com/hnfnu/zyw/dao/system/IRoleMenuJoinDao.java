package com.hnfnu.zyw.dao.system;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.RoleMenuJoinDto;

public interface IRoleMenuJoinDao extends IBaseDao<RoleMenuJoinDto> {

	// Í¨¹ý½ÇÉ«idºÍ²Ëµ¥idµÃµ½Ò»¸öRoleMenuJoinÊµÌå

	public RoleMenuJoinDto uniqueLoad(String hql) throws Exception;
	
	
	//ÅúÁ¿Ìí¼Ó½ÇÉ«µÄ¹Ò½ÓµÄ²Ëµ¥£¬Ìí¼ÓÖ®Ç°Í¨¹ý½ÇÉ«idÉ¾³ý¸Ã½ÇÉ«µÄËùÓÐ¹Ò½Ó¼ÇÂ¼
	public boolean addRoleMenuJoins(int roleId,
			List<RoleMenuJoinDto> roleMenuJoins) throws Exception;

}
