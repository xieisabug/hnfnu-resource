package com.hnfnu.zyw.dao.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T>{
	/**
	 * 此处不能使用setSessionFactory注入，因为setSessionFactory在HibernateDaoSupport
	 * 中已经定义了而且还是final的，所以不能被覆盖
	 * @param sessionFactory
	 */
	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * 创建一个Class的对象来获取泛型的class
	 */
	private Class<T> clz;
	
	@SuppressWarnings("unchecked")
	public Class<T> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz = ((Class<T>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}

	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void delete(int id) {
		this.getHibernateTemplate().delete(this.load(id));
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public T load(int id) {
//		return this.getHibernateTemplate().load(T.c, id);
		return this.getHibernateTemplate().load(getClz(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql, Object[] args) {
		Query u = this.getSession().createQuery(hql);
		for(int i=0;i<args.length;i++) {
			u.setParameter(0, args[0]);
		}
		List<T> list = u.list();
		return list;
	}

	public List<T> list(String hql) {
		return this.list(hql,null);
	}

	public List<T> list(String hql, Object arg) {
		return this.list(hql,new Object[]{arg});
	}
}
