package com.hnfnu.zyw.dao.system;

import static org.junit.Assert.fail;

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
			fail(e.getLocalizedMessage());
		}
	}
}
