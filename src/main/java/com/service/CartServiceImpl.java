package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TbBrandMapper;
import com.dao.TbCartMapper;
import com.dao.TbGoodsMapper;
import com.domain.CartPackage;
import com.domain.TbGoods;
import com.domain.TbBrand;
import com.domain.TbCart;
import com.domain.TbCartExample;
import com.domain.TbCartExample.Criteria;
import com.domain.ServicePackage;
import com.domain.ServicePackage.StateType;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	TbCartMapper cartmapper;
	@Autowired
	TbGoodsMapper goodsmapper;
	@Autowired
	TbBrandMapper brandmapper;
	
	/**
	 * 商品结算
	 * 前台传回的goodsid将其装填ServicePackage传回
	 * 注意结算成功后要告诉购物车，更新数据库
	 */
	@Override
	public ServicePackage accountGoodsInCart(String username, int[] goodsid) {
		ServicePackage retn = new ServicePackage();
		retn.setDate(new ArrayList<CartPackage>());
		retn.setState(new HashMap<Integer, StateType>());
		for(int id : goodsid){
			retn = findGoodsForAccount(username, id, retn);
		}
		return retn;
	}
	
	/**
	 * @see com.service.CartService#showCart(java.lang.String)
	 * @return List<TbGoods> 其中goodsFreenum的意义在这里更改为 购物车内该商品数量
	 * 显示购物车，位于购物车界面
	 */
	@Override
	public ServicePackage showGoodsInCart(String username) {
		ServicePackage retn = new ServicePackage();
		return reFreshCart(username, retn);
	}
	
	/**
	 * @see com.service.CartService#addGoodsToCart(java.lang.String, int, int)
	 * 增加商品，位于商品界面，业务：更新Cart 、 视图 、返回的是一个CartPackage
	 * 应该先检查商品是否还存在，若存在则正常进行功能，否则将视图定向到商品不存在界面
	 */
	@Override
	public ServicePackage addGoodsToCart(String username, int goodsid, int goodsnumber) {
		ServicePackage retn = new ServicePackage();
		Map<Integer, StateType> retnmap = new HashMap<Integer, StateType>();
		
		TbGoods goodsingoods = isGoodsExist(goodsid);
		if(null==goodsingoods){
			//商品不存在，定向到商品不存在界面
			retnmap.put(goodsid, StateType.PAGE_SHOP_SHANGPINBUCUNZAI);
			retn.setState(retnmap);
			return retn;
		}
		TbBrand abrand = brandmapper.selectByPrimaryKey(goodsingoods.getGoodsId());
		CartPackage temppackage = new CartPackage(goodsingoods, abrand);
		retn.setDate(temppackage);
		List<TbCart> listcart = selectCart(username);
		int goodsfreenum = Integer.parseInt(goodsingoods.getGoodsFreenum());
		if(!(null==listcart || listcart.size()==0)){
			for(TbCart goodsincart : listcart){
				if(goodsincart.getGoodsId()==goodsid){
					//商品在购物车
					goodsnumber += goodsincart.getGoodsNumber();
					if(goodsnumber > goodsfreenum){
						/*
						 * 提示库存紧张，添加失败
						 */
						retnmap.put(goodsid, StateType.CARD_SHOP_KUCUNJINZHANG);
					}
					else{
						retnmap.put(goodsid, StateType.CARD_SHOP_SUCCESS);
						updateGoodsNumber(goodsincart.getId(), goodsnumber);
					}
					retn.setState(retnmap);
					return retn;
				}
			}
		}
		//商品不在购物车
		if(goodsnumber > goodsfreenum){
			/*
			 * 提示库存紧张，添加失败
			 */
			retnmap.put(goodsid, StateType.CARD_SHOP_KUCUNJINZHANG);
		}
		else{
			addGoods(username, goodsid, goodsnumber);
		}
		return retn;
	}

	/**
	 * @see com.service.CartService#deleteGoodsFromCart(java.lang.String, int)
	 * 删除商品，位于购物车界面，业务：更新Cart
	 */
	@Override
	public ServicePackage deleteGoodsFromCart(String username, int goodsid) {
		/*
		 * 直接查TbCart查到就删
		 */
		ServicePackage retn = new ServicePackage();
		deleteGoods(username, goodsid);
		return reFreshCart(username, retn);
	}

	/**
	 * @see com.service.CartService#updateNumOfGoodsCart(java.lang.String, int, int)
	 * @param username、goodsid：定位购物车中商品，goodsnumber：修改后的值
	 * 修改数量，位于购物车界面
	 */
	@Override
	public ServicePackage updateNumOfGoodsCart(String username, int goodsid, int goodsnumber) {
		ServicePackage retn = new ServicePackage();
		Map<Integer, StateType> retnmap = new HashMap<Integer, StateType>();
		
		TbCartExample ex = new TbCartExample();
		Criteria cr = ex.createCriteria();
		cr.andUserNameEqualTo(username);//同一商品不同类，id也不同
		cr.andGoodsIdEqualTo(goodsid);
		List<TbCart> cartlist = cartmapper.selectByExample(ex);
		try {
			TbCart goodsincart = cartlist.get(0);
			TbGoods goodsingoods = isGoodsExist(goodsid);

			/*
			 * TODO:
			 * 这里的goods.getGoodsFreenum()是剩余数量吗？
			 * 商品已下架时是否存入Cookie，并在视图中单列一表来展示，这样的话还得写一个清除它们的函数
			 */
			if (null == goodsingoods || goodsingoods.getGoodsFreenum() == "0") {
				/*
				 * 变更失败，删除该商更新TbCart，并提示商品已下架，return
				 */
				deleteGoods(username, goodsid);
				//提示商品已下架
				retnmap.put(goodsid, StateType.CARD_CART_SHANGPINBUCUNZAI);
			} 
			else{
				int maxnum = Integer.parseInt(goodsingoods.getGoodsFreenum());
				if (goodsnumber > maxnum){
					/*
					 * 变更失败，将购物车商品数量以最大值显示更新TbCart，并提醒库存紧张
					 */
					updateGoodsNumber(goodsincart.getId(), maxnum);
					//提示库存紧张
					retnmap.put(goodsid, StateType.CARD_CART_KUCUNJINZHANG);
				}
				else if(goodsnumber < 1){
					/*
					 * 变更失败，将购物车商品数量以1显示更新TbCart，并提醒最小值为1
					 */
					if(goodsincart.getGoodsNumber() != 1){
						updateGoodsNumber(goodsincart.getId(), 1);
					}
					
					//提示最小值为1
					retnmap.put(goodsid, StateType.CARD_CART_NUMBERMIN);
				}
				else{
					/*
					 * 变更成功，将购物车商品数量更改为该值更新TbCart
					 */
					updateGoodsNumber(goodsincart.getId(), goodsnumber);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		retn.setState(retnmap);
		return reFreshCart(username, retn);
	}
	

	
	/**
	 * 刷新购物车
	 * 1、先获取当前购物车，然后检查购物车商品是否存在以下问题，并做出处理
	 * 2、商品不存在时更新购物车，提醒商品已下架
	 * 3、商品库存变更时更新购物车，提醒库存紧张
	 * 4、根据需求修改返回值
	 */
	private ServicePackage reFreshCart(String username, ServicePackage spackage){
		List<TbCart> listcart = selectCart(username);
		/*
		 * 无商品，直接返回空的包
		 */
		if(null==listcart || listcart.size()==0){
			return spackage;
		}

		List<CartPackage> listpackage = new ArrayList<CartPackage>();
		Map<Integer, StateType> retnmap = spackage.getState();
		if(null==retnmap || retnmap.size()==0){
			retnmap = new HashMap<Integer, StateType>();
		}

		int goodsid, goodsnumber;
		for(TbCart goodsincart : listcart){
			goodsid = goodsincart.getGoodsId();
			goodsnumber = goodsincart.getGoodsNumber();
			
			TbGoods goodsingoods = goodsmapper.selectByPrimaryKey(goodsid);
			
			if(null==goodsingoods || goodsingoods.getGoodsFreenum()=="0"){
				/*
				 * 删除该商品更新TbCart，并提示商品已下架，contiune
				 */
				deleteGoods(username, goodsid);
				//TODO: 提示商品已下架，要存在cookie里
				retnmap.put(goodsid, StateType.CARD_CART_SHANGPINBUCUNZAI);
				continue;
			}

			int maxnum = Integer.parseInt(goodsingoods.getGoodsFreenum());
			if(goodsnumber > maxnum){
				/*
				 * 将购物车商品数量以最大值显示，更新TbCart，并提醒库存紧张，contiune
				 */
				updateGoodsNumber(goodsincart.getId(), maxnum);
				retnmap.put(goodsid, StateType.CARD_CART_KUCUNJINZHANG);
			}
			goodsingoods.setGoodsFreenum(String.valueOf(goodsincart.getGoodsNumber()));
			
			TbBrand thisgoods = brandmapper.selectByPrimaryKey(goodsid);
			CartPackage temppackage = new CartPackage();
			temppackage.setGoods(goodsingoods);
			temppackage.setBrand(thisgoods);
			
			listpackage.add(temppackage);
		}
		
		spackage.setDate(listpackage);
		spackage.setState(retnmap);
		return spackage;
	}
	/**
	 * 判断是否存在该商品
	 */
	private TbGoods isGoodsExist(int goodsid){
		TbGoods goodsingoods = goodsmapper.selectByPrimaryKey(goodsid);
		return goodsingoods;
	}
	/**
	 * 查找该用户购物车商品
	 */
	private List<TbCart> selectCart(String username) {
		List<TbCart> list = null;
				
		TbCartExample ex = new TbCartExample();
		Criteria cr = ex.createCriteria();
		cr.andUserNameEqualTo(username);
		list = cartmapper.selectByExample(ex);
		
		return list;
	}
	/**
	 * 向Cart表增加商品
	 */
	private long addGoods(String username, int goodsid, int goodsnumber){
		TbCart cart = new TbCart();
		
		cart.setId(null);
		cart.setGoodsId(goodsid);
		cart.setGoodsNumber(goodsnumber);
		cart.setUserName(username);
		
		return cartmapper.insert(cart);
	}
	/**
	 * 从cart中删除商品
	 */
	private long deleteGoods(String username, int goodsid){
		TbCartExample ex = new TbCartExample();
		Criteria cr = ex.createCriteria();
		cr.andUserNameEqualTo(username);
		cr.andGoodsIdEqualTo(goodsid);
		return cartmapper.deleteByExample(ex);
	}
	/**
	 * 从cart中查找商品， 并返回其ServicePackage
	 */
	private ServicePackage findGoodsForAccount(String username, int goodsid, ServicePackage spackage){
		List<CartPackage> data = (List<CartPackage>)spackage.getDate();
		Map<Integer, StateType> state = spackage.getState();
		
		TbCartExample ex = new TbCartExample();
		Criteria cr = ex.createCriteria();
		cr.andUserNameEqualTo(username);
		cr.andGoodsIdEqualTo(goodsid);
		List<TbCart> cart = cartmapper.selectByExample(ex);
		if(null==cart || cart.size()==0){
			/*
			 * 购物车内无商品
			 */
			if(!state.containsKey(ServicePackage.GOUWUCHENULL)){
				state.put(ServicePackage.GOUWUCHENULL, StateType.MESSAGE_CART_COUNT_GOUWUCHENULL);
				spackage.setState(state);
			}
			return spackage;
		}
		/*
		 * 获得goods和brand数据
		 */
		TbGoods agoods = goodsmapper.selectByPrimaryKey(goodsid);
		agoods.setGoodsFreenum(String.valueOf(cart.get(0).getGoodsNumber()));
		TbBrand abrand = brandmapper.selectByPrimaryKey(goodsid);
		if(null==agoods || null==abrand){
			/*
			 * 商品下架
			 */
			state.put(cart.get(0).getGoodsId(), StateType.MESSAGE_CART_COUNT_GOUWUCHENULL);
			spackage.setState(state);
			return spackage;
		}
		/*
		 * 装填返回
		 */
		CartPackage temppackage = new CartPackage();
		temppackage.setGoods(agoods);
		temppackage.setBrand(abrand);
		data.add(temppackage);
		spackage.setDate(data);
		return spackage;
	}
	/**
	 * 修改cart中的商品
	 */
	private long updateGoodsNumber(int cartid, int goodsnumber){
		TbCart record = new TbCart();
		record.setId(cartid);
		record.setGoodsNumber(goodsnumber);
		return cartmapper.updateByPrimaryKeySelective(record);
	}

}
