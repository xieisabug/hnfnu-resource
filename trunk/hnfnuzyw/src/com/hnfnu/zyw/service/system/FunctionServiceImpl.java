package com.hnfnu.zyw.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IFunctionDao;
import com.hnfnu.zyw.dto.system.FunctionDto;

@Service("functionService")
public class FunctionServiceImpl implements IFunctionService {

	@Autowired
	@Qualifier("functionDao")
	public IFunctionDao functionDao;

	/**
	 * ����һ������
	 * @param һ�����ܶ���
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean add(FunctionDto function) {
		try {
			functionDao.add(function);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ɾ��һ������
	 * @param Ҫɾ���Ĺ��ܵ�id
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean delete(FunctionDto function) {
		try {
			functionDao.delete(function.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ����һ������
	 * @param �Ѿ����µĹ��ܵĶ���
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean update(FunctionDto function) {
		try {
			functionDao.update(function);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ��ȡһ������
	 * @param ��ȡ�Ĺ��ܵ�id
	 * @return ���ض�ȡ�Ĺ��ܶ���
	 */
	public FunctionDto load(FunctionDto function) {
		try {
			return functionDao.load(function.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ȡ���й���
	 * @return ��ȡ���Ĺ��ܼ���
	 */
	public List<FunctionDto> list() {
		String hql = "from FunctionDto";
		List<FunctionDto> functions = null;
		try {
			functions = functionDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return functions;
	}

	/**
	 * �г����еĹ���
	 * @return ���������й��ܵ�Map
	 */
	public Map<String, Object> listFun() {
		String hql = "from FunctionDto";
		Map<String, Object> functionList = new HashMap<String, Object>();
		List<FunctionDto> l = null;
		
		try {
			l = functionDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		functionList.put("Rows", l);
		functionList.put("Total", l.size());
		return functionList;
	}
}
