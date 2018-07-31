package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.TbAddress;
import com.domain.TbGoods;
import com.service.AddressManagement;
import com.service.Shopping;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {
		@Autowired
		Shopping shopping;
		@Autowired
		AddressManagement address;
		@RequestMapping("/selectbyuser")
		public void selectAddressbyuser(HttpServletRequest request,HttpServletResponse response){
			String username=(String) request.getParameter("username");
			System.out.println("username_2:"+username);

			List<TbAddress> count=address.SelectAddressByUser(username);
			
			try {
				request.setAttribute("addresslist", count);
				request.getRequestDispatcher("/home/pay.jsp").forward(
						request, response);
			} catch (ServletException | IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
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
