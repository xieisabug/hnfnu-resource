package com.hnfnu.zyw.dao.system;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.UserRoleJoinDto;

public interface IUserRoleJoinDao extends IBaseDao<UserRoleJoinDto> {

	//Í¨¹ýuserIdÅúÁ¿É¾³ý¸ÃÓÃ»§ÒÑ¾­¹Ò½ÓµÄËùÓÐ½ÇÉ«

	public boolean deleteByUserId(int userId) throws Exception;
	
	//ÅúÁ¿Ìí¼ÓÓÃ»§½ÇÉ«¹Ò½Ó¼ÇÂ¼,ÔÚÌí¼ÓÖ®Ç°ÏÈÉ¾³ý¸ÃÓÃ»§µÄ½ÇÉ«
	public boolean addUserRoleJoins(int userId,List<UserRoleJoinDto> userRoleJoins) throws Exception;
}
