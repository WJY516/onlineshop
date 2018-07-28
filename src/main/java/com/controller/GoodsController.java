/**
 * 
 */
package com.controller;

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
	public void goodsQueryById(){
		System.out.println(goodsService.queryGoodsById(0));
	}
	
	@RequestMapping("/list")
	public void goodsQueryAll(){
		System.out.println(goodsService.queryGoodsAll());
	}
	
	@RequestMapping("/queryname")
	public void goodsQueryByName(){
		System.out.println(goodsService.queryGoodsByName(null));
	}
	
}
