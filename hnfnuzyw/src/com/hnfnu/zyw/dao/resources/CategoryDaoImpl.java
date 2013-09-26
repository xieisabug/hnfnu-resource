package com.hnfnu.zyw.dao.resources;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.CategoryDto;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDao<CategoryDto> implements
		ICategoryDao {

	public int maxOrder() {
		String sql = "SELECT MAX(ord) FROM r_category";
		DataSource ds= SessionFactoryUtils.getDataSource(getSessionFactory());
		Statement state = null;
		ResultSet rs = null;
		try {
			 state = ds.getConnection().createStatement();
			 rs = state.executeQuery(sql);
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally{
			try {
				rs.close();
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}
		
		//数据库没有数据就返回1
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
					if( Integer.parseInt(orders[j]) == id){
						c.setOrd(j+1);
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

	
	

}
