package com.hnfnu.zyw.dao.website;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.website.PicturesDto;

@Repository("picturesDao")
public class PicturesDaoImpl extends BaseDao<PicturesDto> implements IPicturesDao{

}
