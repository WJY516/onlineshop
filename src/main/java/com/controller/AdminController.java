/**
 * 
 */
package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.TbBrand;
import com.domain.TbGoods;
import com.service.BrandService;
import com.service.GoodsService;

/**
 * @author wujiayi
 * @date2018年7月31日 上午11:38:11
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	GoodsService goodsService;
	@Autowired
	BrandService brandService;
	
	@RequestMapping("/goods")
	public String goodsqueryAll(Model m){
		List<TbGoods> goodsListAll = goodsService.queryGoodsAll();
		m.addAttribute("goodsListAll", goodsListAll);
		return "../admin/index.jsp";
	}
	
	@RequestMapping(value="/addgoods")
	@ResponseBody
	public String goodsAdd(TbGoods tbgoods,TbBrand tbbrand,HttpServletRequest request,HttpServletResponse response){
//		System.out.println("goodsAdd");
//		System.out.println("tbgoods:"+tbgoods.getGoodsName());
//		System.out.println("tbbrand:"+tbbrand.getBrandName());
//		List<Object> list = new ArrayList<Object>();
//		list.add(tbgoods);
//		list.add(tbbrand);
		/*
		 * 此处应该考虑数据同步更新和回滚。
		 * 这个需求之后再做了
		 */
		int in_flag = -2;
		System.out.println("addgoods");
		try{
			in_flag += goodsService.insertGoods(tbgoods);
		}catch (Exception e){
			return "fail";
		}
		int goodsId = goodsService.getGoodsId(tbgoods);
		tbbrand.setGoodsId(String.valueOf(goodsId));
		tbbrand.setType1("type1");
		tbbrand.setType2("type2");
		in_flag += brandService.insertBrands(tbbrand);
		if(in_flag == 0){
			return "success";
		}
		else{
			return "fail";
		}
	}
	
	@RequestMapping("/listgoods")
	public void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<TbGoods> goodsListAll = goodsService.queryGoodsAll();
		request.setAttribute("goodsListAll", goodsListAll);
		request.getRequestDispatcher("../admin/goodslist.jsp").forward(request, response);
	}
	
	@RequestMapping("/jumptoupdategoods")
	public void updategoods(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String temp = request.getParameter("goodsId");
		int goodsId=Integer.valueOf(temp);
//		System.out.println("goodsId"+goodsId);
		TbGoods tbgoods = goodsService.queryGoodsById(goodsId);
		System.out.println(tbgoods.getGoodsDiscribes());
		
		request.setAttribute("TbGoods",tbgoods);
		request.getRequestDispatcher("../admin/updatagoods.jsp").forward(request, response);
	}
	
	@RequestMapping("/updategoods")
	@ResponseBody
	public String goodsupdata(TbGoods tbgoods,HttpServletRequest request,HttpServletResponse response){
		int flag = 0;
		try{
			flag = goodsService.updateGoods(tbgoods);
			System.out.println(tbgoods.getGoodsDiscribes());
		}catch (Exception e) {
			return "fail";
		}
		if(flag != 1){
			return "fail";
		}
		return "success";
	}
	
	@RequestMapping("/deletegoodsbyId")
	public String deletegoods(int goodsId){
		goodsService.deleteGoodsById(goodsId);
		brandService.deleteBrandsByGoodsID(goodsId);
		return "redirect:../admin/listgoods";
	}
}



