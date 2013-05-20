package com.hnfnu.zyw.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnfnu.zyw.dao.system.IParameterDao;
import com.hnfnu.zyw.dto.system.ParameterDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( {"/beans.xml" }) 
public class ParameterDaoTest {
	
	@Autowired
	private IParameterDao parameterDao;
	
	@Test
	public void testAdd(){
		ParameterDto p = new ParameterDto();
		p.setName("Õı¿œ∞Â");
		p.setType("string");
		p.setValue("Õı—‹");
		p.setRemark("");
		try{
			parameterDao.add(p);
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
}
