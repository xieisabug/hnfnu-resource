package com.hnfnu.zyw.service.resources;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dao.resources.ITopicSubtitleSourceVoDao;
import com.hnfnu.zyw.dto.resources.SourceDto;
import com.hnfnu.zyw.utils.FileUtils;
import com.hnfnu.zyw.utils.Url;
import com.hnfnu.zyw.vo.TopicSubtitleSourceVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("topicSubtitleSourceVoService")
public class TopicSubtitleSourceVoServiceImpl implements ITopicSubtitleSourceVoService {

	@Autowired
	@Qualifier("topicSubtitleSourceVoDao")
	public ITopicSubtitleSourceVoDao topicSubtitleSourceVoDao;

	public boolean add(TopicSubtitleSourceVo garde) {
		try {
			topicSubtitleSourceVoDao.add(garde);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			topicSubtitleSourceVoDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(TopicSubtitleSourceVo garde) {
		try {
			topicSubtitleSourceVoDao.update(garde);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public TopicSubtitleSourceVo load(int id) {
		try {
			return topicSubtitleSourceVoDao.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TopicSubtitleSourceVo> list() {
		String hql = "from TopicSubtitleSourceVo";
		List<TopicSubtitleSourceVo> gardes = null;
		try {
			gardes = topicSubtitleSourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gardes;
	}

	public Map<String, Object> listTopicSubtitleSourceVo(int id) {
		String hql = "from TopicSubtitleSourceVo where subtitleId="+id;
		Map<String, Object> gardeList = new HashMap<String, Object>();
		List<TopicSubtitleSourceVo> l = null;

		try {
			l = topicSubtitleSourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		gardeList.put("Rows", l);
		gardeList.put("Total", l.size());
		return gardeList;
	}

	public List<TopicSubtitleSourceVo> listBySubtileId(int subtitleId,int startIndex,int pageSize) {
		String hql = "from TopicSubtitleSourceVo where subtitleId="+subtitleId;
		List<TopicSubtitleSourceVo> gardes = null;
		try {
			gardes = topicSubtitleSourceVoDao.find(hql, startIndex, pageSize).getDatas();
					//queryForPage(hql, startIndex, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gardes;
	}

	@Override
	public boolean clearFile() {
		String hql = "from TopicSubtitleSourceVo";
		List<TopicSubtitleSourceVo> s = null;
		String filePath = Url.realPath;
		filePath += "uploads//topic";
		HashSet<String> set = new HashSet<String>();
		try {
			s = topicSubtitleSourceVoDao.list(hql);
			for (int i = 0; i < s.size(); i++) {
				set.add(s.get(i).getUrl());
			}
            System.out.println("filePath"+filePath);
			File file = new File(filePath);
			String filePakege[];
			filePakege = file.list();
			for (int i = 0; i < filePakege.length; i++) {
				//System.out.println(filePakege[i]);
				if(!filePakege[i].equals("image")){
					//如果数据库不存在这个图片的记录则删除该图片
					File file2 = new File(filePath
						+ "\\"+filePakege[i]);
					String[] f2 = file2.list();
					for (int j = 0; j < f2.length; j++) {
						//System.out.println("---" + f2[j]);
						if(!set.contains(filePakege[i]+"\\"+f2[j])){
							FileUtils.delete(filePath+"\\"+filePakege[i]+"\\"+f2[j]);
							//System.out.println(filePath+"\\"+filePakege[i]+"\\"+f2[j]+"已经删除了");
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
