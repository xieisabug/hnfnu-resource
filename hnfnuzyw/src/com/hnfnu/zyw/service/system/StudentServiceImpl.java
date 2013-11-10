package com.hnfnu.zyw.service.system;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

	public boolean addStudnets(String url) {
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		File file = null;
		try {
			// WorkbookFactory可以自动根据文档的类型打开一个excel
			 file= new File(url);
			Workbook wb = WorkbookFactory.create(file);
			// 获取excel中的某一个数据表
			Sheet sheet = wb.getSheetAt(0);
			// 获取数据表中的某一行
			Row row = null;
			Row titleRow = sheet.getRow(0);
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				// 获取一行多少列
				StudentDto student = new StudentDto();
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					String title = getCellValue(titleRow.getCell(j));
					String value = getCellValue(row.getCell(j));
					
					if (title.equals("姓名")) {
						student.setName(value);
					} else if (title.equals("学号")) {
						student.setNumber(value);
						student.setUsername(value);

					} else if (title.equals("专业")) {
						student.setMajor(value);

					} else if (title.equals("系部")) {
						student.setDepartment(value);

					} else if (title.equals("入学年份")) {
						student.setEntranceTime(value);

					} else if (title.equals("电话号码") || title.equals("联系电话")) {
						student.setTelephone(value);

					} else if (title.equals("备注")) {
						student.setRemark(value);
					}
				}
				student.setPassword("123456");
				student.setBalance(100);
				Date dt = new Date();
				student.setCreateDate(dt);
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			file.delete();
		}
		
		//System.out.println(url);
		//FileUtils.deleteOneFile(url);
		
		
		return studentDao.addStudnets(students);
	}
	
	
	private String getCellValue(Cell c) {
		String o = null;
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
			//o = String.valueOf(c.getNumericCellValue());
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
}
