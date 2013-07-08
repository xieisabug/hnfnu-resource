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
		// ���ڷ��صģ����������в˵������list����
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
		// ���ڼ�¼��ǰ���ڶ�ȡ��һ����˵�
		String parentName = "";
		// ���ڴ���Ӳ˵��ļ���
		List<RoleMenuVo> children = new ArrayList<RoleMenuVo>();
		// ���ڱ���һ����˵������������С�˵�
		Map<String, Object> oneMenu = null;
		// ��ǰ��ȡ��Vo
		RoleMenuVo rmv = null;
		for (int i = 0; i < list.size(); i++) {
			rmv = list.get(i);
			// �����ǰ��ȡ��vo��parentName��֮ǰ�����parentName����ȣ�˵��������
			// ��һ����˵������ʱ�����Ҫ��֮ǰ��ȡ�Ĳ˵����浽ret����
			if (!rmv.getParentName().equals(parentName)) {
				if (oneMenu != null) {
					// ���������parentName���ֲ��Ǹոս���ѭ�������֮ǰ��ȡ�Ĳ˵����뵽ret
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
			//���������󣬼ǵ�Ҫ���������map�ŵ�ret��
			if (i == (list.size() - 1)) {
				oneMenu.put("children", children);
				ret.add(oneMenu);
			}
		}

		// {"id":"4","name":"ר�����","url":"./welcome.html","icon":"./App/Lib/icons/32X32/product_169.gif"
		// },
		return ret;
	}
}
