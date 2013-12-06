package com.hnfnu.zyw.service.website;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.system.StudentDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.system.ValidateMessege;

public interface ILoginService {
	ValidateMessege validateUser(UserDto user);
	ValidateMessege validateStudent(StudentDto student);
	List<Map<String,Object>> welcomeChart(int id);
	Map<String, Object> welcomeInfo();
}
