package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.TbGoods;
import com.service.Shopping;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {
		@Autowired
		Shopping shopping;
		
		@RequestMapping("/find")
		public void find(HttpServletRequest request,HttpServletResponse response){
				List<TbGoods> goods=shopping.findgoods(request, response);
				request.setAttribute("goodslist", goods);
				System.out.println(goods.get(0).getGoodsId());
		}
		@RequestMapping("/shopping")
		public void shoppingall(HttpServletRequest request,HttpServletResponse response,List<TbGoods> listgoods){
			shopping.shoppingall(request,response,listgoods);
		}
}
