package com.hnfnu.zyw.service.website;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.website.PicturesDto;

public interface IPicturesService {
	
	public boolean add(PicturesDto picture);

	public boolean delete(PicturesDto picture);

	public boolean update(PicturesDto picture);

	public PicturesDto load(PicturesDto picture);

	
	/**
	 * ��ȡ�������й��ܣ�����Listװ��
	 * @return
	 */
	public List<PicturesDto> list();
	/**
	 *��ȡ�������й��ܣ���Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * @return
	 */
	public Map<String, Object> listPictures();
	
	
	
}
