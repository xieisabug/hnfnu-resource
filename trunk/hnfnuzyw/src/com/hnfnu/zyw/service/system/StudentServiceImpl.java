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

	public boolean addStudnets(String url) {
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		File file = null;
		try {
			// WorkbookFactory�����Զ������ĵ������ʹ�һ��excel
			 file= new File(url);
			Workbook wb = WorkbookFactory.create(file);
			// ��ȡexcel�е�ĳһ�����ݱ�
			Sheet sheet = wb.getSheetAt(0);
			// ��ȡ���ݱ��е�ĳһ��
			Row row = null;
			Row titleRow = sheet.getRow(0);
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				// ��ȡһ�ж�����
				StudentDto student = new StudentDto();
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					String title = getCellValue(titleRow.getCell(j));
					String value = getCellValue(row.getCell(j));
					
					if (title.equals("����")) {
						student.setName(value);
					} else if (title.equals("ѧ��")) {
						student.setNumber(value);
						student.setUsername(value);

					} else if (title.equals("רҵ")) {
						student.setMajor(value);

					} else if (title.equals("ϵ��")) {
						student.setDepartment(value);

					} else if (title.equals("��ѧ���")) {
						student.setEntranceTime(value);

					} else if (title.equals("�绰����") || title.equals("��ϵ�绰")) {
						student.setTelephone(value);

					} else if (title.equals("��ע")) {
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
