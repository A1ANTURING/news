package com.ht.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.component.InitServlet;

@Controller
@RequestMapping("/admin/application")
public class AdminAppliactionController {
	
	private InitServlet initServlet ;
	
	public InitServlet getInitServlet() {
		return initServlet;
	}
	@Resource
	public void setInitServlet(InitServlet initServlet) {
		this.initServlet = initServlet;
	}

	@RequestMapping("refresh")
	public String refresh(HttpSession session) throws Exception {
		initServlet.setServletContext(session.getServletContext());
		return "redirect:/login.action" ;
	}
}
