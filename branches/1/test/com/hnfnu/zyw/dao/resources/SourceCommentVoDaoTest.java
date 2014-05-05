package com.hnfnu.zyw.dao.resources;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.vo.SourceVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml" })
public class SourceCommentVoDaoTest {
	@Autowired
	private ISourceCommentVoDao sourceCommentVoDao;
	
	@Autowired
	private ISourceDao sourceDao;

	@Autowired
	public ISourceVoDao sourceVoDao;
	
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
	@Test
	public void testSourceVoPager() {
        try {
        	Pager<SourceVo> sourcePager = sourceVoDao.find("from SourceVo order by id desc", 0, 8);
        	System.out.println(sourcePager.getDatas().size());
        	for(int i = 0;i < sourcePager.getDatas().size();i++){
        		System.out.println(sourcePager.getDatas().get(i));
        	}
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
