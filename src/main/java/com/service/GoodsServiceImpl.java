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
//		System.out.println(service);
//		System.out.println("getGoodsPrice()"+service.queryGoodsById(0).getGoodsPrice());
//		TbGoods tbgoods = new TbGoods();
//		List<TbGoods> goodslist = service.queryGoodsAll();
//		System.out.println("queryGoodsAll()");
//		for (TbGoods tbGoods : goodslist) {
//			System.out.print(tbGoods.getGoodsId());
//			System.out.print(" ");
//			System.out.print(tbGoods.getGoodsName());
//			System.out.print(" ");
//			System.out.print(tbGoods.getGoodsType());
//			System.out.print(" ");
//			System.out.print(tbGoods.getGoodsPrice());
//			System.out.print(" ");
//			System.out.print(tbGoods.getGoodsFreenum());
//			System.out.print(" ");
//			System.out.print(tbGoods.getGoodsDiscribes());
//			System.out.println();
//		}
		
		System.out.println(service.queryGoodsByName("测试"));
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
//		System.out.println(this.getClass()+":"+tbgoods.getGoodsDiscribes());
//		System.out.println("GoodsId:"+tbgoods.getGoodsId());
//		System.out.println("GoodsName:"+tbgoods.getGoodsName());
		flag = goods.updateByPrimaryKey(tbgoods);
//		System.out.println(flag);
		return flag;
	}


	/* (non-Javadoc)
	 * @see com.service.GoodsService#deleteGoods()
	 */
	@Override
	public int deleteGoodsById(int goodsId) {
		flag = goods.deleteByPrimaryKey(goodsId);
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
		System.out.println(name);
		TbGoodsExample ex = new TbGoodsExample();
		Criteria cr1 = ex.createCriteria();
		Criteria cr2 = ex.or();
		cr1.andGoodsNameLike("%"+name+"%");
		System.out.println("测试："+name);
		cr2.andGoodsTypeLike("%"+name+"%");
		List<TbGoods> goodslistByName = goods.selectByExample(ex);
		System.out.println(goodslistByName.size());
		return goodslistByName;
	}


	/* (non-Javadoc)
	 * @see com.service.GoodsService#queryGoodsByType()
	 */
	@Override
	public List<TbGoods> queryGoodsByType(String name) {
		TbGoodsExample ex = new TbGoodsExample();
		Criteria cr = ex.createCriteria();
		cr.andGoodsTypeLike("%"+name+";"+"%");
		List<TbGoods> goodslistByType = goods.selectByExample(ex);
		//System.out.println(goodslistByName);
		return goodslistByType;
	}


	/* (non-Javadoc)
	 * @see com.service.GoodsService#getGoodsId(com.domain.TbGoods)
	 */
	@Override
	public int getGoodsId(TbGoods tbgoods) {
		String name = tbgoods.getGoodsName();
		TbGoodsExample ex = new TbGoodsExample();
		Criteria cr = ex.createCriteria();
		cr.andGoodsNameLike(name);
		List<TbGoods> res = goods.selectByExample(ex);
		TbGoods tg = res.get(0);
		return tg.getGoodsId();
	}
}
