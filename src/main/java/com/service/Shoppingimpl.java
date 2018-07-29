package com.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrederGoodsMapper;
import com.dao.TbGoodsMapper;
import com.dao.TbOrderMapper;
import com.domain.OrederGoods;
import com.domain.OrederGoodsExample;
import com.domain.TbGoods;
import com.domain.TbGoodsExample;
import com.domain.TbOrder;
import com.domain.TbOrderExample;

@Service
public class Shoppingimpl implements Shopping{
	@Autowired
	TbGoodsMapper goods;
	OrederGoodsMapper ordergoods;
	TbOrderMapper order;


	@Override
	public void shoppingone(HttpServletRequest request,
			HttpServletResponse response,float price,int i,TbGoods list1) {
		HttpSession session=request.getSession();
		OrederGoods odgd=new OrederGoods();
		String orderid=String.valueOf(i);
		String goodsid="1";                  //货物id
		String goodsnum="1";					//货物数量
		odgd.setOrderId(orderid);
		odgd.setGoodsId(goodsid);
		odgd.setGoodsNum(goodsnum);
		ordergoods.insert(odgd);
		float num= Float.parseFloat(goodsnum);
		float goodprice= Float.parseFloat(list1.getGoodsPrice());
		price+=num*goodprice;
	
	}



	@Override
	public List<TbGoods> findgoods(HttpServletRequest request,
			HttpServletResponse response) {
		List goodslist=null;
		TbGoodsExample ex=new TbGoodsExample();
		HttpSession session=request.getSession();
		com.domain.TbGoodsExample.Criteria cr1 = ex.createCriteria();
		com.domain.TbGoodsExample.Criteria cr2 = ex.createCriteria();
		com.domain.TbGoodsExample.Criteria cr3 = ex.createCriteria();
		cr1.andGoodsNameLike("%gyk%");                                           //名字中找词
		cr2.andGoodsDiscribesLike("gyk%");                                       //描述中找词
		cr3.andGoodsTypeLike("%gyk%");                                      //type找词
		List<TbGoods> tbgoods=goods.selectByExample(ex);
		return tbgoods;
	}



	@Override
	public void shoppingall(HttpServletRequest request,
			HttpServletResponse response,List<TbGoods> listgoods) {
		Timestamp dateNow=new Timestamp(System.currentTimeMillis());             //获取系统时间
		TbOrder tborder=null;
		TbOrderExample orderex=new TbOrderExample();
		order.insert(tborder);                 //插入
		com.domain.TbOrderExample.Criteria ordercr=orderex.createCriteria();
		ordercr.andOrderStatusIsNull();
		List<TbOrder> orderlist= order.selectByExample(orderex);          //搜索刚刚建立的空表项
		int u=orderlist.get(0).getOrderId();                                //获取orderid
		float price=0;
		for(TbGoods list1:listgoods){
			shoppingone(request,response,price,u,list1);
		}
		String orderprice=String.valueOf(price);
		String user="";
		String address="";
		tborder=order.selectByPrimaryKey(orderlist.get(0).getOrderId());
		tborder.setUsername(user);
		tborder.setOrderTime(dateNow);
		tborder.setAddress(address);
		tborder.setOrderPrice(orderprice);
		tborder.setOrderStatus("paying");
		order.insert(tborder);		
		System.out.println(price);
	}

}
