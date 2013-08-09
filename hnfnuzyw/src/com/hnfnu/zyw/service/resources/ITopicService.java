package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.TopicDto;

public interface ITopicService {

	public boolean add(TopicDto topic);

	public boolean delete(int id);

	public boolean update(TopicDto topic);

	public TopicDto load(int id);

	/**
	 * ��ȡ��������ר�⣬����Listװ��
	 * 
	 * @return
	 */
	public List<TopicDto> list();
	/**
	 *��ȡ��������ר�⣬��Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * 
	 * @return
	 */
	public Map<String, Object> listTopic();

}
