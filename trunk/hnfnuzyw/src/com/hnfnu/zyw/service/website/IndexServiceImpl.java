package com.hnfnu.zyw.service.website;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.website.IIndexDao;
import com.hnfnu.zyw.vo.RoleMenuVo;

@Service("indexService")
public class IndexServiceImpl implements IIndexService {
	@Autowired
	@Qualifier("indexDao")
	public IIndexDao indexDao;

	public List<Map<String, Object>> getRoleMenusByUserId(int userId) {
		String hql = "from RoleMenuVo rm where rm.roleId in (select ur.roleId from UserRoleVo ur where ur.userId = "
				+ userId + ") group by rm.menuId order by rm.parentId,rm.menuId  asc";

		List<RoleMenuVo> list;
		try {
			list = indexDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		// 用于返回的，保存了所有菜单结果的list集合
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
		// 用于记录当前是在读取哪一个大菜单
		String parentName = "";
		// 用于存放子菜单的集合
		List<RoleMenuVo> children = new ArrayList<RoleMenuVo>();
		// 用于保存一个大菜单和里面包含的小菜单
		Map<String, Object> oneMenu = null;
		// 当前读取的Vo
		RoleMenuVo rmv = null;
		for (int i = 0; i < list.size(); i++) {
			rmv = list.get(i);
			// 如果当前读取的vo的parentName和之前处理的parentName不相等，说明处理到了
			// 下一个大菜单，这个时候就需要将之前读取的菜单保存到ret集合
			if (!rmv.getParentName().equals(parentName)) {
				if (oneMenu != null) {
					// 如果更换了parentName，又不是刚刚进入循环，则把之前读取的菜单加入到ret
					oneMenu.put("children", children);
					ret.add(oneMenu);
				}
				parentName = rmv.getParentName();
				oneMenu = new HashMap<String, Object>();
				children = new ArrayList<RoleMenuVo>();
				children.add(rmv);
				oneMenu.put("name", parentName);
			} else {
				children.add(rmv);
			}
			//如果到了最后，记得要将最后的这个map放到ret中
			if (i == (list.size() - 1)) {
				oneMenu.put("children", children);
				ret.add(oneMenu);
			}
		}

		// {"id":"4","name":"专题管理","url":"./welcome.html","icon":"./App/Lib/icons/32X32/product_169.gif"
		// },
		return ret;
	}
}
