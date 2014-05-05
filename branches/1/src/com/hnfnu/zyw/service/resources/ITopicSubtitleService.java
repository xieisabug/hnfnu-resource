package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.TopicSubtitleDto;

public interface ITopicSubtitleService {

	public boolean add(TopicSubtitleDto topicSubtitle);

	public boolean delete(int id);

	public boolean update(TopicSubtitleDto topicSubtitle);

	public TopicSubtitleDto load(int id);

	/**
	 * ��ȡ�������й��ܣ�����Listװ��
	 * 
	 * @return
	 */
	public List<TopicSubtitleDto> list();

	/**
	 *��ȡר���µ����ж������⣬��Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * 
	 * @return
	 */
	public Map<String, Object> listTopicSubtitle(int topicId);
	public List<TopicSubtitleDto> listByTopicId(int topicId);
}
