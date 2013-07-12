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

}
