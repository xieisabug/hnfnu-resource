package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.vo.SourceVo;

public interface ISourceVoService {
	public SourceVo load(int id);

	/**
	 * ��ȡ�������й��ܣ�����Listװ��
	 * 
	 * @return
	 */
	public List<SourceVo> list();

	/**
	 *��ȡ�������й��ܣ���Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * 
	 * @return
	 */
	public Map<String, Object> listSourceVo();
	
	
	/**
	 *����courseId��categoryId�����Ӧ�����б�����Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * 
	 * @return
	 */
	public Map<String, Object> listSourceVo(int courseId,int categoryId);
	
	/**
	 *����gradeId��subjectId���ǰ16����Ӧ�����б������������������
	 * 
	 * @return
	 */
	public List<SourceVo> listSourceVoOrder(int gradeId,int subjectId);


	public List<Map<String, Object>> allTree();

	public List<Map<String, Object>> courseTree();

}