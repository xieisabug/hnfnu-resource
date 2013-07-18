package com.hnfnu.zyw.dao.system;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.vo.SourceVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "/beans.xml" })
public class SourceDaoTest {
	@Autowired
	private ISourceVoDao sourceVoDao;

	@Before
	public void setUp() {
		System.out.println("***************************************");
	}

	@Test
	public void testList() {
		String sql = "from SourceVo where id in(select t2.id from SourceCategoryJoinDto as t1,SourceDto as t2,CategoryDto as t3 where t1.sourceId = t2.id and t1.categoryId = t3.id and t2.courseId = 4 and t3.id = 1)";
		// hql += " and categoryId =" + 1;
		List<SourceVo> l = null;

		try {
			l = sourceVoDao.sourceVoList(sql);
			System.out.println(l.size() + "size");
			for (int i = 0; i < l.size(); i++) {

				System.out.println(l.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void setDown() {
		System.out.println("***************************************");
	}
}
