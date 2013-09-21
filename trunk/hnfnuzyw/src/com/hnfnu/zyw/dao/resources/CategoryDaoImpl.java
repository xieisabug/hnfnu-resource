package com.hnfnu.zyw.dao.resources;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

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

}
