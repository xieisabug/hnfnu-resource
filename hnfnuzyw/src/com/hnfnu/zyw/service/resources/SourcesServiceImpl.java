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
import com.hnfnu.zyw.utils.FileUtils;

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
	
	public boolean deleteFile(String url) {
		File file = new File(url);

		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回true，当做已经删除了
			return true;
		} else {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean update(SourceDto source, String categoryIdList) {
		try {
			SourceDto s = sourceDao.get(source.getId());

			source.setCreateDate(s.getCreateDate());
			source.setApprovalStatus(s.getApprovalStatus());
			source.setViewTimes(s.getViewTimes());
			source.setUseTimes(s.getUseTimes());
			source.setUrl(s.getUrl());
			source.setCreateUserId(s.getCreateUserId());
			sourceDao.update(source);
			sourceCategoryJoinDao.deleteBySourceId(source.getId());

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
			return sourceDao.get(id);
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

	// 删除文件的方法，如果返回的是1说明删除成功，-1说明文件不存在。0说明文件删除错误，2说明文件删除成功，信息删除错误
	public boolean delete(String url, int id) {
		//先删除本地文件，再删除文件信息
		if(FileUtils.deleteOneFile(url)){
			try {
				sourceDao.delete(id);
			} catch (Exception e) {
				return false;
			}
			return true;
		}else{
			return false;
		}
	}

}
