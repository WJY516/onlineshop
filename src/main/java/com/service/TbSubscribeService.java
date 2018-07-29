package com.service;

import java.util.List;

import com.domain.TbGoods;
import com.domain.TbSubscribeKey;

public interface TbSubscribeService {
	
	public void subscribe(TbSubscribeKey subscribe);//关注商品
	public void deleteSubscribe(String userName,int goodsId);//取消关注
	public List<TbGoods> selectSubscribe(String userName);//查关注商品列表
}
