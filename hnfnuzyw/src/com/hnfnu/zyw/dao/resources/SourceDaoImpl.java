package com.hnfnu.zyw.dao.resources;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.SourceCategoryJoinDto;
import com.hnfnu.zyw.dto.resources.SourceDto;

@Repository("sourceDao")
public class SourceDaoImpl extends BaseDao<SourceDto> implements ISourceDao {


}
