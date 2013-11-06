package com.hnfnu.zyw.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IStudentDao;
import com.hnfnu.zyw.dto.system.StudentDto;


@Service("studentService")
public class StudentServiceImpl implements IStudentService{

	@Autowired
	@Qualifier("studentDao")
	public IStudentDao studentDao;

	/**
	 * ����һ��ѧ��
	 * @param һ��ѧ������
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean add(StudentDto student) {
		try {
			studentDao.add(student);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ɾ��һ��ѧ��
	 * @param Ҫɾ����ѧ����id
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean delete(StudentDto student) {
		try {
			studentDao.delete(student.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ����һ��ѧ��
	 * @param �Ѿ����µ�ѧ���Ķ���
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean update(StudentDto student) {
		try {
			studentDao.update(student);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ��ȡһ��ѧ��
	 * @param ��ȡ��ѧ����id
	 * @return ���ض�ȡ��ѧ������
	 */
	public StudentDto load(StudentDto student) {
		try {
			return studentDao.load(student.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ȡ����ѧ��
	 * @return ��ȡ����ѧ������
	 */
	public List<StudentDto> list() {
		String hql = "from StudentDto";
		List<StudentDto> students = null;
		try {
			students = studentDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	/**
	 * �г����е�ѧ��
	 * @return ����������ѧ����Map
	 */
	public Map<String, Object> listStu() {
		String hql = "from StudentDto";
		Map<String, Object> studentList = new HashMap<String, Object>();
		List<StudentDto> l = null;
		
		try {
			l = studentDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		studentList.put("Rows", l);
		studentList.put("Total", l.size());
		return studentList;
	}

	/**
	 * ��ѧ��������ֵ��Դ��
	 */
	public boolean addStudnetBalance(int count, String studentIds) {
		return studentDao.addStudnetBalance(count, studentIds);
	}
}
