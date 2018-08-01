package com.domain;

import java.util.List;
import java.util.Map;


public class ServicePackage {
	public static final int GOUWUCHENULL = -1;
	
	public enum StateType {
		/*
		 * CARD ：修改一个元素
		 * PAGE ：需要定向到其他页面
		 * MESSAGE : 消息
		 * 
		 * CART ：位于购物车
		 * SHOP ：位于商品展示页
		 */
		MESSAGE_CART_COUNT_GOUWUCHENULL,	
		CARD_CART_SHANGPINBUCUNZAI,	//应该放在cookie里，所以这个是没有意义的，暂时做个标记
		CARD_CART_KUCUNJINZHANG,
		CARD_CART_NUMBERMIN,
		CARD_SHOP_KUCUNJINZHANG,
		CARD_SHOP_SUCCESS,
		PAGE_SHOP_SHANGPINBUCUNZAI
	}
	
	private Object date;
//	private List<CartPackage> date;
	private Map<Integer, StateType> state;
	
	public ServicePackage(){
		super();
	}
//	public ServicePackage(Map<Integer, StateType> state, Object date){
//		super();
//		this.state = state;
//		this.date = date;
//	}
	public ServicePackage(Map<Integer, StateType> state, List<CartPackage> date){
		super();
		this.state = state;
		this.date = date;
	}
	
	public Map<Integer, StateType> getState() {
		return state;
	}
	public void setState(Map<Integer, StateType> state) {
		this.state = state;
	}
	public Object getDate() {
		return date;
	}
	public void setDate(Object date) {
		this.date = date;
	}
//	public List<CartPackage> getDate() {
//		return date;
//	}
//	public void setDate(List<CartPackage> date) {
//		this.date = date;
//	}
}
