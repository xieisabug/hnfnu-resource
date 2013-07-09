package com.hnfnu.zyw.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IParameterDao;
import com.hnfnu.zyw.dto.system.ParameterDto;

@Service("parameterService")
public class ParameterServiceImpl implements IParameterService {
	
	@Autowired
	@Qualifier("parameterDao")
	public IParameterDao parameterDao;//暂时不写get set 试试可以不。

	/**
	 * 增加一个参数
	 * @param 一个参数对象
	 * @return 成功返回true，失败返回false
	 */
	public boolean add(ParameterDto parameter) {
		try {
			parameterDao.add(parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 修改一个参数
	 * @param 一个参数对象
	 * @return 成功返回true，失败返回false
	 */
	public boolean update(ParameterDto parameter) {
		try {
			parameterDao.update(parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 读取一个参数
	 * @param 一个参数对象
	 * @return 读取到的参数对象
	 */
	public ParameterDto load(ParameterDto parameter) {
		if(parameter == null || parameter.getId() == null){
			return null;
		}
		ParameterDto p = null;
		try {
			p = parameterDao.load(parameter.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return p;
	}

	/**
	 * 删除一个参数
	 * @param 一个参数对象
	 * @return 成功返回true，失败返回false
	 */
	public boolean delete(ParameterDto parameter) {
		if(parameter == null || parameter.getId() == null){
			return false;
		}
		try {
			parameterDao.delete(parameter.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 读取所有参数
	 * @return 保存了集合的Map
	 */
	public Map<String, Object> list() {
		Map<String, Object> m = new HashMap<String, Object>();
		List<ParameterDto> l = null;
		try {
			l = parameterDao.list("from ParameterDto");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		m.put("Rows", l);
		m.put("Total", l.size());
		return m;
	}

}
