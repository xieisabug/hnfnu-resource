package com.hnfnu.zyw.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IFunctionDao;
import com.hnfnu.zyw.dto.system.FunctionDto;

@Service("functionService")
public class FunctionServiceIpml implements IFunctionService {

	@Autowired
	@Qualifier("functionDao")
	public IFunctionDao functionDao;

	public boolean add(FunctionDto function) {
		try {
			functionDao.add(function);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			functionDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(FunctionDto function) {
		try {
			functionDao.update(function);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public FunctionDto load(int id) {
		try {
			return functionDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

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
}
