package com.hnfnu.zyw.dao.system;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnfnu.zyw.dao.resources.ISourceMoreVoDao;
import com.hnfnu.zyw.vo.SourceMoreVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "/beans.xml" })
public class SourceDaoTest {
	@Autowired
	private ISourceMoreVoDao sourceMoreVoDao;

	@Before
	public void setUp() {
		System.out.println("***************************************");
	}

	@Test
	public void testList() {
		String hql = "from SourceMoreVo where courseId=" + 4;
		//hql += " and categoryId =" + 1;
		List<SourceMoreVo> l = null;

		try {
			l = sourceMoreVoDao.list(hql);
			System.out.println(l.size()+"size");
			for(int i = 0 ; i<l.size();i++){
				
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
