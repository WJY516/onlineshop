/**
 * 
 */
package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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

/**
 * @author wujiayi
 * @date2018年7月30日 下午3:33:56
 *
 */
@Controller
@RequestMapping("/Brand")
public class BrandController {
	
	@Autowired
	BrandService brandService;
	
	@RequestMapping("/query")
//	@ResponseBody
//	public List<TbGoods> brandQueryByGoods(List<TbGoods> goodslistByName, Model m)
	public void brandQueryByGoods(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		List<TbGoods> goodslistByName = (List<TbGoods>) request.getAttribute("goodslistByName");
		List<String> Brandnamelist = new ArrayList<String>();
		List<String> Type1list = new ArrayList<String>();
		List<String> Type2list = new ArrayList<String>();
		TbBrand tempBrand = new TbBrand();
		for (TbGoods tbGoods : goodslistByName) {
			tempBrand = brandService.queryBrandByGoodsId(tbGoods.getGoodsId());
			if(tempBrand != null){
				Brandnamelist.add(tempBrand.getBrandName());
				Type1list.add(tempBrand.getType1());
				Type2list.add(tempBrand.getType2());
			}
		}
		
		//分别通过HashSet剔除重复元素
		
		//brandnamelist
		HashSet h1 = new HashSet(Brandnamelist);
		Brandnamelist.clear();
		Brandnamelist.addAll(h1);
		System.out.println("Brandnamelist:"+Brandnamelist);
		request.setAttribute("Brandnamelist", Brandnamelist);
		
		//Type1list
		HashSet h2 = new HashSet(Type1list);
		Type1list.clear();
		Type1list.addAll(h2);
		System.out.println("Type1list:"+Type1list);
		request.setAttribute("Type1list", Type1list);
		
		
		//Type2list 后面要用时再加入  勿删
		//Type2list
//		HashSet h3 = new HashSet(Type2list);
//		Type2list.clear();
//		Type2list.addAll(h3);
//		System.out.println("Type2list:"+Type2list);
//		request.setAttribute("Type2list", Type2list);
		
//		return Brandnamelist;
		//return (List<TbGoods>) request.getAttribute("goodslistByName");
		request.getRequestDispatcher("/home/search.jsp").forward(request, response);
	}
	
	@RequestMapping("/introduction")
//	@ResponseBody
	public void brandIntro(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		TbGoods tbgoodsIntro = (TbGoods) request.getAttribute("tbgoodsIntro");
		System.out.println(tbgoodsIntro.getGoodsName());
		TbBrand tbBrandIntro = brandService.queryBrandByGoodsId(tbgoodsIntro.getGoodsId());
		request.getRequestDispatcher("/home/introduction.jsp").forward(request, response);
		//		return tbBrandIntro;
	}
}
