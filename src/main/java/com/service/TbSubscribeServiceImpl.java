package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TbGoodsMapper;
import com.dao.TbSubscribeMapper;
import com.domain.TbGoods;
import com.domain.TbGoodsExample;
import com.domain.TbSubscribeExample;
import com.domain.TbSubscribeExample.Criteria;
import com.domain.TbSubscribeKey;

@Service
public class TbSubscribeServiceImpl implements TbSubscribeService{
	@Autowired
	TbSubscribeMapper subscribeMapper;
	@Autowired
	TbGoodsMapper goodsMapper;

	@Override
	public void subscribe(TbSubscribeKey subscribe) {
		// TODO Auto-generated method stub
		subscribeMapper.insert(subscribe);
	}

	@Override
	public void deleteSubscribe(String userName, int goodsId) {
		// TODO Auto-generated method stub
		TbSubscribeExample example = new TbSubscribeExample();
		Criteria cr = example.createCriteria();
		cr.andUsernameEqualTo(userName);
		cr.andGoodsIdEqualTo(goodsId);
		subscribeMapper.deleteByExample(example);
	}

	@Override
	public List<TbGoods> selectSubscribe(String userName) {
		List<TbGoods> goodsList=null;
		
		//查找（userName,goodsId）
		TbSubscribeExample example = new TbSubscribeExample();
		Criteria cr = example.createCriteria();
		cr.andUsernameEqualTo(userName);
		List<TbSubscribeKey> list = subscribeMapper.selectByExample(example);
		
		//分离出goodsId，并查询对应的TbGoods数组
		List goodsIdList=new ArrayList<>();
		if(list!=null){
			for(int i=0;i<list.size();i++){
				goodsIdList.set(i, list.get(i));
			}
			
			TbGoodsExample example2 = new TbGoodsExample();
			com.domain.TbGoodsExample.Criteria cr2 = example2.createCriteria();
			cr2.andGoodsIdIn(goodsIdList);
			goodsList=goodsMapper.selectByExample(example2);
		}
		
		return goodsList;
	}

}
