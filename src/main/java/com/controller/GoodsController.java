/**
 * 
 */
package com.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public TbGoods goodsQueryById(int goodsId){
		TbGoods goods = goodsService.queryGoodsById(goodsId);
		return goods;
	}
	
	@RequestMapping("/list")
	public List<TbGoods> goodsQueryAll(){
		List<TbGoods> goodslist = goodsService.queryGoodsAll();
		return goodslist;
	}
	
	@RequestMapping("/queryname")
	@ResponseBody
	public List<TbGoods> goodsQueryByName(String goodsname,HttpServletRequest request){
		String name = request.getParameter("name");
		try {
			byte[] b = name.getBytes("ISO-8859-1");
			goodsname = new String(b,"utf-8"); 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//		goodsname = request.getParameter("name");
		System.out.println(goodsname);
		List<TbGoods> goodslistByName = goodsService.queryGoodsByName(goodsname);
		return goodslistByName;
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
}
