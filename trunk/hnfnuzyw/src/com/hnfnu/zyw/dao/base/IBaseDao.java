package com.hnfnu.zyw.dao.base;

import java.util.List;
public interface IBaseDao<T> {
	
		public void add(T t) throws Exception;
		public void delete(int id) throws Exception;
		public void update(T t) throws Exception;
		public T load(int id) throws Exception;
		public T get(int id) throws Exception;
		public List<T> list(String hql,Object[] args) throws Exception;
		public List<T> list(String hql) throws Exception;
		public List<T> list(String hql,Object arg) throws Exception;
		
		public Pager<T> find(String hql, Object arg,int pageOffset,int pageSize) throws Exception;

		public Pager<T> find(String hql,int pageOffset,int pageSize) throws Exception;

		public Pager<T> find(String hql, Object[] args,int pageOffset,int pageSize) throws Exception;
}


