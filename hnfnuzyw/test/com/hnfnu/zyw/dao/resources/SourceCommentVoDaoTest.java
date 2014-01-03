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
	
	@Autowired
	private ISourceDao sourceDao;

	@Before
	public void setUp() {
		System.out.println("***************************************");
	}

	@Test
	public void testSourceCommentTree() {
        try {
        	
            System.out.println(sourceDao.getTotalCount("select count(*) from SourceDto union select count(*) from TopicSourceDto)"));
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
