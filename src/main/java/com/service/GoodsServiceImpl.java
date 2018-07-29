/**
 * 
 */
package com.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.TbGoodsMapper;
import com.domain.TbGoods;
import com.domain.TbGoodsExample;
import com.domain.TbGoodsExample.Criteria;

/**
 * @author wujiayi
 * @date2018年7月27日 下午9:37:36
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService{

	int flag = 0;
	@Autowired
	TbGoodsMapper goods;
	

	/* (non-Javadoc)
	 * @see com.service.GoodsService#queryGoodsList()
	 */
	
	@Override
	public TbGoods queryGoodsById(int goodsId) {
		
		// TODO Auto-generated method stub
		// int goodsId = 0;
		TbGoods tbgoods = goods.selectByPrimaryKey(goodsId);
		System.out.println(tbgoods.getGoodsPrice());
		return (TbGoods) tbgoods;
	}
	
	
	@Test
	public void test(){
		
		String configLocation  = "springmvc.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
		GoodsService service = ac.getBean(GoodsService.class);
		System.out.println(service);
		System.out.println("getGoodsPrice()"+service.queryGoodsById(0).getGoodsPrice());
		TbGoods tbgoods = new TbGoods();
		List<TbGoods> goodslist = service.queryGoodsAll();
		System.out.println("queryGoodsAll()");
		for (TbGoods tbGoods : goodslist) {
			System.out.print(tbGoods.getGoodsId());
			System.out.print(" ");
			System.out.print(tbGoods.getGoodsName());
			System.out.print(" ");
			System.out.print(tbGoods.getGoodsType());
			System.out.print(" ");
			System.out.print(tbGoods.getGoodsPrice());
			System.out.print(" ");
			System.out.print(tbGoods.getGoodsFreenum());
			System.out.print(" ");
			System.out.print(tbGoods.getGoodsDiscribes());
			System.out.println();
		}
		
		System.out.println(service.queryGoodsByName("测试样例2"));
		System.out.println("jaslkdfjslakdjflksadjflksadjflksdjflk");
	}


	/* (non-Javadoc)
	 * @see com.service.GoodsService#addGoods()
	 */
	@Override
	public int insertGoods(TbGoods tbgoods) {
		flag = goods.insert(tbgoods);
		// TODO Auto-generated method stub
		return flag;
	}


	/* (non-Javadoc)
	 * @see com.service.GoodsService#updateGoods(com.domain.TbGoods)
	 */
	@Override
	public int updateGoods(TbGoods tbgoods) {
		
		flag = goods.updateByPrimaryKey(tbgoods);
		return flag;
	}


	/* (non-Javadoc)
	 * @see com.service.GoodsService#deleteGoods()
	 */
	@Override
	public int deleteGoodsById(TbGoods tbgoods) {
		flag = goods.deleteByPrimaryKey(tbgoods.getGoodsId());
		return flag;
	}


	/* (non-Javadoc)
	 * @see com.service.GoodsService#queryGoodsAll()
	 */
	@Override
	public List<TbGoods> queryGoodsAll() {
		List<TbGoods> goodslist = goods.selectByExample(null);
		return goodslist;
	}


	/* (non-Javadoc)
	 * @see com.service.GoodsService#queryGoodsByName(java.lang.String)
	 */
	@Override
	public List<TbGoods> queryGoodsByName(String name) {
		// TODO Auto-generated method stub
		TbGoodsExample ex = new TbGoodsExample();
		Criteria cr = ex.createCriteria();
		cr.andGoodsDiscribesLike(name);
		List<TbGoods> goodslistByName = goods.selectByExample(ex);
		//System.out.println(goodslistByName);
		return goodslistByName;
	}
}
