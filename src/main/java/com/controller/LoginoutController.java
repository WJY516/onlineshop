package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.LoginoutService;

@Controller//告诉Bean工厂 我是Bean对象
@RequestMapping("/log")
public class LoginoutController {
	@Autowired
	LoginoutService loginoutService;

	
	//controller.LoginoutController
	@RequestMapping(value="/login")          
	public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		int count=loginoutService.Login(request,response);
		if(count!=0) {
			request.getRequestDispatcher("/home/home1.jsp").forward(request, response);
		}
		else {
			out.print("<script language='javascript'>alert('Wrong login name or password!!');window.location.href='/onlineshop/home/login.jsp';</script>");
		}
	}
	@RequestMapping(value="/logout") 
	public void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		int count=loginoutService.Logout(request,response);
		
		
		System.out.println("Test1.test1()"+count);
	}
}
