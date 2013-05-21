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
		p.setName("王老板");
		p.setType("string");
		p.setValue("王衍");
		p.setRemark("");
		try {
			parameterDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		try {
			List<ParameterDto> l = parameterDao.list(
					"from ParameterDto where name=?", "王老板");
			parameterDao.delete(l.get(0).getId());
		} catch (Exception e) {
			fail("testAdd：删除测试数据失败。");
			e.printStackTrace();
		}
		System.out.println("！！testAdd：添加数据测试成功。");
	}

	@Test
	public void testLoad() {
		ParameterDto p = new ParameterDto();
		p.setName("王老板");
		p.setType("string");
		p.setValue("王衍");
		p.setRemark("");
		try {
			parameterDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testLoad：添加测试数据时失败");
		}
		List<ParameterDto> l = null;
		try {
			l = parameterDao.list("from ParameterDto where name=?", "王老板");
			ParameterDto lp = parameterDao.load(l.get(0).getId());
			if (lp == null)
				fail("testLoad：获取数据为空。");
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
		System.out.println("！！testLoad：测试加载成功。");
	}

	@Test
	public void testDelete() {
		ParameterDto p = new ParameterDto();
		p.setName("王老板");
		p.setType("string");
		p.setValue("王衍");
		p.setRemark("");
		try {
			parameterDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testDelete：添加测试数据时失败");
		}

		List<ParameterDto> l = null;
		try {
			l = parameterDao.list("from ParameterDto where name=?", "王老板");
		} catch (Exception e) {
			e.printStackTrace();
			fail("testDelete：测试输入加载失败");
		}
		try {
			parameterDao.delete(l.get(0).getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		System.out.println("！！testDelete：测试删除成功");
	}

	@Test
	public void testUpdate() {
		ParameterDto p = new ParameterDto();
		p.setName("王老板");
		p.setType("string");
		p.setValue("王衍");
		p.setRemark("");
		try {
			parameterDao.add(p);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testUpdate：添加测试数据时失败");
		}

		List<ParameterDto> l = null;
		try {
			l = parameterDao.list("from ParameterDto where name=?", "王老板");
		} catch (Exception e) {
			e.printStackTrace();
			fail("testUpdate：测试输入加载失败");
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
			System.out.println("testUpdate:更新完毕");
		} catch (Exception e1) {
			e1.printStackTrace();
			fail(e1.getLocalizedMessage());
		}
		try {
			parameterDao.delete(l.get(0).getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail("testUpdate：删除测试数据失败");
		}
		System.out.println("！！testUpdate：测试更新成功");
	}

	@Test
	public void testList() {
		ParameterDto p = new ParameterDto();
		p.setName("王老板");
		p.setType("string");
		p.setValue("王衍");
		p.setRemark("");
		ParameterDto q = new ParameterDto();
		q.setName("贺赛二");
		q.setType("string");
		q.setValue("贺帅");
		q.setRemark("");
		try {
			parameterDao.add(p);
			parameterDao.add(q);
		} catch (Exception e) {
			e.printStackTrace();
			fail("testList：添加测试数据失败");
		}
		List<ParameterDto> l = null;
		try {
			l = parameterDao.list("from ParameterDto where type=?", "string");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		if (l.size() != 2) {
			fail("获取列表的数量不正确！");
		}

		try {
			for (int i = 0; i < l.size(); i++) {
				parameterDao.delete(l.get(i).getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("testList：删除测试数据失败");
		}

		System.out.println("！！testList：测试获取列表数据成功");
	}

	@After
	public void setDown() {
		System.out.println("***************************************");
	}

}
