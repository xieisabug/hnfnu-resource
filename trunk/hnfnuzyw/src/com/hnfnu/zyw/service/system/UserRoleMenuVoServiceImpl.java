package com.hnfnu.zyw.service.system;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IUserRoleMenuVoDao;
import com.hnfnu.zyw.vo.UserRoleMenuVo;

@Service("userRoleMenuVoService")
public class UserRoleMenuVoServiceImpl implements IUserRoleMenuVoService{

	@Autowired
	@Qualifier("userRoleMenuVoDao")
	public IUserRoleMenuVoDao userRoleMenuVoDao;
	
	public String getListByUserIdMenuId(int userId, int menuId) {
		String hql = "from UserRoleMenuVo where userId="+userId+" and menuId="+menuId;
		List<UserRoleMenuVo> list = null;
		try {
			list = userRoleMenuVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		Map<String,String> t = new HashMap<String,String>();
		
		for(int i = 0;i<list.size();i++){
			String functionIdList = list.get(i).getFunctionIdList();
			String[] s =functionIdList.split(";");
			for(int j = 0 ;j < s.length;j++){
				t.put(s[j], s[j]);
			}
		}
		Set set =t.keySet();
		Iterator it=set.iterator();
		String re = "";
		while(it.hasNext()){
          String s= (String) it.next();
          String v = t.get(s);
          re += (v+";");
      }
		return re;
	}

}
