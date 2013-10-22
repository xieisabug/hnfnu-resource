package com.hnfnu.zyw.dao.resources;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.CourseDto;
import com.hnfnu.zyw.utils.FileUtils;

@Repository("courseDao")
public class CourseDaoImpl extends BaseDao<CourseDto> implements ICourseDao {

	
	public boolean deleteCourseAndSources(int courseId) {
		Session session = this.getSession();
		String hql1 = "delete CourseDto where id=:id";
		String hql2 = "delete  SourceDto where courseId=:courseId";
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query q = session.createQuery(hql1);
			q.setParameter("id", courseId);
			q.executeUpdate();
			//如果本地文件删除成功，则把资源信息删除
			if(deleteFileByCourseId(courseId)){
			Query q2 = session.createQuery(hql2);
			q2.setParameter("courseId", courseId);
			q2.executeUpdate();
			}else{
				if(t != null){
				 t.rollback();
				}
				return false;
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
	
	
	//根据课程id，删除该课程下所有的本地文件
	private boolean deleteFileByCourseId(int courseId){
		DataSource ds= SessionFactoryUtils.getDataSource(getSessionFactory());
		Statement state = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM r_source where courseId="+courseId;
		boolean r = true;
		try {
			 state = ds.getConnection().createStatement();
			 rs=state.executeQuery(sql);  
	         //ResultSetMetaData rsmd = rs.getMetaData(); //取得数据表中的字段数目，类型等返回结果  
			while(rs.next()){
				String url = rs.getString("url");
				if(!FileUtils.deleteOneFile(url)){
					r = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				rs.close();
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return r;  
	}
	

}
