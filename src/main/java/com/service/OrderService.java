package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.TbOrder;

public interface OrderService {
		public List<TbOrder> check(HttpServletRequest request,HttpServletResponse response);     //查看订单信息
		public long refund(HttpServletRequest request,HttpServletResponse response);             //申请退款
		public long admitrefund(HttpServletRequest request,HttpServletResponse response);       //同意退款
		public long faultrefund(HttpServletRequest request,HttpServletResponse response);         //拒绝退款
		
}
