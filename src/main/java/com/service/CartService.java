package com.service;


import com.domain.ServicePackage;
/*
 * TODO: 缺少重载
 */
public interface CartService {
	//显示购物车
	public ServicePackage showGoodsInCart(String username);
	//增加商品
	public ServicePackage addGoodsToCart(String username, int goodsid, int goodsnumber);
	//删除商品
	public ServicePackage deleteGoodsFromCart(String username, int[] goodsid);
	//修改数量
	public ServicePackage updateNumOfGoodsCart(String username, int goodsid, int goodsnumber);
	//结算商品
	public ServicePackage accountGoodsInCart(String username, int[] goodsid);
	//查询购物车商品数
	public long selectCountInCart(String username);
	
}