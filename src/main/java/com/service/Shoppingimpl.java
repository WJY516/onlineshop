package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrederGoodsMapper;
import com.dao.TbGoodsMapper;
import com.domain.TbGoods;
import com.domain.TbGoodsExample;
import com.domain.TbGoodsExample.Criteria;

@Service
public class Shoppingimpl implements Shopping{
	@Autowired
	TbGoodsMapper goods;
	OrederGoodsMapper ordergoods;
	TbOrderMapper order;

	@Override
	public void shopping(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void showgoods(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO 自动生成的方法存根
		TbGoodsExample ex=new TbGoodsExample();
		HttpSession session=request.getSession();
		Criteria cr = ex.createCriteria();
		//String username=(String) session.getAttribute("username");
		cr.andGoodsNameEqualTo(username);
		Integer goodsId;
		List<TbGoods> goodslist=goods.selectByExample(ex);
		
	}

	@Override
	public void findgoods(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO 自动生成的方法存根
		
	}

}
