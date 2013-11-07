package com.hnfnu.zyw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import com.hnfnu.zyw.dto.system.StudentDto;

public class POITest {

	@Test
	public void testRead() {
		try {
			// WorkbookFactory�����Զ������ĵ������ʹ�һ��excel
			Workbook wb = WorkbookFactory.create(new File("d:/11.xls"));
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
					System.out.println(title);
					String value = getCellValue(row.getCell(j));
					System.out.println(value);
					
					if (title.equals("����")) {
						System.out.println("��������");
						student.setName(value);
						System.out.println(student.getName());
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
				System.out.println(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	@Test
	public void testList01() {
		try {
			Workbook wb = WorkbookFactory
					.create(new File("d:/test/poi/11.xls"));
			Sheet sheet = wb.getSheetAt(0);
			// ��ȡһ��������
			System.out.println(sheet.getLastRowNum());
			Row row = null;
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				// ��ȡһ�ж�����
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					// getCellValue���Ը��ݲ�ͬ�����ͻ�ȡһ��String���͵�ֵ
					System.out.print(getCellValue(row.getCell(j)) + "--");
				}
				System.out.println();
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList02() {
		try {
			Workbook wb = WorkbookFactory
					.create(new File("d:/test/poi/11.xls"));
			Sheet sheet = wb.getSheetAt(0);
			// Ҳ֧����ǿforѭ���ķ�ʽ
			/**
			 * ע����ַ�ʽʹ�ò��࣬��Ϊ��ȡ�����ݲ���һ���Ǵӵ�һ�п�ʼ�ģ� ���ҽ���������Ҳ��һ���������һ��
			 */
			for (Row row : sheet) {
				for (Cell c : row) {
					System.out.print(getCellValue(c) + "----");
				}
				System.out.println();
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testWrite01() {
		Workbook wb = new HSSFWorkbook();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("d:/test/poi/w1.xls");
			// �������
			Sheet sheet = wb.createSheet("����01");
			// ������
			Row row = sheet.createRow(0);
			// �����и�
			row.setHeightInPoints(30);
			// ������ʽ
			CellStyle cs = wb.createCellStyle();
			cs.setAlignment(CellStyle.ALIGN_CENTER);
			cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			cs.setBorderBottom(CellStyle.BORDER_DOTTED);
			cs.setBorderLeft(CellStyle.BORDER_THIN);
			cs.setBorderRight(CellStyle.BORDER_THIN);
			cs.setBorderTop(CellStyle.BORDER_THIN);
			// ������Ԫ��
			Cell c = row.createCell(0);
			// ���õ�Ԫ����ʽ
			c.setCellStyle(cs);
			// ������Ԫ��
			c.setCellValue("��ʶ");
			c = row.createCell(1);
			c.setCellStyle(cs);
			c.setCellValue("�û���");
			// д�������
			wb.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
