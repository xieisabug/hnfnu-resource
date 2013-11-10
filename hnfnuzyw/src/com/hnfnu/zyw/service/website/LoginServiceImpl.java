package com.hnfnu.zyw.service.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IStudentDao;
import com.hnfnu.zyw.dao.system.IUserDao;
import com.hnfnu.zyw.dao.website.ILoginDao;
import com.hnfnu.zyw.dto.system.StudentDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.system.ValidateMessege;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {
	@Autowired
	@Qualifier("loginDao")
	public ILoginDao loginDao;
	@Autowired
	@Qualifier("userDao")
	public IUserDao userDao;
	@Autowired
	@Qualifier("studentDao")
	public IStudentDao studentDao;

	public ValidateMessege validateUser(UserDto user) {
		String hql = "from UserDto where username='" + user.getUsername() + "'";
		UserDto u = null;
		ValidateMessege messege = new ValidateMessege();
		try {
			u = userDao.getUser(hql);
		} catch (Exception e) {
			e.printStackTrace();
			messege.setResult(false);
			messege.setMessege("��½ʧ��");
			return messege;
		}
		if (u == null) {
			messege.setResult(false);
			messege.setMessege("�û���������");
			return messege;
		} else {
			if (u.getPassword().equals(user.getPassword())) {
				messege.setO(u);
				messege.setResult(true);
				messege.setMessege("��½�ɹ�");
				return messege;
			} else {
				messege.setResult(false);
				messege.setMessege("���벻��ȷ");
				return messege;
			}
		}
	}

	public ValidateMessege validateStudent(StudentDto student) {
		String hql = "from StudentDto where username='" + student.getUsername() + "'";
		StudentDto u = null;
		ValidateMessege messege = new ValidateMessege();
		try {
			u = studentDao.getStudent(hql);
		} catch (Exception e) {
			e.printStackTrace();
			messege.setResult(false);
			messege.setMessege("��½ʧ��");
			return messege;
		}
		if (u == null) {
			messege.setResult(false);
			messege.setMessege("�û���������");
			return messege;
		} else {
			if (u.getPassword().equals(student.getPassword())) {
				messege.setO(u);
				messege.setResult(true);
				messege.setMessege("��½�ɹ�");
				return messege;
			} else {
				messege.setResult(false);
				messege.setMessege("���벻��ȷ");
				return messege;
			}
		}
	}
}
