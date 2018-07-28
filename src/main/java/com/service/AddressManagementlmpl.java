package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.TbAddressMapper;
import com.domain.TbAddress;
import com.domain.TbAddressExample;
import com.domain.TbAddressExample.Criteria;

public class AddressManagementlmpl implements AddressManagement{

	@Autowired
	TbAddressMapper addressmapper;
	@Override
	public int InsertAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		long count=0;
		TbAddressExample ex = new TbAddressExample();
		Criteria cr = ex.createCriteria();
		String username=request.getParameter("username");
		String address=request.getParameter("address");
		cr.andUsernameEqualTo(username);
		cr.andAddressEqualTo(address);
		count=addressmapper.countByExample(ex);
		if(count == 1)
		{
			request.getRequestDispatcher("/insertaddresserror.jsp").forward(request, response);
		}
		else
		{
			
			TbAddress record = new TbAddress();
			record.setAddress(address);
			record.setUsername(username);
			count=addressmapper.insert(record);
			request.getRequestDispatcher("/insertaddresssuccess.jsp").forward(request, response);
		}
		return (int) count;

	}

	@Override
	public int DeleteAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		long count=0;
		TbAddressExample ex = new TbAddressExample();
		Criteria cr = ex.createCriteria();
		String username=request.getParameter("username");
		String address=request.getParameter("address");
		cr.andUsernameEqualTo(username);
		cr.andAddressEqualTo(address);
		count=addressmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/deleteaddresserror.jsp").forward(request, response);
		}
		else
		{
			count=addressmapper.deleteByExample(ex);
			request.getRequestDispatcher("/deleteaddresssuccess.jsp").forward(request, response);
		}
		return (int) count;
	}

	@Override
	public int UpdateAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		long count=0;
		TbAddressExample ex = new TbAddressExample();
		Criteria cr = ex.createCriteria();
		String username=request.getParameter("username");
		String address=request.getParameter("address");
		cr.andUsernameEqualTo(username);
		cr.andAddressEqualTo(address);
		count=addressmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/updateaddresserror.jsp").forward(request, response);
		}
		else
		{
			TbAddress record = new TbAddress();
			record.setAddress(address);
			record.setUsername(username);
			count=addressmapper.updateByExample(record, ex);
			request.getRequestDispatcher("/updateaddresssuccess.jsp").forward(request, response);
		}
		return (int) count;
	}

	@Override
	public List SelectAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();	
		long count=0;
		TbAddressExample ex = new TbAddressExample();
		List list = null ;
		Criteria cr = ex.createCriteria();
		String username=request.getParameter("username");
		String address=request.getParameter("address");
		cr.andUsernameEqualTo(username);
		cr.andAddressEqualTo(address);
		count=addressmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/selectaddresserror.jsp").forward(request, response);
		}
		else
		{
			
			TbAddress record = new TbAddress();
			record.setAddress(address);
			record.setUsername(username);
			list = addressmapper.selectByExample(ex);
			request.getRequestDispatcher("/selectaddresssuccess.jsp").forward(request, response);
		}
		return list;
	}
	

}
