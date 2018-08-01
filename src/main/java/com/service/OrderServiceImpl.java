package com.service;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrederGoodsMapper;
import com.dao.TbOrderMapper;
import com.domain.OrederGoods;
import com.domain.OrederGoodsExample;
import com.domain.TbOrder;
import com.domain.TbOrderExample;
import com.domain.TbOrderExample.Criteria;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	TbOrderMapper ordermapper;
	@Autowired
	OrederGoodsMapper ordergoodsmapper;
	@Override
	public List<TbOrder> check(HttpServletRequest request,HttpServletResponse response) {
		TbOrderExample ex=new TbOrderExample();
		HttpSession session=request.getSession();
		Criteria cr = ex.createCriteria();
		String username=(String) session.getAttribute("username");
		cr.andUsernameEqualTo(username);
		List<TbOrder> list=ordermapper.selectByExample(ex);
		return list;
		
	}
	
	
	
	
	@Override
	public List<TbOrder> checkall(HttpServletRequest request,HttpServletResponse response) {
		TbOrderExample ex=new TbOrderExample();
		HttpSession session=request.getSession();
		Criteria cr = ex.createCriteria();
		List<TbOrder> list=ordermapper.selectByExample(ex);
		return list;
		
	}
	
	
	@Override
	public List<TbOrder> checkbyorderid(HttpServletRequest request,HttpServletResponse response) {
		TbOrderExample ex=new TbOrderExample();
		Criteria cr = ex.createCriteria();
		String orderid=(String)request.getParameter("orderid");
		cr.andOrderIdEqualTo(Integer.valueOf(orderid));
		List<TbOrder> list=ordermapper.selectByExample(ex);
		return list;
		
	}
	

	@Override
	public long refund(HttpServletRequest request,HttpServletResponse response) {
		TbOrderExample ex=new TbOrderExample();
		Criteria cr = ex.createCriteria();
		String id=request.getParameter("id");
		int orderid=Integer.valueOf(id);               //赋值
		cr.andOrderIdEqualTo(orderid);
		TbOrder order =ordermapper.selectByPrimaryKey(orderid);
		order.setOrderStatus("refund");
		
		long i=ordermapper.updateByExampleSelective(order,ex);
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
		
		long i=ordermapper.updateByExampleSelective(order,ex);
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
		
		long i=ordermapper.updateByExampleSelective(order,ex);
		return i;
	}

	@Override
	public List<OrederGoods> ordergoodslist(HttpServletRequest request,
			HttpServletResponse response,String id) {
		OrederGoodsExample ex=new OrederGoodsExample();
		com.domain.OrederGoodsExample.Criteria cr = ex.createCriteria();
		request.getSession().setAttribute("orderId", id);
		cr.andOrderIdEqualTo(id);		
		List<OrederGoods> list=ordergoodsmapper.selectByExample(ex);
		return list;
	}

	
	


}
