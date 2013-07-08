package com.hnfnu.zyw.service.website;

import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.system.ValidateMessege;

public interface ILoginService {
	ValidateMessege validateUser(UserDto user);
}
