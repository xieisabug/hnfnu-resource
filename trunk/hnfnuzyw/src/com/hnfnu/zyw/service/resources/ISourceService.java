package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.SourceDto;

public interface ISourceService {
	public boolean add(SourceDto source,String categoryList);

	public boolean deleteMessege(int id);

	public boolean update(SourceDto source,String categoryIdList);
	public boolean update(SourceDto source);

	public SourceDto load(int id);

	/**
	 * ��ȡ�������й��ܣ�����Listװ��
	 * 
	 * @return
	 */
	public List<SourceDto> list();

	/**
	 *��ȡ�������й��ܣ���Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * 
	 * @return
	 */
	public Map<String, Object> listSource();

	public int delete(String url,int id);
}
