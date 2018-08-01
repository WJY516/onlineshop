package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.TbGoods;

public interface Shopping {
		public float shoppingone(HttpServletRequest request,HttpServletResponse response,float price,int i,TbGoods list1);         //一种商品的购买
		public float shoppingall(HttpServletRequest request,HttpServletResponse response,List<TbGoods> listgoods);          //多次调用shoppingone
		public List<TbGoods> findgoods(HttpServletRequest request,HttpServletResponse response);
}
