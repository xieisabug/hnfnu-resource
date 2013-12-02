package com.hnfnu.zyw.service.website;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ISourceDao;
import com.hnfnu.zyw.dao.system.IMenuDao;
import com.hnfnu.zyw.dao.system.IStudentDao;
import com.hnfnu.zyw.dao.system.IUserDao;
import com.hnfnu.zyw.dao.system.IUserRoleMenuVoDao;
import com.hnfnu.zyw.dao.website.IChartDao;
import com.hnfnu.zyw.dao.website.ILoginDao;
import com.hnfnu.zyw.dto.resources.SourceDto;
import com.hnfnu.zyw.dto.system.MenuDto;
import com.hnfnu.zyw.dto.system.StudentDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.system.ValidateMessege;
import com.hnfnu.zyw.dto.website.chart.CategoryCount;
import com.hnfnu.zyw.dto.website.chart.GradeCount;
import com.hnfnu.zyw.dto.website.chart.SubjectCount;
import com.hnfnu.zyw.dto.website.chart.TopUserSource;
import com.hnfnu.zyw.dto.website.chart.UserCount;
import com.hnfnu.zyw.utils.WebUtils;
import com.hnfnu.zyw.vo.UserRoleMenuVo;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {
	@Autowired
	@Qualifier("loginDao")
	public ILoginDao loginDao;
	@Autowired
	@Qualifier("userDao")
	public IUserDao userDao;
	@Autowired
	@Qualifier("menuDao")
	public IMenuDao menuDao;
	@Autowired
	@Qualifier("studentDao")
	public IStudentDao studentDao;
	@Autowired
	@Qualifier("userRoleMenuVoDao")
	public IUserRoleMenuVoDao userRoleMenuVoDao;
	@Autowired
	@Qualifier("sourceDao")
	public ISourceDao sourceDao;
	@Autowired
	@Qualifier("userCountDao")
	public IChartDao userCountDao;
	@Autowired
	@Qualifier("topUserSourceDao")
	public IChartDao topUserSourceDao;
	@Autowired
	@Qualifier("categoryCountDao")
	public IChartDao categoryCountDao;
	@Autowired
	@Qualifier("gradeCountDao")
	public IChartDao gradeCountDao;
	@Autowired
	@Qualifier("subjectCountDao")
	public IChartDao subjectCountDao;
	
	public ValidateMessege validateUser(UserDto user) {
		String hql = "from UserDto where username='" + user.getUsername() + "'";
		UserDto u = null;
		ValidateMessege messege = new ValidateMessege();
		try {
			u = userDao.getUser(hql);
		} catch (Exception e) {
			e.printStackTrace();
			messege.setResult(false);
			messege.setMessege("登陆失败");
			return messege;
		}
		if (u == null) {
			messege.setResult(false);
			messege.setMessege("用户名不存在");
			return messege;
		} else {
			if (u.getPassword().equals(user.getPassword())) {
				u.setLatestLoginDate(new Date());
				try {
					userDao.update(u);
				} catch (Exception e) {
					e.printStackTrace();
					messege.setResult(false);
					messege.setMessege("登陆失败");
					return messege;
				}
				messege.setO(u);
				messege.setResult(true);
				messege.setMessege("登陆成功");
				return messege;
			} else {
				messege.setResult(false);
				messege.setMessege("密码不正确");
				return messege;
			}
		}
	}

	public ValidateMessege validateStudent(StudentDto student) {
		String hql = "from StudentDto where username='" + student.getUsername()
				+ "'";
		StudentDto u = null;
		ValidateMessege messege = new ValidateMessege();
		try {
			u = studentDao.getStudent(hql);
		} catch (Exception e) {
			e.printStackTrace();
			messege.setResult(false);
			messege.setMessege("登陆失败");
			return messege;
		}
		if (u == null) {
			messege.setResult(false);
			messege.setMessege("用户名不存在");
			return messege;
		} else {
			if (u.getPassword().equals(student.getPassword())) {
				messege.setO(u);
				messege.setResult(true);
				messege.setMessege("登陆成功");
				return messege;
			} else {
				messege.setResult(false);
				messege.setMessege("密码不正确");
				return messege;
			}
		}
	}

	public List<Map<String, Object>> welcomeChart(int id) {
		String hqlUserRoleMenuVo = "from UserRoleMenuVo where userId=" + id;
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		try {
			List<UserRoleMenuVo> userRoleMenuVos = userRoleMenuVoDao
					.list(hqlUserRoleMenuVo);
			List<Integer> menuId = new ArrayList<Integer>();
			for (UserRoleMenuVo userRoleMenuVo : userRoleMenuVos) {
				menuId.add(userRoleMenuVo.getMenuId());
			}
			List<MenuDto> menus = menuDao
					.list("from MenuDto where parentId <> -1");
			Map<String, Integer> menuNameId = mapMenuNameId(menus);

			// TODO 先测试好图表的生成，再来完成数据获取与数据打包的算法
			for (UserRoleMenuVo userRoleMenuVo : userRoleMenuVos) {
				if (userRoleMenuVo.getMenuId() == menuNameId.get("用户管理")) {
					// 获取用户数量，生成折线图；获取上传资源量，生成条形图
					retList.add(userCountChart());
					retList.add(topUserSourceChart());
				} else if (userRoleMenuVo.getMenuId() == menuNameId.get("资源管理")) {
					// 获取个人资源下载量最高的8个
					retList.add(topDownloadSourceChart(id));
				} else if (userRoleMenuVo.getMenuId() == menuNameId.get("类别管理")) {
					// 类别资源分布数量饼图
					retList.add(categoryCountChart());
				} else if (userRoleMenuVo.getMenuId() == menuNameId.get("年级管理")) {
					// 年级资源分布数量饼图
					retList.add(gradeCountChart());
				} else if (userRoleMenuVo.getMenuId() == menuNameId.get("学科管理")) {
					// 学科资源分布数量饼图
					retList.add(subjectCountChart());
				} else if (userRoleMenuVo.getMenuId() == menuNameId.get("专题管理")) {
					// TODO 专题访问前8的2D柱形图
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return retList;
	}

	// welcomeChart方法内部使用，将所有的菜单映射成为 name:id 形式的map
	private Map<String, Integer> mapMenuNameId(List<MenuDto> menus) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (MenuDto menuDto : menus) {
			m.put(menuDto.getName(), menuDto.getId());
		}
		return m;
	}

	/** 图表算法 **/
	// welcomeChart方法生成图表算法之一，用于生成用户数量折线图
	private Map<String, Object> userCountChart() {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "LineBasic2D");// 设置类型为折线
		ret.put("title", "近期用户数量增长图");// 设置图表标题

		List<UserCount> userCounts = null;
		try {
			// 获取最近5个月的用户注册数量（有可能不足5个月）
			userCounts = userCountDao.list("from UserCount");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		List<Integer> labels = new ArrayList<Integer>();
		List<Integer> values = new ArrayList<Integer>();
		int max = 0, min = 9999;// 用于设置坐标轴的最大最小值
		for (UserCount uc : userCounts) {
			labels.add(uc.getMonth());
			values.add(uc.getNum());
			if (max < uc.getNum()) {
				max = uc.getNum();
			}
			if (min > uc.getNum()) {
				min = uc.getNum();
			}
		}
		int space = (max - min) / 10 == 0 ? 1 : (max - min) / 10;// 计算y轴显示数字的间隔
		ret.put("start_scale", min - 2 * space > 0 ? min - 2 * space : 0);// 计算最低的数字
		ret.put("end_scale", max + 2 * space);// 计算最高的数字
		ret.put("scale_space", space);

		ret.put("labels", labels);// 设置折线图x轴

		// 设置数据显示的格式和数据源
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("name", "新用户注册量");
		m.put("value", values);
		m.put("color", "#1f7a92");
		m.put("line_width", 3);
		data.add(m);
		ret.put("data", data);

		return ret;
	}

	/** 图表算法 **/
	// welcomeChart方法生成图表算法之一，用于生成用户上传资源数
	private Map<String, Object> topUserSourceChart() {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "Column2D");// 设置类型为折线
		ret.put("title", "Top8用户上传资源");// 设置图表标题

		List<TopUserSource> topUserSources = null;
		try {
			// 获取最近5个月的用户注册数量（有可能不足5个月）
			topUserSources = topUserSourceDao.list("from TopUserSource");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		int max = 0, min = 9999;
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (TopUserSource tus : topUserSources) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", tus.getName());
			map.put("value", tus.getNum());
			map.put("color", WebUtils.getRandomHexColor());
			data.add(map);
			if (max < tus.getNum()) {
				max = tus.getNum();
			}
			if (min > tus.getNum()) {
				min = tus.getNum();
			}
		}
		int space = (max - min) / 10 == 0 ? 1 : (max - min) / 10;// 计算y轴显示数字的间隔
		ret.put("start_scale", min - 2 * space > 0 ? min - 2 * space : 0);// 计算最低的数字
		ret.put("end_scale", max + 2 * space);// 计算最高的数字
		ret.put("scale_space", space);

		ret.put("textUnit", "");
		ret.put("data", data);
		return ret;
	}

	/** 图表算法 **/
	// welcomeChart方法生成图表算法之一，用于生成下载最高的8个个人资源
	private Map<String, Object> topDownloadSourceChart(int id) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "Column2D");
		ret.put("title", "下载量前8资源");
		List<SourceDto> sources = null;
		try {
			sources = sourceDao.list("from SourceDto where createUserId = "
					+ id + " order by useTimes desc ");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		int max = 0, min = 9999;
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		List<String> tip = new ArrayList<String>();
		// System.out.println(sources.size());
		for (SourceDto s : sources) {
			if (data.size() < 8) {
				Map<String, Object> m = new HashMap<String, Object>();
				tip.add(s.getName());
				String nameString = s.getName().length() > 3 ? s.getName()
						.substring(0, 2) + "..." : s.getName();
				m.put("name", nameString);
				m.put("value", s.getUseTimes());
				m.put("color", WebUtils.getRandomHexColor());
				data.add(m);
				if (max < s.getUseTimes()) {
					max = s.getUseTimes();
				}
				if (min > s.getUseTimes()) {
					min = s.getUseTimes();
				}
			}
		}
		if(sources.size()==0) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("name", "未上传任何资源");
			m.put("value", 0);
			m.put("color", "#ffffff");
			data.add(m);
			max = 0;
			min = 0;
		}
		int space = (max - min) / 10 == 0 ? 1 : (max - min) / 10;// 计算y轴显示数字的间隔
		ret.put("start_scale", min - 2 * space > 0 ? min - 2 * space : 0);// 计算最低的数字
		ret.put("end_scale", max + 2 * space);// 计算最高的数字
		ret.put("scale_space", space);
		ret.put("textUnit", " 次");
		ret.put("data", data);
		ret.put("tip", tip);
		return ret;
	}

	/** 图表算法 **/
	// welcomeChart方法生成图表算法之一，用于生成类别资源总数统计饼图
	private Map<String, Object> categoryCountChart(){
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "Pie2D");
		ret.put("title", "类别资源统计");
		
		List<CategoryCount> categoryCounts = null;
		try {
			categoryCounts = categoryCountDao.list("from CategoryCount");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		long sum = 0;//统计总数据个数，用于计算百分比
		for(CategoryCount cc : categoryCounts) {
			sum += cc.getNum();
		}
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		for(CategoryCount cc : categoryCounts) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("name", cc.getName());
			m.put("value", (double)cc.getNum()/sum);
			m.put("color", WebUtils.getRandomHexColor());
			data.add(m);
		}
		ret.put("data", data);
		return ret;
	}
	
	/** 图表算法 **/
	// welcomeChart方法生成图表算法之一，用于生成年级资源总数统计饼图
	private Map<String, Object> gradeCountChart(){
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "Pie2D");
		ret.put("title", "年级资源统计");
		
		List<GradeCount> gradeCounts = null;
		try {
			gradeCounts = gradeCountDao.list("from GradeCount");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		long sum = 0;//统计总数据个数，用于计算百分比
		for(GradeCount gc : gradeCounts) {
			sum += gc.getNum();
		}
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		for(GradeCount gc : gradeCounts) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("name", gc.getName());
			m.put("value", (double)gc.getNum()/sum);
			m.put("color", WebUtils.getRandomHexColor());
			data.add(m);
		}
		ret.put("data", data);
		return ret;
	}
	
	/** 图表算法 **/
	// welcomeChart方法生成图表算法之一，用于生成年级资源总数统计饼图
	private Map<String, Object> subjectCountChart(){
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "Pie2D");
		ret.put("title", "学科资源统计");
		
		List<SubjectCount> subjectCounts = null;
		try {
			subjectCounts = subjectCountDao.list("from SubjectCount");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		long sum = 0;//统计总数据个数，用于计算百分比
		for(SubjectCount sc : subjectCounts) {
			sum += sc.getNum();
		}
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		for(SubjectCount sc : subjectCounts) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("name", sc.getName());
			m.put("value", (double)sc.getNum()/sum);
			m.put("color", WebUtils.getRandomHexColor());
			data.add(m);
		}
		ret.put("data", data);
		return ret;
	}
}
