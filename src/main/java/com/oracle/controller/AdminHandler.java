package com.oracle.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.bean.Admin;
import com.oracle.service.AdminService;

@Controller
@Scope(value="prototype")
public class AdminHandler {
	
	@Autowired
	private AdminService adminService;
	
	
	
	@RequestMapping(value="/validateAccount",method=RequestMethod.GET)
	public String validateAccount(Admin admin,HttpServletResponse response) throws IOException{
		
		Admin a=this.adminService.login(admin.getAccount());
	
		
		if(a!=null){
			
			response.getWriter().write("{\"valid\":\"false\"}");//存在
		}else{
			
			response.getWriter().write("{\"valid\":\"true\"}");//不存在
		}
		
		
		return null;
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Admin admin){
		
		Admin a=adminService.login(admin.getAccount());
		
		if(a==null){//账号不存在
			
			return "login";
		}
		
		if(!a.getPassword().equals(admin.getPassword())){//密码错误
			
			return "login";
		}
		
		return "index";
		
		
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(Admin admin){
		
		
		int i=adminService.register(admin);
		
		if(i>0){
			
			return "login";
		}else{
			
			return "register";
		}
		
	}

}
