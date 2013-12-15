package com.hnfnu.zyw.service.system;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IStudentDao;
import com.hnfnu.zyw.dto.system.StudentDto;
import com.hnfnu.zyw.dto.system.feedback.AddManyStudentsFB;
import com.hnfnu.zyw.utils.EncodeUtils;
import com.hnfnu.zyw.utils.FileUtils;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {

	@Autowired
	@Qualifier("studentDao")
	public IStudentDao studentDao;

	/**
	 * 增加一个学生
	 * 
	 * @param student 一个学生对象
	 * @return 成功返回true，失败返回false
	 */
	public boolean add(StudentDto student) {
		try {
            String pwd = student.getPassword();
            student.setPassword(EncodeUtils.generatePassword(pwd));
			//新建用户默认资源币为100
			student.setBalance(100);
			Date dt = new Date();
			student.setCreateDate(dt);
			studentDao.add(student);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 删除一个学生
	 * 
	 * @param student 要删除的学生的id
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
	 * 
	 * @param student 已经更新的学生的对象
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
	 * 
	 * @param student 读取的学生的id
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
	 * 
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
	 * 
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
	public int addStudnetBalance(int count, String studentIds) {
		return studentDao.addStudnetBalance(count, studentIds);
	}

	public Map<String, Object> addStudnets(String url) {
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		ArrayList<AddManyStudentsFB> failStudents = new ArrayList<AddManyStudentsFB>();
		Map<String, Object> result = new HashMap<String, Object>();
		Boolean b = true;
		InputStream is = null;
		try {
			// WorkbookFactory可以自动根据文档的类型打开一个excel
			String[] t = url.split("\\.");
			String[] ss = url.split("\\\\");
			url = ss[0]+"\\";
			for(int i = 1;i < ss.length -1; i++){
			url = url +"\\"+ss[i];
			}
			url  = url + "\\"+t[t.length-1]+"\\"+ss[ss.length-1];
            String pwd = EncodeUtils.generatePassword("123456");
            System.out.println(url);
            is = new FileInputStream(url);  
		    HSSFWorkbook wb = new HSSFWorkbook(is);   
			// 获取excel中的某一个数据表
			Sheet sheet = wb.getSheetAt(0);
			// 获取数据表中的某一行
			Row row;
			Row titleRow = sheet.getRow(0);
			//System.out.println("sheet.getLastRowNum():"+sheet.getLastRowNum());
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				// 获取一行多少列
				Boolean flat = true;
				String message = "";
				StudentDto student = new StudentDto();
				for (int j = 0; j < row.getLastCellNum(); j++) {
					Cell titleCell = titleRow.getCell(j);
					Cell valueCell = row.getCell(j);
				
					// 如果标题栏为空则立即终止添加
					if (titleCell == null) {
						return null;
					}
					String title = null;
					String value = null;
					title = getCellValue(titleCell);
					if (valueCell == null) {
						value = null;
					} else {

						value = getCellValue(valueCell);

					}

					if (title.equals("姓名") ||title.equals("名字")) {
						// 名字不能为空
						if (value == null || value.equals("")) {
							flat = false;
							message = message + " 姓名不能为空 ";
						}else{
							student.setName(value);
						}
						
						
					} else if (title.equals("学号")) {
						if (value == null || value.equals("")) {
							flat = false;
							message = message + " 学号不能为空 ";
						}else{
							student.setNumber(value);
							student.setUsername(value);
						}

					} else if (title.equals("专业")) {
						if (value == null || value.equals("")) {
							flat = false;
							message = message + " 专业不能为空 ";
						}else{
							student.setMajor(value);
						}
						
					} else if (title.equals("系部")) {
						if (value == null || value.equals("")) {
							flat = false;
							message = message + " 系部不能为空 ";
						}else{
							student.setDepartment(value);
						}
					} else if (title.equals("入学年份")) {
						if (value == null || value.equals("")) {
							flat = false;
							message = message + " 入学年份不能为空 ";
						}else{
							student.setEntranceTime(value);
						}
					} else if (title.equals("电话号码") || title.equals("联系电话")) {
						student.setTelephone(value);

					} else if (title.equals("备注")) {
						student.setRemark(value);
					}
				}
				// 验证用户名是否重复
				if (this.validateStudent(student.getNumber())) {
					flat = false;
					message = message + " 该学号已经注册";
				}
				
				// 如果该用户不能添加
				if (!flat) {
					AddManyStudentsFB fb = new AddManyStudentsFB(student, message);
					failStudents.add(fb);
					continue;
				}else{
					student.setPassword(pwd);
					student.setBalance(100);
					Date dt = new Date();
					student.setCreateDate(dt);
					students.add(student);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		} finally {
			try {
				is.close();
				FileUtils.deleteOneFile(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (students.size() > 0) {
			b = studentDao.addStudnets(students);
		}
		if (!b) {
			result = null;
		} else {
			result.put("Rows", failStudents);
			result.put("Total", failStudents.size());
		}
		return result;
				
		 
	}

	private String getCellValue(Cell c) {
		String o;
		switch (c.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			o = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			o = String.valueOf(c.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA:
			o = String.valueOf(c.getCellFormula());
			break;
		case Cell.CELL_TYPE_NUMERIC:
			c.setCellType(Cell.CELL_TYPE_STRING);
			o = c.getStringCellValue();
			break;
		case Cell.CELL_TYPE_STRING:
			o = c.getStringCellValue();
			break;
		default:
			o = null;
			break;
		}
		return o;
	}

	public boolean validateStudent(String username) {
		String hql = "from StudentDto where username='" + username + "'";
		StudentDto s = studentDao.getStudent(hql);
		if (s == null) {
			return false;
		}else{
			return true;
		}
	}

	public boolean editManyPassword(String studentIds, String newPassword) {
			ArrayList<StudentDto> students = new ArrayList<StudentDto>();
			String[] ids = studentIds.split(";");
			for (int i = 0; i < ids.length; i++) {
				int id = Integer.parseInt(ids[i]);
				StudentDto student;
				try {
					student = studentDao.get(id);
					student.setPassword(EncodeUtils.generatePassword(newPassword));
					students.add(student);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				
			}
			return studentDao.editManyPassword(students);

	}

}
