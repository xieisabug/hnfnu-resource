package com.hnfnu.zyw.dao.resources;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.SourceCommentDto;

@Repository("sourceCommentDao")
public class SourceCommentDaoImpl extends BaseDao<SourceCommentDto> implements
ISourceCommentDao  {

}
