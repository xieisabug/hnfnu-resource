package com.hnfnu.zyw.service.resources;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ISourceCategoryJoinDao;
import com.hnfnu.zyw.dao.resources.ISourceDao;
import com.hnfnu.zyw.dto.resources.SourceCategoryJoinDto;
import com.hnfnu.zyw.dto.resources.SourceDto;

@Service("sourceService")
public class SourcesServiceImpl implements ISourceService {

	@Autowired
	@Qualifier("sourceDao")
	public ISourceDao sourceDao;

	@Autowired
	@Qualifier("sourceCategoryJoinDao")
	public ISourceCategoryJoinDao sourceCategoryJoinDao;

	public boolean add(SourceDto source, String categoryIdList) {
		try {
			sourceDao.add(source);
			//System.out.println("�Զ����ɵ���Դid" + source.getId());
			//System.out.println("����б�categoryList" + categoryIdList);

			if (categoryIdList != null && !categoryIdList.equals("")) {
				String[] categoryIds = categoryIdList.split(";");
				for (int i = 0; i < categoryIds.length; i++) {
					SourceCategoryJoinDto t = new SourceCategoryJoinDto();
					t.setCategoryId(Integer.parseInt(categoryIds[i]));
					t.setSourceId(source.getId());
					sourceCategoryJoinDao.add(t);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteMessege(int id) {
		try {
			sourceDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(SourceDto source) {
		try {
			sourceDao.update(source);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public SourceDto load(int id) {
		try {
			return sourceDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SourceDto> list() {
		String hql = "from SourceDto";
		List<SourceDto> sources = null;
		try {
			sources = sourceDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sources;
	}

	public Map<String, Object> listSource() {
		String hql = "from SourceDto";
		Map<String, Object> sourceList = new HashMap<String, Object>();
		List<SourceDto> l = null;

		try {
			l = sourceDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sourceList.put("Rows", l);
		sourceList.put("Total", l.size());
		return sourceList;
	}

	// ɾ���ļ��ķ�����������ص���1˵��ɾ���ɹ���-1˵���ļ������ڡ�0˵���ļ�ɾ������2˵���ļ�ɾ���ɹ�����Ϣɾ������
	public int delete(String url,int id) {
		File file = new File(url);

		// �ж�Ŀ¼���ļ��Ƿ����
		if (!file.exists()) { // �����ڷ��� false
			try {
				sourceDao.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
				return 2;
			}
			return -1;
		} else {
				if(file.delete()){
					try {
						sourceDao.delete(id);
					} catch (Exception e) {
						e.printStackTrace();
						return 2;
					}
				return 1;
				}else {
					return 0;
				}
		}
	}

}
