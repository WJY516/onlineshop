/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domain.TbGoods;

/**
 * @author wujiayi
 * @date2018年7月27日 下午9:37:03
 *
 */

public interface GoodsService {
	public TbGoods queryGoodsById(int goodsId);
	public List<TbGoods> queryGoodsByName(String name);
	public List<TbGoods> queryGoodsAll();
	public List<TbGoods> queryGoodsByType(String name);
	public int insertGoods(TbGoods tbgoods);
	public int updateGoods(TbGoods tbgoods);
	public int deleteGoodsById(int goodsId);
	public int getGoodsId(TbGoods tbgoods);
//	TODO public List<String> queryType(String type);
	
}
