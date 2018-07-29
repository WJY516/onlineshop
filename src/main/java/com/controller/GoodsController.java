/**
 * 
 */
package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.TbGoods;
import com.service.GoodsService;

/**
 * @author wujiayi
 * @date2018年7月28日 上午12:15:58
 *
 */
@Controller
@RequestMapping("/Goods")	
public class GoodsController {
	
	
	
	@Autowired
	GoodsService goodsService;

	@RequestMapping("/query")
	public void goodsQueryById(int goodsId,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		TbGoods goods = goodsService.queryGoodsById(goodsId);
		request.setAttribute("goods", goods);
		System.out.println(goods.getGoodsName());
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
	
	@RequestMapping("/list")
	public void goodsQueryAll(HttpServletRequest request,HttpServletResponse response){
		List<TbGoods> goodslist = goodsService.queryGoodsAll();
		request.setAttribute("goodslist", goodslist);
		System.out.println(goodsService.queryGoodsAll());
	}
	
	@RequestMapping("/queryname")
	public void goodsQueryByName(String goodsname,HttpServletRequest request,HttpServletResponse response){
		List<TbGoods> goodslistByName = goodsService.queryGoodsByName(goodsname);
		request.setAttribute("goodslistByName", goodslistByName);
		System.out.println(goodsService.queryGoodsByName(null));
	}
	
	@RequestMapping("/insert")
	public void goodsInsert(){
		//TODO
	}
	
	@RequestMapping("/delete")
	public void goodsDelete(){
		//TODO
	}
	
	@RequestMapping("/update")
	public void goodsUpdate(){
		//TODO
	}
}
