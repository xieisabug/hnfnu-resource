package com.hnfnu.zyw.dao.website;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.website.NewsDto;

@Repository("newsDao")
public class NewsDaoImpl extends BaseDao<NewsDto> implements INewsDao{

}
