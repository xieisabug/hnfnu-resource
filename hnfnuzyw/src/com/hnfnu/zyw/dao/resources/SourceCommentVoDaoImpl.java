package com.hnfnu.zyw.dao.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.vo.SourceCommentVo;

@Repository("sourceCommentVoDao")
public class SourceCommentVoDaoImpl extends BaseDao<SourceCommentVo> implements
ISourceCommentVoDao  {
	
	public List<Map<String,Object>> sourceCommentTree(int sourceId) throws Exception {
		List<Map<String,Object>> r = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		List<SourceCommentVo> children = null;
		
		Session session = this.getSession();
		String hql = "from SourceCommentVo where parentId=0 and sourceId="+sourceId;
		Transaction t = null;
		try {
			t = session.beginTransaction();
			List<SourceCommentVo> l = this.list(hql);
			for(int i = 0;i<l.size();i++){
				String childHql = "from SourceCommentVo where parentId="+l.get(i).getParentId();
				children = this.list(childHql);
				map = new HashMap<String, Object>();
				map.put("children", children);
				map.put("sourceComment", l.get(i));
				r.add(map);
			}
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return null;
		} finally {
			session.close();
		}
		return r;

	}

}
