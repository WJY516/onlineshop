package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.OrederGoods;
import com.domain.TbOrder;

public interface OrderService {
		public List<TbOrder> check(HttpServletRequest request,HttpServletResponse response);     //查看订单信息
		public long refund(HttpServletRequest request,HttpServletResponse response);             //申请退款
		public long admitrefund(int orderid);       //同意退款
		public long faultrefund(int orderid);       //拒绝退款
		public List<TbOrder> checkbyorderid(HttpServletRequest request,HttpServletResponse response);
		public List<TbOrder> checkall(HttpServletRequest request,
				HttpServletResponse response);
		public List<OrederGoods> ordergoodslist(HttpServletRequest request,
				HttpServletResponse response, String id);

		public long arrive(int orderid);
		public long send(int orderid);
		
		
}
