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
	 * 增加一个功能
	 * @param 一个功能对象
	 * @return 成功返回true，失败返回false
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
	 * 删除一个功能
	 * @param 要删除的功能的id
	 * @return 成功返回true，失败返回false
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
	 * 更新一个功能
	 * @param 已经更新的功能的对象
	 * @return 成功返回true，失败返回false
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
	 * 读取一个功能
	 * @param 读取的功能的id
	 * @return 返回读取的功能对象
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
	 * 获取所有功能
	 * @return 获取到的功能集合
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
	 * 列出所有的功能
	 * @return 保存了所有功能的Map
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
