package com.hnfnu.zyw.dao.website.chart;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dao.website.IChartDao;
import com.hnfnu.zyw.dto.website.chart.GradeCount;

@Repository("gradeCountDao")
public class GradeCountDaoImpl extends BaseDao<GradeCount> implements
		IChartDao<GradeCount> {

}
