package com.hnfnu.zyw.website.service;

import com.hnfnu.zyw.dto.website.NewsDto;

import java.util.Map;

public interface INewsService {

	public Map<String, Object> getIndexNews();

    public NewsDto get(int id);
	
}
