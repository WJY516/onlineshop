/**
 * 
 */
package com.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.TbBrand;
import com.domain.TbGoods;
import com.service.BrandService;
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
	public String goodsQueryById(int goodsId,Model m){
		TbGoods goods = goodsService.queryGoodsById(goodsId);
		m.addAttribute("goods", goods);
		return "/home/introduction.jsp";
	}
	
	@RequestMapping("/list")
	public List<TbGoods> goodsQueryAll(){
		List<TbGoods> goodslist = goodsService.queryGoodsAll();
		return goodslist;
	}
	
	@RequestMapping("/queryname")
//	@ResponseBody
	public void goodsQueryByName(String goodsname,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println(goodsname);
		request.setAttribute("goodsname", goodsname);
		List<TbGoods> goodslistByName = goodsService.queryGoodsByName(goodsname);
		request.setAttribute("goodslistByName", goodslistByName);
//		return "/home/search.jsp";
		request.getRequestDispatcher("/Brand/query").forward(request, response);
	}
	
	@RequestMapping("/insert")
	public void goodsInsert(TbGoods tbgoods){
		goodsService.insertGoods(tbgoods);
	}
	
	@RequestMapping("/delete")
	public void goodsDelete(int goodsid){
		goodsService.deleteGoodsById(goodsid);
	}
	
	@RequestMapping("/update")
	public void goodsUpdate(TbGoods tbgoods){
		goodsService.updateGoods(tbgoods);
	}
	
	@RequestMapping("/introduction")
	public void goodsIntroduction(int goodsId,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		TbGoods tbgoodsIntro = goodsService.queryGoodsById(goodsId);
		request.setAttribute("tbgoodsIntro", tbgoodsIntro);
		request.getRequestDispatcher("/Brand/introduction").forward(request,response);
	}
	
	
	/*
	 * 在点击商品品牌时跳转
	 */
	@RequestMapping("/queryR")
	public void goodsQueryReady(HttpServletRequest request,HttpServletResponse response){
		//TODO 这个需求做不了
	}
	
	
	/*
	 * 立即购买
	 */
	@RequestMapping("/buy")
//	@ResponseBody
	public void buy(int goodsID,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		TbGoods tbgoods = goodsService.queryGoodsById(goodsID);
		List<TbGoods> listgoods = new ArrayList<TbGoods>();
		listgoods.add(tbgoods);
		request.setAttribute("listgoods", listgoods);
		request.getRequestDispatcher("/shopping/selectbyuser").forward(request,response);
	}
	
}
