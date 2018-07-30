package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.AddressManagement;


@Controller
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressManagement address;
	@RequestMapping("/selectbyuser")
	public void selectAddressbyuser(HttpServletRequest request,HttpServletResponse response){
		String username=request.getParameter("username");
		System.out.println("username_2:"+username);

		List count=address.SelectAddressByUser(username);
		
		try {
			request.setAttribute("addresslist", count);
			request.getRequestDispatcher("/person/address.jsp").forward(
					request, response);
		} catch (ServletException | IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@RequestMapping("/selectbyid")
	public void selectAddressbyId(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("address_id");
		int address_id = Integer.valueOf(id);
		List count=address.SelectAddressById(address_id);
		if(count!=null) System.out.println("select");
	}
	@RequestMapping("/insert")
	public void insertAddress(HttpServletRequest request,HttpServletResponse response){
		String username=(String) request.getSession().getAttribute("username");
		String address_user=request.getParameter("address");

		int count=address.InsertAddress(username, address_user);
		if(count!=0) 
			try {
				System.out.println("username_1:"+username);
				request.getRequestDispatcher("/address/selectbyuser?username="+username+"").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		else {
			
		}
	}
	@RequestMapping("/update")
	public void updateAddress(HttpServletRequest request,HttpServletResponse response){
		String username=request.getParameter("username");
		String address_user=request.getParameter("address");
		String address_id=request.getParameter("address_id");
		int count=address.UpdateAddress(username, address_user, address_id);
		if(count!=0) System.out.println("select");
	}
	@RequestMapping("/delete")
	public void deleteAddress(HttpServletRequest request,HttpServletResponse response){
		String username=request.getParameter("username");
		String address_user=request.getParameter("address");

		int count=address.DeleteAddress(username, address_user);
		try {
			request.getRequestDispatcher("/address/selectbyuser").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
