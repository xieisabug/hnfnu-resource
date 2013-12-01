package com.hnfnu.zyw.dao.website.chart;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dao.website.IChartDao;
import com.hnfnu.zyw.dto.website.chart.CategoryCount;
import com.hnfnu.zyw.dto.website.chart.TopUserSource;

@Repository("categoryCountDao")
public class CategoryCountDaoImpl extends BaseDao<CategoryCount> implements
		IChartDao<CategoryCount> {

}
