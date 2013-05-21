package com.hnfnu.zyw.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
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
	
	@Before
	public void setUp(){
		System.out.println("***************************************");
	}
	
	@Test
	public void testAdd(){
		ParameterDto p = new ParameterDto();
		p.setName("王老板");
		p.setType("string");
		p.setValue("王衍");
		p.setRemark("");
		try{
			parameterDao.add(p);
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		try {
			List<ParameterDto> l = parameterDao.list("from ParameterDto where name=?","王老板");
			parameterDao.delete(l.get(0).getId());
		} catch (Exception e) {
			fail("testAdd：删除测试数据失败。");
			e.printStackTrace();
		}
		System.out.println("！！testAdd：添加数据测试成功。");
	}
	
	@Test
	public void testLoad(){
		ParameterDto p = new ParameterDto();
		p.setName("王老板");
		p.setType("string");
		p.setValue("王衍");
		p.setRemark("");
		try {
			parameterDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testLoad：加如数据时失败");
		}
		List<ParameterDto> l=null;
		try {
			l = parameterDao.list("from ParameterDto where name=?","王老板");
			ParameterDto lp = parameterDao.load(l.get(0).getId());
			if(lp == null) fail("testLoad：获取数据为空。");
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
			e.printStackTrace();
		}
		try {
			parameterDao.delete(l.get(0).getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail("testLoad：删除测试数据时出错。");
		}
		System.out.println("！！testLoad：测试成功。");
	}
	
	@After
	public void setDown(){
		System.out.println("***************************************");
	}
	
	
}
