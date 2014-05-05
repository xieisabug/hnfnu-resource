package com.hnfnu.zyw.dao.website.chart;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dao.website.IChartDao;
import com.hnfnu.zyw.vo.chart.SubjectCount;

@Repository("subjectCountDao")
public class SubjectCountDaoImpl extends BaseDao<SubjectCount> implements
		IChartDao<SubjectCount> {

}
