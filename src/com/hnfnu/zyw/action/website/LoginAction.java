package com.hnfnu.zyw.action.website;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnfnu.zyw.action.base.AopNoSuchMethodErrorSolveBaseAction;
import com.hnfnu.zyw.dto.system.StudentDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.system.ValidateMessege;
import com.hnfnu.zyw.service.website.ILoginService;
import com.opensymphony.xwork2.ActionContext;

@Controller("loginAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/website")
public class LoginAction extends AopNoSuchMethodErrorSolveBaseAction{
	
	private final int USER = 1;
	private final int STUDENT = 0;
	private int loginType;
	private String username;
	private String password;
    private String captcha;
	private boolean success;
	private String message;
	private List<Map<String, Object>> data;
	private Map<String, Object> info;

    /***************************************此处用于验证码生成***********************************************/
    /**
     * 验证码图片的宽度。
     */
    private int width = 100;

    /**
     *  验证码图片的高度。
     */
    private int height = 30;


    /**
     * 验证码字符个数
     */
    private int codeCount = 4;

    /**
     * xx
     */
    private int xx = width / (codeCount + 1);

    /**
     * 字体高度
     */
    private int fontHeight = height - 2;

    /**
     * codeY
     */
    private int codeY = height - 4;

    /**
     * codeSequence
     */
    char[] codeSequence = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    /**************************************************************************************/

	@Autowired
	@Qualifier("loginService")
	private ILoginService loginService;

	// 验证用户是否存在
	@Action(value = "loginUser")
	public String loginUser() {
		UserDto user = new UserDto();
		user.setUsername(username);
		user.setPassword(password);
		ValidateMessege vm = loginService.validateUser(user);
		if (vm.isResult()) {
			message = vm.getMessege();
			user = (UserDto) vm.getO();
			ServletActionContext.getContext().getSession().put("user", user);
            info = new HashMap<String, Object>();
            info.put("username",user.getUsername());
            info.put("name",user.getName());
            info.put("id",user.getId());
            info.put("icon",user.getIcon());
            info.put("lastedLoginDate",user.getLatestLoginDate());
            info.put("balance",user.getBalance());
			success = true;
		} else {
			message = vm.getMessege();
			success = false;
		}
		return SUCCESS;
	}

	@Action(value = "loginStudent")
	public String loginStudent() {
		StudentDto student = new StudentDto();
		student.setUsername(username);
		student.setPassword(password);
		ValidateMessege vm = loginService.validateStudent(student);
		if (vm.isResult()) {
			message = vm.getMessege();
			student = (StudentDto) vm.getO();
			ServletActionContext.getContext().getSession()
					.put("student", student);
            info = new HashMap<String, Object>();
            info.put("username",student.getUsername());
            info.put("name",student.getName());
            info.put("id",student.getId());
            info.put("icon",student.getIcon());
            info.put("department",student.getDepartment());
            info.put("entranceTime",student.getEntranceTime());
            info.put("balance",student.getBalance());
			success = true;
		} else {
			message = vm.getMessege();
			success = false;
		}
		return SUCCESS;
	}

	// 根据登陆的身份登陆
	@Action(value = "login")
	public String login() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String validateCode = (String)session.getAttribute("validateCode");
        if(validateCode != null) {
            if(!captcha.toLowerCase().equals(validateCode)) {
                success = false;
                message = "对不起，验证码不正确";
                return SUCCESS;
            }
        }
        if (loginType == STUDENT) {
			return loginStudent();
		}
		if (loginType == USER) {
			return loginUser();
		}
		return SUCCESS;
	}

	// 判断前台是否登陆，不管是学生还是老师
	@Action(value = "validateLogin")
	public String validateLogin() {
		// 获取当前用户
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		UserDto user = (UserDto) session.get("user");
		StudentDto student = (StudentDto) session.get("student");
		success = false;
		if (user != null) {
			success = true;
		}
		if (student != null) {
			success = true;
		}

		if (success) {
			message = "用户已经登陆";
		} else {
			message = "下载资源前请您先登陆";
		}
		return SUCCESS;
	}

	@Action(value = "exit")
	public String exit() {
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		session.clear();
		if (session.containsKey("user") || session.containsKey("student")) {
			success = false;
			message = "退出系统失败，session清除不成功";
		} else {
			success = true;
			message = "退出系统成功";
		}
		return SUCCESS;
	}

	// 获取主页的图表
	@Action(value = "welcomeChart")
	public String welcomeChart() {
		int id = ((UserDto) ServletActionContext.getContext().getSession()
				.get("user")).getId();
		data = loginService.welcomeChart(id);
		if (data != null) {
			success = true;
			message = "获取图表成功";
		} else {
			success = false;
			message = "获取图表失败";
		}
		return SUCCESS;
	}
	
	//获取用户登录信息
	@Action(value = "welcomeInfo")
	public String welcomeInfo() {
		info = loginService.welcomeInfo();
		//System.out.println(info.get("habit"));
		if (info != null) {
			success = true;
			message = "获取用户信息成功";
		} else {
			success = false;
			message = "用户信息获取失败，请与管理员联系";
		}
		return SUCCESS;
	}

    @Action(value = "captchaImg", results = {@Result(type = "stream", name="success")})
    public String captchaImg(){
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D gd = buffImg.createGraphics();

        // 创建一个随机数生成器类
        Random random = new Random();

        // 将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);

        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
        // 设置字体。
        gd.setFont(font);

        // 画边框。
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);

        // 随机产生100条干扰线，使图象中的认证码不易被其它程序探测到。
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }

        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuilder randomCode = new StringBuilder();
        int red = 0, green = 0, blue = 0;

        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。
            String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue));
            gd.drawString(strRand, (i + 1) * xx, codeY);

            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
        // 将四位数字的验证码保存到Session中。
        HttpSession session = req.getSession();
        session.setAttribute("validateCode", randomCode.toString());

        // 禁止图像缓存。
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setDateHeader("Expires", 0);

        res.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = null;
        try {
            sos = res.getOutputStream();
            ImageIO.write(buffImg, "jpeg", sos);
            //sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

	/* get set */
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

	public Map<String, Object> getInfo() {
		return info;
	}

}
