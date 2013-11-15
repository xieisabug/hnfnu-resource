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
	 * 获取表中所有功能，是用List装的
	 * @return
	 */
	public List<PicturesDto> list();
	/**
	 *获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	 * @return
	 */
	public Map<String, Object> listPictures();
	
	
	
}
