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
			// WorkbookFactory可以自动根据文档的类型打开一个excel
			Workbook wb = WorkbookFactory.create(new File("d:/11.xls"));
			// 获取excel中的某一个数据表
			Sheet sheet = wb.getSheetAt(0);
			// 获取数据表中的某一行
			Row row = null;
			Row titleRow = sheet.getRow(0);
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				// 获取一行多少列
				StudentDto student = null;
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					student = new StudentDto();
					String title = getCellValue(titleRow.getCell(j));
					System.out.println(title);
					String value = getCellValue(row.getCell(j));
					System.out.println(value);
					
					if (title.equals("姓名")) {
						System.out.println("我是姓名");
						student.setName(value);
						System.out.println(student.getName());
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
			o = String.valueOf(c.getNumericCellValue());
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
			// 获取一共多少行
			System.out.println(sheet.getLastRowNum());
			Row row = null;
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				// 获取一行多少列
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					// getCellValue可以根据不同的类型获取一个String类型的值
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
			// 也支持增强for循环的方式
			/**
			 * 注意该种方式使用不多，因为读取的数据并不一定是从第一行开始的， 而且结束的数据也不一定就是最后一行
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
			// 创建表格
			Sheet sheet = wb.createSheet("测试01");
			// 创建行
			Row row = sheet.createRow(0);
			// 设置行高
			row.setHeightInPoints(30);
			// 创建样式
			CellStyle cs = wb.createCellStyle();
			cs.setAlignment(CellStyle.ALIGN_CENTER);
			cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			cs.setBorderBottom(CellStyle.BORDER_DOTTED);
			cs.setBorderLeft(CellStyle.BORDER_THIN);
			cs.setBorderRight(CellStyle.BORDER_THIN);
			cs.setBorderTop(CellStyle.BORDER_THIN);
			// 创建单元格
			Cell c = row.createCell(0);
			// 设置单元格样式
			c.setCellStyle(cs);
			// 创建单元格
			c.setCellValue("标识");
			c = row.createCell(1);
			c.setCellStyle(cs);
			c.setCellValue("用户名");
			// 写到输出流
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
