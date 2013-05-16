package com.hnfnu.zyw.dao.base;

import java.util.List;
public interface IBaseDao<T> {
	
		public void add(T t);
		public void delete(int id);
		public void update(T t);
		public T load(int id);
		public List<T> list(String hql,Object[] args);
		public List<T> list(String hql);
		public List<T> list(String hql,Object arg);
}


