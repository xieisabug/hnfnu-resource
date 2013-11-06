package com.hnfnu.zyw.dao.system;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.StudentDto;

@Repository("studentDao")
public class StudnetDaoImpl extends BaseDao<StudentDto> implements
IStudentDao{
	
	public boolean addStudnetBalance(int count,String studentIds) {
		Session session = this.getSession();
		String[] ids = null; 
		if(studentIds != null && !studentIds.equals("")){
			ids = studentIds.split(";");
		}
		Transaction t = null;
		try {
			t = session.beginTransaction();
			for(int i = 0; i < ids.length; i++){
				int id = Integer.parseInt(ids[i]);
				StudentDto s = this.get(id);
				s.setBalance(s.getBalance() + count);
				this.update(s);
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
