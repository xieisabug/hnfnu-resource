package com.hnfnu.zyw.dao.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
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

	public void add(T t) throws Exception{
		this.getHibernateTemplate().save(t);
	}

	public void delete(int id) throws Exception{
		this.getHibernateTemplate().delete(this.load(id));
	}

	public void update(T t) throws Exception{
		this.getHibernateTemplate().update(t);
	}

	public T load(int id) throws Exception{
		return this.getHibernateTemplate().load(getClz(), id);
	}
	
	public T get(int id) throws Exception {
		return this.getHibernateTemplate().get(getClz(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql, Object[] args) throws Exception{
		Session session = this.getSession();
		Query u = session.createQuery(hql);
		if(args != null){
		for(int i=0;i<args.length;i++) {
			u.setParameter(i, args[i]);
		}
		}
		List<T> list = u.list();
		session.close();
		return list;
	}

	public List<T> list(String hql) throws Exception{
		return this.list(hql,null);
	}

	public List<T> list(String hql, Object arg) throws Exception{
		return this.list(hql,new Object[]{arg});
	}

	public Pager<T> find(String hql, Object arg,int pageOffset,int pageSize) throws Exception {
		return this.find(hql, new Object[]{arg},pageOffset,pageSize);
	}

	public Pager<T> find(String hql,int pageOffset,int pageSize) throws Exception {
		return this.find(hql,null,pageOffset,pageSize);
	}

	public Pager<T> find(String hql, Object[] args,int pageOffset,int pageSize) throws Exception {
		String cq = getCountHql(hql,true);
		Session session1 = getSession();
		Session session2 = getSession();
		
		Query cquery = session1.createQuery(cq);
		Query query = session2.createQuery(hql);
		
		//设置参数
		setParameter(query, args);
		setParameter(cquery, args);
		Pager<T> pages = new Pager<T>();
		pages.setOffset(pageOffset);
		pages.setSize(pageSize);
		query.setFirstResult(pageOffset).setMaxResults(pageSize);
		List<T> datas = query.list();
		pages.setDatas(datas);
		long total = (Long)cquery.uniqueResult();
		pages.setTotal(total);
		session1.close();
		session2.close();
		return pages;
	}

	
	private String getCountHql(String hql,boolean isHql) {
		String e = hql.substring(hql.indexOf("from"));
		String c = "select count(*) "+e;
		if(isHql)
			c.replaceAll("fetch", "");
		return c;
	}

	
	private void setParameter(Query query,Object[] args) {
		if(args!=null&&args.length>0) {
			int index = 0;
			for(Object arg:args) {
				query.setParameter(index++, arg);
			}
		}
	}

	
}
