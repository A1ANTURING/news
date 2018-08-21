package com.ht.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.pojo.TUser;
import com.ht.service.UserService;

/**
 * 
 * <p>Title:UserController</p>
 * <p>Description:后台登录</p>
 * <p>Compary</p>
 * @author 胡腾
 */
@Controller
public class UserController {
	
	private UserService userService ;
	
	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/admin")
	public String admin() throws Exception{
		return "background/login" ;
	}
	
	@RequestMapping("/login")
	public String login(Model model,HttpServletRequest request,String userName,String password) throws Exception{
		model.addAttribute("mainPage", "default.jsp");
		String dispatcherPath = "background/mainTemp" ;
		if(request.getSession().getAttribute("user") == null){
			TUser user = userService.login(userName, password);
			if(user != null){
				request.getSession().setAttribute("user", user);
			}else{
				model.addAttribute("error", "用户名或密码错误！");
				model.addAttribute("username", userName) ;
				model.addAttribute("password", password) ;
				dispatcherPath = "background/login" ;
			}
		}
		return dispatcherPath ;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		if(session.getAttribute("user") != null){
			session.invalidate();
		}
		return "redirect:/admin" ;
	}
}
