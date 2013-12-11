package com.hnfnu.zyw.service.system;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.utils.EncodeUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IUserDao;
import com.hnfnu.zyw.dto.system.StudentDto;
import com.hnfnu.zyw.dto.system.UserDto;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier("userDao")
	public IUserDao userDao;

	public boolean add(UserDto user) {
		try {
            String pwd = user.getPassword();
            user.setPassword(EncodeUtils.generatePassword(pwd));
			// 老师默认资源币为0
			user.setBalance(0);
			Date today = new Date();
			user.setCreateDate(today);
			user.setLatestLoginDate(today);
			userDao.add(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			userDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(UserDto user) {
		try {
			UserDto u = userDao.get(user.getId());
			user.setPassword(u.getPassword());
			userDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public UserDto load(int id) {
		try {
			return userDao.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Object> list() {
		Map<String, Object> userList = new HashMap<String, Object>();

		String hql = "from UserDto";
		List<UserDto> users = null;
		try {
			users = userDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		userList.put("Rows", users);
		userList.put("Total", users.size());
		return userList;
	}

	public boolean updatePwd(int id, String newPassword) {
		// UserDto u = this.load(id);
		// if (u != null) {
		// u.setPassword(newPassword);
		// return this.update(u);
		// }
		try {
			userDao.updatePwd(id, newPassword);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	/**
	 * 检验用户名是否重复
	 * 
	 * @param username
	 * @return
	 */
	public boolean validateUserName(String username) {
		String hql = "from UserDto where username='" + username + "'";
		UserDto u = null;
		try {
			//System.out.println("***************************" + username);
			u = userDao.getUser(hql);
			//System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (u == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 给用户批量充值资源币
	 */
	public int addUserBalance(int count, String userIds) {
		return userDao.addUserBalance(count, userIds);
	}
	/**
	 * 批量注册用户
	 * @param url
	 * @return
	 */
	public boolean addUsers(String url) {
		ArrayList<UserDto> users = new ArrayList<UserDto>();
		File file = null;
		try {
			// WorkbookFactory可以自动根据文档的类型打开一个excel
			file = new File(url);
            String pwd = EncodeUtils.generatePassword("123456");
			Workbook wb = WorkbookFactory.create(file);
			// 获取excel中的某一个数据表
			Sheet sheet = wb.getSheetAt(0);
			// 获取数据表中的某一行
			Row row = null;
			Row titleRow = sheet.getRow(0);
			//System.out.println("sheet.getLastRowNum():"+sheet.getLastRowNum());
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				// 获取一行多少列
				UserDto user = new UserDto();
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					String title = getCellValue(titleRow.getCell(j));
					String value = getCellValue(row.getCell(j));

					if (title.equals("姓名") ||title.equals("名字")) {
						user.setName(value);
					} else if (title.equals("身份证号码") ||title.equals("身份证")) {
						user.setIdcard(value);
						user.setUsername(value);

					} else if (title.equals("性别")) {
						if(value.contains("男")){
							user.setSex("1");
						}else{
							user.setSex("0");
						}

					} else if (title.equals("部门") || title.equals("系部")) {
						user.setDepartment(value);

					} else if (title.equals("电话号码") || title.equals("联系电话")) {
						user.setTelephone(value);

					} else if (title.equals("email") || title.equals("邮件")) {
						user.setEmail(value);

					} else if (title.equals("QQ") || title.equals("qq")) {
						user.setQq(value);

					} else if (title.equals("备注")) {
						user.setRemark(value);
					}
				}
				user.setPassword(pwd);
				user.setBalance(100);
				Date dt = new Date();
				user.setCreateDate(dt);
				if(!this.validateUser(user.getUsername())){
					users.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			file.delete();
		}

		// System.out.println(url);
		// FileUtils.deleteOneFile(url);

		return userDao.addUsers(users);
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
			// o = String.valueOf(c.getNumericCellValue());
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
	
	public boolean validateUser(String username) {
		String hql = "from UserDto where username='" + username + "'";
		UserDto s;
		try {
			s = userDao.getUser(hql);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (s == null) {
			return false;
		}else{
			return true;
		}
	}
	
}
