package com.service;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TbOrderMapper;
import com.domain.TbOrder;
import com.domain.TbOrderExample;
import com.domain.TbOrderExample.Criteria;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	TbOrderMapper ordermapper;
	@Override
	public List<TbOrder> check(HttpServletRequest request,HttpServletResponse response) {
		TbOrderExample ex=new TbOrderExample();
		HttpSession session=request.getSession();
		Criteria cr = ex.createCriteria();
		//String username=(String) session.getAttribute("username");
		String username="admin";
		cr.andUsernameEqualTo(username);
		List<TbOrder> list=ordermapper.selectByExample(ex);
		return list;
		
	}

	@Override
	public long refund(HttpServletRequest request,HttpServletResponse response) {
		TbOrderExample ex=new TbOrderExample();
		Criteria cr = ex.createCriteria();
		int orderid=Integer.valueOf(request.getParameter("order_id"));               //赋值
		cr.andOrderIdEqualTo(orderid);
		TbOrder order =ordermapper.selectByPrimaryKey(orderid);
		order.setOrderStatus("refund");
		
		long i=ordermapper.updateByExample(order,ex);
		return i;
		
	}

	@Override
	public long admitrefund(HttpServletRequest request,HttpServletResponse response) {
		TbOrderExample ex=new TbOrderExample();
		Criteria cr = ex.createCriteria();
		int orderid=2;                 //赋值
		cr.andOrderIdEqualTo(orderid);
		TbOrder order =ordermapper.selectByPrimaryKey(orderid);
		order.setOrderStatus("success refund");
		
		long i=ordermapper.updateByExample(order,ex);
		return i;
	}

	@Override
	public long faultrefund(HttpServletRequest request,
			HttpServletResponse response) {
		TbOrderExample ex=new TbOrderExample();
		Criteria cr = ex.createCriteria();
		int orderid=2;                 //赋值
		cr.andOrderIdEqualTo(orderid);
		TbOrder order =ordermapper.selectByPrimaryKey(orderid);
		order.setOrderStatus("can not refund");
		
		long i=ordermapper.updateByExample(order,ex);
		return i;
	}

	
	


}
