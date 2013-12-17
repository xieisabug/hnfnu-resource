package com.hnfnu.zyw.dao.system;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.StudentDto;

@Repository("studentDao")
public class StudentDaoImpl extends BaseDao<StudentDto> implements IStudentDao {
	/**
	 * 批量给学生修改资源币，在原有的基础上修改
	 */
	public int addStudnetBalance(int count, String studentIds) {
		Session session = this.getSession();
		String[] ids = null;
		if (studentIds != null && !studentIds.equals("")) {
			ids = studentIds.split(";");
		} else {
			return 0;
		}
		Transaction t = null;
		try {
			t = session.beginTransaction();
			for (int i = 0; i < ids.length; i++) {
				int id = Integer.parseInt(ids[i]);
				StudentDto s = this.get(id);
				s.setBalance(s.getBalance() + count);

				// 余额不能为负数
				if (s.getBalance() < 0) {
					t.rollback();
					return -1;
				}
				// 余额不能超过整数范围
				if (s.getBalance() > 1000000000) {
					return -2;
				}
				this.update(s);
			}
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	/**
	 * 批量给学生重置资源币，不管学生原有的资源币
	 */
	public int setStudnetBalance(int count,String studentIds) {
		Session session = this.getSession();
		String[] ids = null; 
		if(studentIds != null && !studentIds.equals("")){
			ids = studentIds.split(";");
		}else{
			return 0;
		}
		Transaction t = null;
		try {
			t = session.beginTransaction();
			for(int i = 0; i < ids.length; i++){
				int id = Integer.parseInt(ids[i]);
				StudentDto s = this.get(id);
					s.setBalance(count);
				
				//余额不能为负数
				if(s.getBalance()<0){
						t.rollback();
						return -1;
				}
				//余额不能超过整数范围
				if(s.getBalance() > 1000000000){
					return -2;
				}
				this.update(s);
			}
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	
	/**
	 * 批量删除学生,0是删除不成功，1是成功
	 */
	public int deleteStudents(String studentIds) {
		Session session = this.getSession();
		String[] ids = null; 
		if(studentIds != null && !studentIds.equals("")){
			ids = studentIds.split(";");
		}else{
			return 0;
		}
		Transaction t = null;
		try {
			t = session.beginTransaction();
			for(int i = 0; i < ids.length; i++){
				int id = Integer.parseInt(ids[i]);
				this.delete(id);
			}
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	/**
	 * 批量注册学生
	 */
	public boolean addStudnets(ArrayList<StudentDto> students) {
		Session session = this.getSession();
		/*
		 * if(students.size() == 0){ return false; }
		 */
		Transaction t = null;
		try {
			t = session.beginTransaction();
			for (int i = 0; i < students.size(); i++) {
				StudentDto s = students.get(i);
				this.add(s);
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

	public StudentDto getStudent(String hql) {
		Query u = this.getSession().createQuery(hql);
		StudentDto d = (StudentDto) u.uniqueResult();
		return d;
	}

	public boolean editManyPassword(ArrayList<StudentDto> students) {
		Session session = this.getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			for (int i = 0; i < students.size(); i++) {
				StudentDto s = students.get(i);
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
