package com.hnfnu.zyw.website.service;

import java.util.Map;

public interface ISearchService {

    public Map<String,Object> listSource(String keyWord, int page, int pageSize);

    public Map<String,Object> listTopic(String keyWord, int page, int pageSize);

}
