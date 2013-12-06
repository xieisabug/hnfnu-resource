package com.hnfnu.zyw.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hnfnu.zyw.dao.system.IMenuDao;
import com.hnfnu.zyw.dao.website.IUserOperateDao;
import com.hnfnu.zyw.dto.system.MenuDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.website.UserOperateDto;
import com.opensymphony.xwork2.ActionContext;


@Component("userOperateAspect")
@Aspect
public class UserOperateAspect {
	
	private static Map<String, Integer> menuMap = null;
	@Autowired
	@Qualifier("menuDao")
	public IMenuDao menuDao;
	@Autowired
	@Qualifier("userOperateDao")
	public IUserOperateDao userOperateDao;
	
	@After("execution(* com.hnfnu.zyw.service..*.*(..))")
	public void userOperate(JoinPoint jp){
		if(menuMap == null) {
			List<MenuDto> menuDtos = null;
			try {
				menuDtos = menuDao.list("FROM MenuDto WHERE parentId <> -1");
			} catch (Exception e) {
				e.printStackTrace();
			}
			menuMap = new HashMap<String, Integer>();
			for(MenuDto menu : menuDtos) {
				String[] menuNames = menu.getUrl().split("/");
				menuMap.put(menuNames[2], menu.getId());
			}
			menuMap.remove("Parameter");
			menuMap.remove("Function");
//			System.out.println("init menu map");
//			System.out.println(menuMap.size());
//			System.out.println("**************");
		}
		String[] fullClassName = jp.getTarget().getClass().getName().split("\\.");
		String className = fullClassName[fullClassName.length-1];
		if(className.contains("ServiceImpl")) {
			className = className.substring(0, className.indexOf("ServiceImpl"));
		}
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserDto user = (UserDto) session.get("user");
		
		if(className.contains("Join") || className.contains("Vo")) {
			Pattern p = Pattern.compile("[A-Z][a-z]*");
			Matcher m = p.matcher(className);
			List<String> nameList = new ArrayList<String>();
			while(m.find()){
				nameList.add(m.group());
			}
			for(int i = 0; i<nameList.size()-1; i++) {
				if(menuMap.get(nameList.get(i)) != null ) {
//					System.out.println(" id :" + menuMap.get(nameList.get(i)) 
//							+ "  " + nameList.get(i));
					try {
						userOperateDao.add(new UserOperateDto(user.getId(), menuMap.get(nameList.get(i))));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
//			String methodName = jp.getSignature().getName();
//			System.out.println(methodName);
//			System.out.println("**************");
		} else {
			if(menuMap.get(className)!=null) {
//				String methodName = jp.getSignature().getName();
//				System.out.println("id:" + menuMap.get(className) + "  " + className);
//				System.out.println(methodName);
//				System.out.println("**************");
				try {
					userOperateDao.add(new UserOperateDto(user.getId(), menuMap.get(className)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}