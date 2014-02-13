package com.hnfnu.zyw.dao.system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnfnu.zyw.dto.system.MenuDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml" })
public class MenuDaoTest {
	
	@Autowired
	private IMenuDao menuDao;

	@Before
	public void setUp() {
		System.out.println("****     ***********************************");
	}

	@Test
	public void testAdd() {
		 System.out.println("1111111111111111111");
		 String filePath = ServletActionContext.getServletContext().getRealPath("/");
		 System.out.println("filePath"+filePath);
	}

	@Test
	public void testLoad() {
		MenuDto p = new MenuDto();
		p.setName("ϵͳ����");
		p.setUrl("rtertretyr");
		p.setParentId(5);
		p.setIcon("ertert");
		p.setFunctionIdList("urye");
		try {
			menuDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testAdd:�˵���ӳɹ�");
		}
		List<MenuDto> l = null;
		try {
			l = menuDao.list("from MenuDto where name='ϵͳ����'");
			menuDao.load(l.get(0).getId());
		} catch (Exception e) {
			fail("testAdd����ѯ�������ʧ�ܡ�");
			e.printStackTrace();
		}

		try {
			menuDao.delete(l.get(0).getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail("testLoad��ɾ��������ʱ���?");
		}
		System.out.println("����testLoad����ѯ��ݲ��Գɹ���");

	}

	@Test
	public void testDelete() {
		MenuDto p = new MenuDto();
		p.setName("ϵͳ����");
		p.setUrl("rtertretyr");
		p.setParentId(5);
		p.setIcon("ertert");
		p.setFunctionIdList("urye");
		try {
			menuDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testDelete:�˵����ʧ��");
		}
		List<MenuDto> l = null;
		try {
			l = menuDao.list("from MenuDto where name='ϵͳ����'");
			menuDao.delete(l.get(0).getId());
		} catch (Exception e) {
			fail("testDelete��ɾ��������ʧ�ܡ�");
			e.printStackTrace();
		}
		System.out.println("����testDelete��ɾ����ݲ��Գɹ���");
	}

	@Test
	public void testUpdate() {
		MenuDto p = new MenuDto();
		p.setName("ϵͳ����");
		p.setUrl("rtertretyr");
		p.setParentId(5);
		p.setIcon("ertert");
		p.setFunctionIdList("urye");

		try {

			menuDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testAdd:�˵����ʧ��");
		}
		p.setName("ϵͳ����2��");
		List<MenuDto> l = null;
		try {
			l = menuDao.list("from MenuDto where name='ϵͳ����'");
			p.setId(l.get(0).getId());
			menuDao.update(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testUpdate:�˵����³ɹ�");
		}

		try {
			menuDao.delete(l.get(0).getId());
		} catch (Exception e) {
			fail("testAdd��ɾ��������ʧ�ܡ�");
			e.printStackTrace();
		}
		System.out.println("����testUpdate����ݲ��Գɹ���");

	}

	@Test
	public void testList() {
		MenuDto p = new MenuDto();
		p.setName("ϵͳ����");
		p.setUrl("rtertretyr");
		p.setParentId(5);
		p.setIcon("ertert");
		p.setFunctionIdList("urye");

		MenuDto pp = new MenuDto();
		pp.setName("ϵͳ����");
		pp.setUrl("rtertretyr");
		pp.setParentId(5);
		pp.setIcon("ertert");
		pp.setFunctionIdList("urye");
		try {
			menuDao.add(p);
			menuDao.add(pp);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testList:�˵����ʧ��");
		}

		String hql = "from MenuDto where name=?";
		List<MenuDto> menus = null;

		try {
			menus = menuDao.list(hql, new String[] { "ϵͳ����" });

		} catch (Exception e) {
			e.printStackTrace();
			fail("testList;��ѯ�����ʧ�ܡ�");
		}
		assertEquals(2, menus.size());

		System.out.println("����testList����ѯ���������Գɹ���");
	}

	@After
	public void setDown() {
		System.out.println("***************************************");
	}
}
