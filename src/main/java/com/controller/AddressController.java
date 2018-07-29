package com.controller;

import java.util.List;

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
	@RequestMapping("/select")
	public void selectAddress(HttpServletRequest request,HttpServletResponse response){
		String username=request.getParameter("username");
		String address_user=request.getParameter("address");

		List count=address.SelectAddress(username, address_user);
		if(count!=null) System.out.println("select");
	}
	@RequestMapping("/insert")
	public void insertAddress(HttpServletRequest request,HttpServletResponse response){
		String username=request.getParameter("username");
		String address_user=request.getParameter("address");

		int count=address.InsertAddress(username, address_user);
		if(count!=0) System.out.println("select");
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
		if(count!=0) System.out.println("select");
	}
	
}
