package cn.dms.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.dms.pojo.TAdmin;
import cn.dms.pojo.TDormmanager;
import cn.dms.pojo.TStudent;
import cn.dms.pojo.User;
import cn.dms.services.IAdminService;
import cn.dms.services.IDormmanagerService;
import cn.dms.services.IStudentService;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Resource
	private IAdminService adminService;
	@Resource
	private IDormmanagerService dormmanagerService;
	@Resource
	private IStudentService studentService;
	
	//返回登录页面
	@RequestMapping(value="/login", method=RequestMethod.GET)//该类下的具体某个方法的访问路径
	public ModelAndView login(HttpServletRequest request){
		System.out.println("0000000");
		ModelAndView mav = new ModelAndView("/login");
		return mav;
	}
	//登录验证
	@RequestMapping(value="/loginResult", method=RequestMethod.POST)
	public ModelAndView loginResult(String userName, String password, String userType,String remember,
	           HttpServletRequest request,HttpServletResponse response){
		System.out.println("-------------------------------");
		ModelAndView mav = new ModelAndView("login");
		HttpSession session = request.getSession();
		//将登陆信息存储到session
		session.setAttribute("user", new User(userName, password, userType));
		//判断是否需要保持数据到cookie中
		if(remember != null){
			try {
				Cookie cookie = new Cookie("userInfo", URLEncoder.encode(userType+","+userName+","+password, "utf-8"));
				response.addCookie(cookie);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(userType.equals("admin")){
			 //管理员登录
			TAdmin admin = adminService.loginTAdmin(userName, password);
			if(admin != null){
				mav.setViewName("mainAdmin");
				session.setAttribute("role", admin);
			}
			
		 }else if(userType.equals("dormManager")){
			 //宿管登录
			 TDormmanager dormmanager = dormmanagerService.loginDormmanager(userName, password);
			 if(dormmanager != null){
				 mav.setViewName("mainManager");
				 session.setAttribute("role", dormmanager);
			 }
		 }else if(userType.equals("student")){
			 //学生登录
			 TStudent student = studentService.loginStudent(userName, password);
			 if(student != null){
				 mav.setViewName("mainStudent");
				 session.setAttribute("role", student);
			 }
		 }
		return mav;
	}
}
