package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.TopicSourceDto;

public interface ITopicSourceService {

	public boolean add(TopicSourceDto topicSource);

	public boolean delete(int id);

	public boolean update(TopicSourceDto topicSource);

	public TopicSourceDto load(int id);

	/**
	 * ��ȡ�������й��ܣ�����Listװ��
	 * 
	 * @return
	 */
	public List<TopicSourceDto> list();

	/**
	 *��ȡ�������й��ܣ���Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * 
	 * @return
	 */
	public Map<String, Object> listTopicSource();
	
}
