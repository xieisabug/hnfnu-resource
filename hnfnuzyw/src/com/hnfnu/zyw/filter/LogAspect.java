package com.hnfnu.zyw.filter;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.UserDto;
import com.opensymphony.xwork2.ActionContext;


@Component("logAspect")
@Aspect
public class LogAspect {
	
	private static final Log log = LogFactory.getLog(LogAspect.class);	
	
	@After("execution(* com.hnfnu.zyw.dao..*.add(..)) " +
			"&& execution(!* com.hnfnu.zyw.dao.website..*.add(..))")
	public void logAdd(JoinPoint jp){
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserDto user = (UserDto) session.get("user");
		log.info("Id为 "+user.getId()+" 的用户 " + user.getName() + 
				"执行增加（Add）方法，操作了了记录" + jp.getArgs()[0]);
	}
	
	@Around("execution(* com.hnfnu.zyw.dao..*.update(..))")
	public void logUpdate(ProceedingJoinPoint pjp) throws Throwable{
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserDto user = (UserDto) session.get("user");
		if(user!=null) {
			log.info("Id为 "+user.getId()+" 的用户 " + user.getName() + 
					"执行更新方法（Update）方法，更新前记录为 " + pjp.getArgs()[0]);
			pjp.proceed();
			log.info("Id为 "+user.getId()+" 的用户 " + user.getName() + 
					"执行更新方法（Update）方法，更新后记录为 " + pjp.getArgs()[0]);
		}
	}
	
	@Before("execution(* com.hnfnu.zyw.dao..*.delete(..))")
	public void logDelete(JoinPoint jp) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserDto user = (UserDto) session.get("user");
		BaseDao bDao = (BaseDao)jp.getTarget();
		log.info("Id为 "+user.getId()+" 的用户 " + user.getName() + 
				"执行删除方法（Delete）方法，删除记录为 " + 
				bDao.get((Integer)(jp.getArgs()[0])));
	}
}