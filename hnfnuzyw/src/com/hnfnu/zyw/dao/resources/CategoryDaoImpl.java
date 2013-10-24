package com.hnfnu.zyw.dao.resources;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.CategoryDto;
import com.hnfnu.zyw.dto.resources.SourceDto;
import com.hnfnu.zyw.utils.FileUtils;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDao<CategoryDto> implements
		ICategoryDao {

	public int maxOrder() {
		String sql = "SELECT MAX(ord) FROM r_category";
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		Statement state = null;
		ResultSet rs = null;
		try {
			state = ds.getConnection().createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				rs.close();
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}

		// 数据库没有数据就返回1
		return 1;
	}

	public boolean setCategorysOrder(String[] orders) {
		Session session = this.getSession();
		String hql = "from CategoryDto order by id asc";
		Transaction t = null;
		try {
			t = session.beginTransaction();
			List<CategoryDto> categorys = this.list(hql);
			for (int i = 0; i < categorys.size(); i++) {
				CategoryDto c = categorys.get(i);
				int id = c.getId();
				for (int j = 0; j < orders.length; j++) {
					if (Integer.parseInt(orders[j]) == id) {
						c.setOrd(j + 1);
						break;
					}
				}
				this.update(c);
			}
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean deleteCategoryAndSource(int categoryId) {
		
		Session session = this.getSession();
		List<SourceDto> l = null;
		Transaction t = null;
		try {
			t = session.beginTransaction();
			l = getSourceDtos(categoryId);
			this.delete(categoryId);
			for (int i = 0; i < l.size(); i++) {
				System.out.println("11111111111111111");
				SourceDto s = l.get(i);
				//如果该资源不属于其他的类别，就删除该资源和删除该资源的本地文件
				if(!blongOtherCategory(s.getId())){
					System.out.println("22222222222222222222");
					//如果本地文件删除成功就删除该资源的信息
					if(FileUtils.deleteOneFile(s.getUrl())){
					System.out.println("333333333333333333333");
					this.deleteSource(s.getId());
					}else{
						t.rollback();
					}
				}
				System.out.println("444444444444444444444");
				
			}
			
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	/**
	 * 根据类别id查出该类别下的所有资源
	 * 
	 * @param categoryId
	 * @return
	 */
	private List<SourceDto> getSourceDtos(int categoryId) {
		String sql1 = "select t1.id,t1.url from r_source as t1,r_source_category_join as t2 where t2.sourceId=t1.id and t2.categoryId = " + categoryId;
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		Statement state = null;
		ResultSet rs = null;
		List<SourceDto> l = new ArrayList<SourceDto>();
		try {
			state = ds.getConnection().createStatement();
			rs = state.executeQuery(sql1);
			while (rs.next()) {
				int id = rs.getInt("id");
				String url = rs.getString("url");
				SourceDto s = new SourceDto();
				s.setId(id);
				s.setUrl(url);
				l.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return l;
	}

	/**
	 * 根据资源id判断该资源是否还属于其他资源
	 * 
	 * @param sourceId
	 * @return
	 */
	private boolean blongOtherCategory(int sourceId) throws Exception {

		String sql1 = "select * from r_source_category_join where sourceId="
				+ sourceId;
		DataSource ds = SessionFactoryUtils.getDataSource(getSessionFactory());
		Statement state = null;
		ResultSet rs = null;
		state = ds.getConnection().createStatement();
		rs = state.executeQuery(sql1);
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean deleteSource(int sourceId) {

		String sql1 = "delete SourceDto where id=:id";
		Session session = this.getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(sql1);
			q.setParameter("id", sourceId);
			q.executeUpdate();
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return false;
		} finally {
			session.close();
		}
		return true;
		
	}

	
	
}
