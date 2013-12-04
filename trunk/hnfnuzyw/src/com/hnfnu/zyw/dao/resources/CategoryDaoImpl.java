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

		// Êý¾Ý¿âÃ»ÓÐÊý¾Ý¾Í·µ»Ø1
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
				SourceDto s = l.get(i);
				//Èç¹û¸Ã×ÊÔ´²»ÊôÓÚÆäËûµÄÀà±ð£¬¾ÍÉ¾³ý¸Ã×ÊÔ´ºÍÉ¾³ý¸Ã×ÊÔ´µÄ±¾µØÎÄ¼þ
				if(!blongOtherCategory(s.getId())){
					//Èç¹û±¾µØÎÄ¼þÉ¾³ý³É¹¦¾ÍÉ¾³ý¸Ã×ÊÔ´µÄÐÅÏ¢
					if(FileUtils.deleteOneFile(s.getUrl())){
					this.deleteSource(s.getId());
					}else{
						t.rollback();
					}
				}
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
	 * ¸ù¾ÝÀà±ðid²é³ö¸ÃÀà±ðÏÂµÄËùÓÐ×ÊÔ´
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
	 * ¸ù¾Ý×ÊÔ´idÅÐ¶Ï¸Ã×ÊÔ´ÊÇ·ñ»¹ÊôÓÚÆäËû×ÊÔ´
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
