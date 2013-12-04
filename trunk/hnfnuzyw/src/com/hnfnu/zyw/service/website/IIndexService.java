package com.hnfnu.zyw.service.website;

import java.util.List;
import java.util.Map;

public interface IIndexService {
	List<Map<String, Object>> getRoleMenusByUserId(int userId);
}
