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
	 * 增加一个学生
	 * @param 一个学生对象
	 * @return 成功返回true，失败返回false
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
	 * 删除一个学生
	 * @param 要删除的学生的id
	 * @return 成功返回true，失败返回false
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
	 * 更新一个学生
	 * @param 已经更新的学生的对象
	 * @return 成功返回true，失败返回false
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
	 * 读取一个学生
	 * @param 读取的学生的id
	 * @return 返回读取的学生对象
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
	 * 获取所有学生
	 * @return 获取到的学生集合
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
	 * 列出所有的学生
	 * @return 保存了所有学生的Map
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
	 * 给学生批量充值资源币
	 */
	public boolean addStudnetBalance(int count, String studentIds) {
		return studentDao.addStudnetBalance(count, studentIds);
	}
}
