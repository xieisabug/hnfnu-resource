package com.hnfnu.zyw.dao.resources;

import com.hnfnu.zyw.dao.system.IMenuDao;
import com.hnfnu.zyw.dto.system.MenuDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml" })
public class SourceCommentVoDaoTest {
	@Autowired
	private ISourceCommentVoDao sourceCommentVoDao;

	@Before
	public void setUp() {
		System.out.println("***************************************");
	}

	@Test
	public void testSourceCommentTree() {
        try {
            List<Map<String,Object>> maps = sourceCommentVoDao.sourceCommentTree(38);
            System.out.println(maps);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
	@After
	public void setDown() {
		System.out.println("***************************************");
	}
}
