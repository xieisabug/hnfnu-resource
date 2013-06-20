package com.hnfnu.zyw.service.website;

import java.util.List;

import com.hnfnu.zyw.vo.RoleMenuVo;

public interface ILoginService {

	public List<RoleMenuVo> getRoleMenusByUserId(int userId);

}
