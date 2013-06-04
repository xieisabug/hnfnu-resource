package com.hnfnu.zyw.service.system;


import java.util.List;

import com.hnfnu.zyw.dto.system.MenuDto;

public interface IMenuService {
	public boolean add(MenuDto menu);
	public boolean delete(int id);
	public boolean update(MenuDto menu);
	public MenuDto  load(int id);
	/**
	 * ��ѯ���ݿ����м�¼
	 * @return
	 */
	public List<MenuDto> list();
	//����parentId�õ��ò˵��������Ӳ˵������parentId��-1����˵�����ҵ������е�һ���˵�
		public List<MenuDto> getMenusByParentId(int parentId);
}
