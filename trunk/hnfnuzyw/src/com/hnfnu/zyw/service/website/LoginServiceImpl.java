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
			messege.setMessege("��½ʧ��");
			return messege;
		}
		if (u == null) {
			messege.setResult(false);
			messege.setMessege("�û���������");
			return messege;
		} else {
			if (u.getPassword().equals(user.getPassword())) {
				u.setLatestLoginDate(new Date());
				try {
					userDao.update(u);
				} catch (Exception e) {
					e.printStackTrace();
					messege.setResult(false);
					messege.setMessege("��½ʧ��");
					return messege;
				}
				messege.setO(u);
				messege.setResult(true);
				messege.setMessege("��½�ɹ�");
				return messege;
			} else {
				messege.setResult(false);
				messege.setMessege("���벻��ȷ");
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
			messege.setMessege("��½ʧ��");
			return messege;
		}
		if (u == null) {
			messege.setResult(false);
			messege.setMessege("�û���������");
			return messege;
		} else {
			if (u.getPassword().equals(student.getPassword())) {
				messege.setO(u);
				messege.setResult(true);
				messege.setMessege("��½�ɹ�");
				return messege;
			} else {
				messege.setResult(false);
				messege.setMessege("���벻��ȷ");
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

			// TODO �Ȳ��Ժ�ͼ������ɣ�����������ݻ�ȡ�����ݴ�����㷨
			for (UserRoleMenuVo userRoleMenuVo : userRoleMenuVos) {
				if (userRoleMenuVo.getMenuId() == menuNameId.get("�û�����")) {
					// ��ȡ�û���������������ͼ����ȡ�ϴ���Դ������������ͼ
					retList.add(userCountChart());
					retList.add(topUserSourceChart());
				} else if (userRoleMenuVo.getMenuId() == menuNameId.get("��Դ����")) {
					// ��ȡ������Դ��������ߵ�8��
					retList.add(topDownloadSourceChart(id));
				} else if (userRoleMenuVo.getMenuId() == menuNameId.get("������")) {
					// �����Դ�ֲ�������ͼ
					retList.add(categoryCountChart());
				} else if (userRoleMenuVo.getMenuId() == menuNameId.get("�꼶����")) {
					// �꼶��Դ�ֲ�������ͼ
					retList.add(gradeCountChart());
				} else if (userRoleMenuVo.getMenuId() == menuNameId.get("ѧ�ƹ���")) {
					// ѧ����Դ�ֲ�������ͼ
					retList.add(subjectCountChart());
				} else if (userRoleMenuVo.getMenuId() == menuNameId.get("ר�����")) {
					// TODO ר�����ǰ8��2D����ͼ
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return retList;
	}

	// welcomeChart�����ڲ�ʹ�ã������еĲ˵�ӳ���Ϊ name:id ��ʽ��map
	private Map<String, Integer> mapMenuNameId(List<MenuDto> menus) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (MenuDto menuDto : menus) {
			m.put(menuDto.getName(), menuDto.getId());
		}
		return m;
	}

	/** ͼ���㷨 **/
	// welcomeChart��������ͼ���㷨֮һ�����������û���������ͼ
	private Map<String, Object> userCountChart() {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "LineBasic2D");// ��������Ϊ����
		ret.put("title", "�����û���������ͼ");// ����ͼ�����

		List<UserCount> userCounts = null;
		try {
			// ��ȡ���5���µ��û�ע���������п��ܲ���5���£�
			userCounts = userCountDao.list("from UserCount");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		List<Integer> labels = new ArrayList<Integer>();
		List<Integer> values = new ArrayList<Integer>();
		int max = 0, min = 9999;// ��������������������Сֵ
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
		int space = (max - min) / 10 == 0 ? 1 : (max - min) / 10;// ����y����ʾ���ֵļ��
		ret.put("start_scale", min - 2 * space > 0 ? min - 2 * space : 0);// ������͵�����
		ret.put("end_scale", max + 2 * space);// ������ߵ�����
		ret.put("scale_space", space);

		ret.put("labels", labels);// ��������ͼx��

		// ����������ʾ�ĸ�ʽ������Դ
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("name", "���û�ע����");
		m.put("value", values);
		m.put("color", "#1f7a92");
		m.put("line_width", 3);
		data.add(m);
		ret.put("data", data);

		return ret;
	}

	/** ͼ���㷨 **/
	// welcomeChart��������ͼ���㷨֮һ�����������û��ϴ���Դ��
	private Map<String, Object> topUserSourceChart() {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "Column2D");// ��������Ϊ����
		ret.put("title", "Top8�û��ϴ���Դ");// ����ͼ�����

		List<TopUserSource> topUserSources = null;
		try {
			// ��ȡ���5���µ��û�ע���������п��ܲ���5���£�
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
		int space = (max - min) / 10 == 0 ? 1 : (max - min) / 10;// ����y����ʾ���ֵļ��
		ret.put("start_scale", min - 2 * space > 0 ? min - 2 * space : 0);// ������͵�����
		ret.put("end_scale", max + 2 * space);// ������ߵ�����
		ret.put("scale_space", space);

		ret.put("textUnit", "");
		ret.put("data", data);
		return ret;
	}

	/** ͼ���㷨 **/
	// welcomeChart��������ͼ���㷨֮һ����������������ߵ�8��������Դ
	private Map<String, Object> topDownloadSourceChart(int id) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "Column2D");
		ret.put("title", "������ǰ8��Դ");
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
			m.put("name", "δ�ϴ��κ���Դ");
			m.put("value", 0);
			m.put("color", "#ffffff");
			data.add(m);
			max = 0;
			min = 0;
		}
		int space = (max - min) / 10 == 0 ? 1 : (max - min) / 10;// ����y����ʾ���ֵļ��
		ret.put("start_scale", min - 2 * space > 0 ? min - 2 * space : 0);// ������͵�����
		ret.put("end_scale", max + 2 * space);// ������ߵ�����
		ret.put("scale_space", space);
		ret.put("textUnit", " ��");
		ret.put("data", data);
		ret.put("tip", tip);
		return ret;
	}

	/** ͼ���㷨 **/
	// welcomeChart��������ͼ���㷨֮һ���������������Դ����ͳ�Ʊ�ͼ
	private Map<String, Object> categoryCountChart(){
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "Pie2D");
		ret.put("title", "�����Դͳ��");
		
		List<CategoryCount> categoryCounts = null;
		try {
			categoryCounts = categoryCountDao.list("from CategoryCount");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		long sum = 0;//ͳ�������ݸ��������ڼ���ٷֱ�
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
	
	/** ͼ���㷨 **/
	// welcomeChart��������ͼ���㷨֮һ�����������꼶��Դ����ͳ�Ʊ�ͼ
	private Map<String, Object> gradeCountChart(){
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "Pie2D");
		ret.put("title", "�꼶��Դͳ��");
		
		List<GradeCount> gradeCounts = null;
		try {
			gradeCounts = gradeCountDao.list("from GradeCount");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		long sum = 0;//ͳ�������ݸ��������ڼ���ٷֱ�
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
	
	/** ͼ���㷨 **/
	// welcomeChart��������ͼ���㷨֮һ�����������꼶��Դ����ͳ�Ʊ�ͼ
	private Map<String, Object> subjectCountChart(){
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("type", "Pie2D");
		ret.put("title", "ѧ����Դͳ��");
		
		List<SubjectCount> subjectCounts = null;
		try {
			subjectCounts = subjectCountDao.list("from SubjectCount");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		long sum = 0;//ͳ�������ݸ��������ڼ���ٷֱ�
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
