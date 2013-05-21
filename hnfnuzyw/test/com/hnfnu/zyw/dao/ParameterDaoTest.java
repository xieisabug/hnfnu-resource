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
		p.setName("���ϰ�");
		p.setType("string");
		p.setValue("����");
		p.setRemark("");
		try{
			parameterDao.add(p);
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		try {
			List<ParameterDto> l = parameterDao.list("from ParameterDto where name=?","���ϰ�");
			parameterDao.delete(l.get(0).getId());
		} catch (Exception e) {
			fail("testAdd��ɾ����������ʧ�ܡ�");
			e.printStackTrace();
		}
		System.out.println("����testAdd��������ݲ��Գɹ���");
	}
	
	@Test
	public void testLoad(){
		ParameterDto p = new ParameterDto();
		p.setName("���ϰ�");
		p.setType("string");
		p.setValue("����");
		p.setRemark("");
		try {
			parameterDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testLoad����������ʱʧ��");
		}
		List<ParameterDto> l=null;
		try {
			l = parameterDao.list("from ParameterDto where name=?","���ϰ�");
			ParameterDto lp = parameterDao.load(l.get(0).getId());
			if(lp == null) fail("testLoad����ȡ����Ϊ�ա�");
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
			e.printStackTrace();
		}
		try {
			parameterDao.delete(l.get(0).getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail("testLoad��ɾ����������ʱ����");
		}
		System.out.println("����testLoad�����Գɹ���");
	}
	
	@After
	public void setDown(){
		System.out.println("***************************************");
	}
	
	
}
