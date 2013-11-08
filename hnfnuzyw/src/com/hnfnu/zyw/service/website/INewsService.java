package com.hnfnu.zyw.service.website;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.website.NewsDto;

public interface INewsService {
	
	public boolean add(NewsDto news);

	public boolean delete(NewsDto news);

	public boolean update(NewsDto news);

	public NewsDto load(NewsDto news);

	
	/**
	 * ��ȡ�������й��ܣ�����Listװ��
	 * @return
	 */
	public List<NewsDto> list();
	/**
	 *��ȡ�������й��ܣ���Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * @return
	 */
	public Map<String, Object> listNews();
	

}
