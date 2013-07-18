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
@ContextConfiguration({ "/beans.xml" })
public class ParameterDaoTest {

	@Autowired
	private IParameterDao parameterDao;

	@Before
	public void setUp() {
		System.out.println("***************************************");
	}

	@Test
	public void testAdd() {
		ParameterDto p = new ParameterDto();
		p.setName("���ϰ�");
		p.setType("string");
		p.setValue("����");
		p.setRemark("");
		try {
			parameterDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		try {
			List<ParameterDto> l = parameterDao.list(
					"from ParameterDto where name=?", "���ϰ�");
			parameterDao.delete(l.get(0).getId());
		} catch (Exception e) {
			fail("testAdd��ɾ��������ʧ�ܡ�");
			e.printStackTrace();
		}
		System.out.println("����testAdd�������ݲ��Գɹ���");
	}

	@Test
	public void testLoad() {
		ParameterDto p = new ParameterDto();
		p.setName("���ϰ�");
		p.setType("string");
		p.setValue("����");
		p.setRemark("");
		try {
			parameterDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testLoad����Ӳ������ʱʧ��");
		}
		List<ParameterDto> l = null;
		try {
			l = parameterDao.list("from ParameterDto where name=?", "���ϰ�");
			ParameterDto lp = parameterDao.load(l.get(0).getId());
			if (lp == null)
				fail("testLoad����ȡ���Ϊ�ա�");
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
			e.printStackTrace();
		}
		try {
			parameterDao.delete(l.get(0).getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail("testLoad��ɾ��������ʱ���?");
		}
		System.out.println("����testLoad�����Լ��سɹ���");
	}

	@Test
	public void testDelete() {
		ParameterDto p = new ParameterDto();
		p.setName("���ϰ�");
		p.setType("string");
		p.setValue("����");
		p.setRemark("");
		try {
			parameterDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testDelete����Ӳ������ʱʧ��");
		}

		List<ParameterDto> l = null;
		try {
			l = parameterDao.list("from ParameterDto where name=?", "���ϰ�");
		} catch (Exception e) {
			e.printStackTrace();
			fail("testDelete�������������ʧ��");
		}
		try {
			parameterDao.delete(l.get(0).getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		System.out.println("����testDelete������ɾ��ɹ�");
	}

	@Test
	public void testUpdate() {
		ParameterDto p = new ParameterDto();
		p.setName("���ϰ�");
		p.setType("string");
		p.setValue("����");
		p.setRemark("");
		try {
			parameterDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testUpdate����Ӳ������ʱʧ��");
		}

		List<ParameterDto> l = null;
		try {
			l = parameterDao.list("from ParameterDto where name=?", "���ϰ�");
		} catch (Exception e) {
			e.printStackTrace();
			fail("testUpdate�������������ʧ��");
		}
		int id = l.get(0).getId();
		ParameterDto t = new ParameterDto();
		t.setName("2");
		t.setType("2");
		t.setValue("2");
		t.setRemark("2");
		t.setId(id);
		try {
			parameterDao.update(t);
			System.out.println("testUpdate:�������");
		} catch (Exception e1) {
			e1.printStackTrace();
			fail(e1.getLocalizedMessage());
		}
		try {
			parameterDao.delete(l.get(0).getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail("testUpdate��ɾ��������ʧ��");
		}
		System.out.println("����testUpdate�����Ը��³ɹ�");
	}

	@Test
	public void testList() {
		ParameterDto p = new ParameterDto();
		p.setName("���ϰ�");
		p.setType("string");
		p.setValue("����");
		p.setRemark("");
		ParameterDto q = new ParameterDto();
		q.setName("�����");
		q.setType("string");
		q.setValue("��˧");
		q.setRemark("");
		try {
			parameterDao.add(p);
			parameterDao.add(q);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testList����Ӳ������ʧ��");
		}
		List<ParameterDto> l = null;
		try {
			l = parameterDao.list("from ParameterDto where type=?", "string");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		if (l.size() != 2) {
			fail("��ȡ�б����������ȷ��");
		}

		try {
			for (int i = 0; i < l.size(); i++) {
				parameterDao.delete(l.get(i).getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("testList��ɾ��������ʧ��");
		}

		System.out.println("����testList�����Ի�ȡ�б���ݳɹ�");
	}

	@After
	public void setDown() {
		System.out.println("***************************************");
	}

	
	
	
}
