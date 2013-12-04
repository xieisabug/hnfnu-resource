package com.hnfnu.zyw.dao.website;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.website.PicturesDto;

@Repository("picturesDao")
public class PicturesDaoImpl extends BaseDao<PicturesDto> implements IPicturesDao{

	public int getCount() {
		String sql = "SELECT COUNT(*) FROM f_pictures where display=1";
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
		return 0;
	}
	
	
	

}
