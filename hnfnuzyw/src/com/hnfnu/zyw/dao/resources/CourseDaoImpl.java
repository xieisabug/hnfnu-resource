package com.hnfnu.zyw.dao.resources;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
			//Èç¹û±¾µØÎÄ¼þÉ¾³ý³É¹¦£¬Ôò°Ñ×ÊÔ´ÐÅÏ¢É¾³ý
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
	
	
	//¸ù¾Ý¿Î³Ìid£¬É¾³ý¸Ã¿Î³ÌÏÂËùÓÐµÄ±¾µØÎÄ¼þ
	private boolean deleteFileByCourseId(int courseId){
		DataSource ds= SessionFactoryUtils.getDataSource(getSessionFactory());
		Statement state = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM r_source where courseId="+courseId;
		boolean r = true;
		try {
			 state = ds.getConnection().createStatement();
			 rs=state.executeQuery(sql);  
	         //ResultSetMetaData rsmd = rs.getMetaData(); //È¡µÃÊý¾Ý±íÖÐµÄ×Ö¶ÎÊýÄ¿£¬ÀàÐÍµÈ·µ»Ø½á¹û  
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
