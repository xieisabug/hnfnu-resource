package com.hnfnu.zyw.service.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IFunctionDao;
import com.hnfnu.zyw.dao.system.IMenuDao;
import com.hnfnu.zyw.dao.system.IRoleMenuJoinDao;
import com.hnfnu.zyw.dto.system.FunctionDto;
import com.hnfnu.zyw.dto.system.MenuDto;
import com.hnfnu.zyw.dto.system.RoleMenuJoinDto;

@Service("roleMenuJoinService")
public class RoleMenuJoinServiceImpl implements IRoleMenuJoinService {
	// 菜单Dao，得到所有的菜单信息

	@Autowired
	@Qualifier("menuDao")
	IMenuDao menuDao;

	// 角色菜单挂接Dao,得到角色已经挂接的菜单信息
	@Autowired
	@Qualifier("roleMenuJoinDao")
	IRoleMenuJoinDao roleMenuJoinDao;

	@Autowired
	@Qualifier("functionDao")
	IFunctionDao functionDao;

	public List<Object> roleMenuInit(int roleId) {
		List<Object> result = new ArrayList<Object>();
		List<MenuDto> menus = null;

		String hql = "from  MenuDto";

		Map<String, Object> parent = null;
		Map<String, Object> child = null;

		try {
			menus = menuDao.list(hql);
			// 对数据进行拼装
			for (int i = 0; i < menus.size(); i++) {
				parent = new HashMap<String, Object>();
				parent.put("id", menus.get(i).getId());
				parent.put("name", menus.get(i).getName());
				String functionIdStr = menus.get(i).getFunctionIdList();
				String[] functionIds = functionIdStr.split(";");

				List<Object> childList = new ArrayList<Object>();

				for (int j = 0; j < functionIds.length; j++) {
					child = new HashMap<String, Object>();
					FunctionDto function = functionDao.get(Integer
							.parseInt(functionIds[j]));
					child.put("name", function.getRemark());
					child.put("id", function.getId());
					child.put("pid", menus.get(i).getId());

					// 如果已经选过了该菜单的该功能
					if (isChecked(roleId, menus.get(i).getId(), function
							.getId())) {
						child.put("ischecked", true);
					}
					childList.add(child);
				}
				parent.put("children", childList);
				result.add(parent);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	private boolean isChecked(int roleId, int menuId, int functionId) {
		RoleMenuJoinDto roleMenuJoin = null;
		String hql2 = "from RoleMenuJoinDto where roleId=" + roleId
				+ " and menuId=" + menuId;
		try {
			roleMenuJoin = roleMenuJoinDao.uniqueLoad(hql2);
			if (roleMenuJoin != null) {
				String functionIdList = roleMenuJoin.getFunctionIdList();
				String[] functionIds = functionIdList.split(";");
				for (int i = 0; i < functionIds.length; i++) {
					if (functionId == Integer.parseInt(functionIds[i])) {
						return true;
					}
				}
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean addRoleMenuJoins(String joinIds) {
		System.out.println("joinIds"+joinIds);
		List<RoleMenuJoinDto> roleMenuJoins = new ArrayList<RoleMenuJoinDto>();
		RoleMenuJoinDto roleMenuJoin = null;
		String[] f =  joinIds.split(":");
		int roleId = Integer.parseInt(f[0]);
		
		if(f.length < 2){
			roleMenuJoins = null;
		}
		for(int i = 1; i < f.length;i++){
			roleMenuJoin = new RoleMenuJoinDto();
			String[] t = f[i].split(",");
			int menuId = Integer.parseInt(t[0]);
			roleMenuJoin.setRoleId(roleId);
			roleMenuJoin.setMenuId(menuId);
			roleMenuJoin.setFunctionIdList(t[1]);	
			roleMenuJoins.add(roleMenuJoin);
		}
		try {
			roleMenuJoinDao.addRoleMenuJoins(roleId, roleMenuJoins);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
