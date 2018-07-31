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
	@Autowired
	OrederGoodsMapper ordergoods;
	@Autowired
	TbOrderMapper order;


	@Override
	public void shoppingone(HttpServletRequest request,
			HttpServletResponse response,float price,int i,TbGoods list1) {
		HttpSession session=request.getSession();
		OrederGoods odgd=new OrederGoods();
		String orderid=String.valueOf(i);
		String goodsid="1";                  //璐х墿id
		String goodsnum="0";					//璐х墿鏁伴噺
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
		cr1.andGoodsNameLike("%gyk%");                                           //鍚嶅瓧涓壘璇�
		cr2.andGoodsDiscribesLike("gyk%");                                       //鎻忚堪涓壘璇�
		cr3.andGoodsTypeLike("%gyk%");                                      //type鎵捐瘝
		List<TbGoods> tbgoods=goods.selectByExample(ex);
		return tbgoods;
	}



	@Override
	public void shoppingall(HttpServletRequest request,
			HttpServletResponse response,List<TbGoods> listgoods) {
		Timestamp dateNow=new Timestamp(System.currentTimeMillis());             //鑾峰彇绯荤粺鏃堕棿
		TbOrder tborder=null;
		TbOrderExample orderex=new TbOrderExample();
		order.insert(tborder);                 //鎻掑叆
		com.domain.TbOrderExample.Criteria ordercr=orderex.createCriteria();
		ordercr.andOrderStatusIsNull();
		List<TbOrder> orderlist= order.selectByExample(orderex);          //鎼滅储鍒氬垰寤虹珛鐨勭┖琛ㄩ」
		int u=orderlist.get(0).getOrderId();                                //鑾峰彇orderid
		float price=0;
		for(TbGoods list1:listgoods){
			shoppingone(request,response,price,u,list1);
		}
		String orderprice=String.valueOf(price);
		String user="";
		String address=request.getParameter("address");
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
