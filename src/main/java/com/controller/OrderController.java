package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.OrederGoods;
import com.domain.TbOrder;
import com.service.OrderService;

@Controller//告诉Bean工厂 我是Bean对象
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderservice;
	
	//com.controller.OrderController
	@RequestMapping("/refund")
	public void refund(HttpServletRequest request,HttpServletResponse response){
		long fund=orderservice.refund(request, response);
		if(fund==0){
			
			try {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else
			try {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
	@RequestMapping("/check")
	public void check(HttpServletRequest request,HttpServletResponse response){
		List<TbOrder> checklist=orderservice.check(request, response);
		if(checklist!=null){
		try {
			request.setAttribute("orderlist",checklist);
			request.getRequestDispatcher("/person/order.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(TbOrder check:checklist){
			System.out.println(check.getOrderId());
		}
		}
	}
	
	@RequestMapping("/checkordergoods")
	public void checkgoods(HttpServletRequest request,HttpServletResponse response){
		List<OrederGoods> checklist=orderservice.ordergoodslist(request, response);
		if(checklist!=null){
		try {
			request.setAttribute("ordergoodslist",checklist);
			request.getRequestDispatcher("/person/orderinfo.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(OrederGoods check:checklist){
			System.out.println(check.getOrderId());
		}
		}
	}
	
	@RequestMapping("/admitrefund")
	public void admitrefund(HttpServletRequest request,HttpServletResponse response){
		long fund=orderservice.admitrefund(request, response);
		if(fund==0){
			
			try {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else
			try {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
	@RequestMapping("/faultrefund")
	public void faultrefund(HttpServletRequest request,HttpServletResponse response){
		long fund=orderservice.faultrefund(request, response);
		if(fund==0){
			
			try {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else
			try {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
	
}
