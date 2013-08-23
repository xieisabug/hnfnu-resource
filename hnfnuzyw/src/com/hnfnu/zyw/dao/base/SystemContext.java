package com.hnfnu.zyw.dao.base;

/**
 * 用来传递列表对象的ThreadLocal数据
 * @author Administrator
 *
 */
public class SystemContext {
	/**
	 * 分页大小
	 */
	private int  pageSize;
	/**
	 * 分页的起始页
	 */
	private Integer pageOffset;
	/**
	 * 列表的排序字段
	 */
	private String sort;
	/**
	 * 列表的排序方式
	 */
	private String order;
	
	public SystemContext() {
		super();
	}
	public SystemContext(int pageSize, Integer pageOffset, String sort,
			String order) {
		super();
		this.pageSize = pageSize;
		this.pageOffset = pageOffset;
		this.sort = sort;
		this.order = order;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
	
}
