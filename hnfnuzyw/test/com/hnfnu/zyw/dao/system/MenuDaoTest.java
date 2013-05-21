package com.hnfnu.zyw.dao.system;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnfnu.zyw.dto.system.MenuDto;
import com.hnfnu.zyw.dto.system.ParameterDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml" })
public class MenuDaoTest {
	@Autowired
	private IMenuDao menuDao;

	@Before
	public void setUp(){
		System.out.println("***************************************");
	}
	
	
	@Test
	public void testAdd() {
		MenuDto p = new MenuDto();
		p.setName("系统管理");
		p.setUrl("rtertretyr");
		p.setParentId(5);
		p.setIcon("ertert");
		p.setFunctionIdList("urye");
		try {
			menuDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testAdd:菜单添加成功");
		}
		
		try {
			List<MenuDto> l = menuDao.list("from MenuDto where name='系统管理'");
			menuDao.delete(l.get(0).getId());
		} catch (Exception e) {
			fail("testAdd：删除测试数据失败。");
			e.printStackTrace();
		}
		System.out.println("！！testAdd：添加数据测试成功。");
	}
	
	
	@Test
	public void testLoad(){
		MenuDto p = new MenuDto();
		p.setName("系统管理");
		p.setUrl("rtertretyr");
		p.setParentId(5);
		p.setIcon("ertert");
		p.setFunctionIdList("urye");
		try {
			menuDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testAdd:菜单添加成功");
		}
		List<MenuDto> l = null;
		try {
			 l = menuDao.list("from MenuDto where name='系统管理'");
			menuDao.load(l.get(0).getId());
		} catch (Exception e) {
			fail("testAdd：查询测试数据失败。");
			e.printStackTrace();
		}
		
		try {
			menuDao.delete(l.get(0).getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail("testLoad：删除测试数据时出错。");
		}
		System.out.println("！！testLoad：查询数据测试成功。");
		
	}
	
	@Test
	public void testDelete(){
		MenuDto p = new MenuDto();
		p.setName("系统管理");
		p.setUrl("rtertretyr");
		p.setParentId(5);
		p.setIcon("ertert");
		p.setFunctionIdList("urye");
		try {
			menuDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testDelete:菜单添加失败");
		}
		List<MenuDto> l = null;
		try {
			 l = menuDao.list("from MenuDto where name='系统管理'");
			menuDao.delete(l.get(0).getId());
		} catch (Exception e) {
			fail("testDelete：删除测试数据失败。");
			e.printStackTrace();
		}
		System.out.println("！！testDelete：删除数据测试成功。");
	}
	
	@Test
	public void testUpdate(){
		MenuDto p = new MenuDto();
		p.setName("系统管理");
		p.setUrl("rtertretyr");
		p.setParentId(5);
		p.setIcon("ertert");
		p.setFunctionIdList("urye");
		
		try {
			
			menuDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testAdd:菜单添加失败");
		}
		p.setName("系统管理2号");
		List<MenuDto> l = null;
		try {
			l = menuDao.list("from MenuDto where name='系统管理'");
			p.setId(l.get(0).getId());
			menuDao.update(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testUpdate:菜单更新成功");
		}
		
		try {
			menuDao.delete(l.get(0).getId());
		} catch (Exception e) {
			fail("testAdd：删除测试数据失败。");
			e.printStackTrace();
		}
		System.out.println("！！testUpdate：数据测试成功。");
		
	}
	
	@Test
	public void testList(){
		MenuDto p = new MenuDto();
		p.setName("系统管理");
		p.setUrl("rtertretyr");
		p.setParentId(5);
		p.setIcon("ertert");
		p.setFunctionIdList("urye");
		
		
		MenuDto pp = new MenuDto();
		pp.setName("系统管理");
		pp.setUrl("rtertretyr");
		pp.setParentId(5);
		pp.setIcon("ertert");
		pp.setFunctionIdList("urye");
		try {
			menuDao.add(p);
			menuDao.add(pp);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testList:菜单添加失败");
		}
		
		
		
		String hql = "from MenuDto where name=?";
		List<MenuDto> menus = null;
		
		try {
			menus = menuDao.list(hql,new String[]{"系统管理"});
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("testList;查询数据组失败。");
		}
		assertEquals(2, menus.size());
		
		
		System.out.println("！！testList：查询数据数组测试成功。");
	}
	
	@After
	public void setDown(){
		System.out.println("***************************************");
	}
}
