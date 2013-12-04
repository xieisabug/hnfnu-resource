package com.hnfnu.zyw.service.system;

import java.util.Map;

import com.hnfnu.zyw.dto.system.RoleDto;

public interface IRoleService {

	boolean add(RoleDto role);

	boolean update(RoleDto role);

	RoleDto load(RoleDto role);

	boolean delete(RoleDto role);

	Map<String, Object> list();

}
