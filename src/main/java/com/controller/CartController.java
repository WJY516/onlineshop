package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.domain.CartPackage;
import com.domain.ServicePackage;
import com.domain.ServicePackage.StateType;
import com.domain.TbGoods;
import com.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartService cartService;
	
	/**
	 * 访问购物车时默认访问此处
	 * @param request
	 * @param response
	 * @return 视图：showcart，模型：goods
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping()
	public ModelAndView showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mv = null;
		HttpSession session=request.getSession();
		/*
		 *  检查是否登录，否则跳转到登录页。
		 */
		String username = (String)session.getAttribute("username");
		if(null==username){
			//使用filter??!!!
			response.sendRedirect("/onlineshop/home/login.jsp");
		}
		else{
			mv = new ModelAndView("/home/shopcart.jsp"); 
			mv.addObject("goodscart", cartService.showGoodsInCart(username));
		}
		/*
		 * 1、提示信息
		 * 2、刷新购物车页面 所需数据（重新加载）
		 */
		return mv;
	}
	
	/**
	 * 
	 * 不属于Cart，应该属于商品介绍页
	 */
	@RequestMapping(value="/add")
	public String addToCart(HttpServletRequest request, HttpServletResponse response,
			String goodsid, String goodsnumber){
		
		HttpSession session=request.getSession();
		ServicePackage spackage = cartService.addGoodsToCart((String)session.getAttribute("username"),  
					Integer.parseInt(goodsid), Integer.parseInt(goodsnumber));
		/*
		 * 根据原因跳转：missingshop页、shop页
		 * TODO: 可能不包含刷新页面所需的信息
		 */
		
		/*
		if(null!=spackage.getState() && spackage.getState().containsValue(StateType.PAGE_SHOP_SHANGPINBUCUNZAI)){
			//TODO: 需要开发
			mv = new ModelAndView("/home/missing.jsp");
		}
		else{
			mv = new ModelAndView("/home/introduction.jsp", "goodspage", spackage);
		}
		*/
		return "redirect:/cart";
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView deleteFromCart(HttpServletRequest request, HttpServletResponse response,
			@RequestParam int goodsid){
		HttpSession session=request.getSession();
		ModelAndView mv = new ModelAndView("/home/shopcart.jsp"); 
		mv.addObject("goodscart", 
				cartService.deleteGoodsFromCart((String)session.getAttribute("username"), goodsid));
		/*
		 * 1、提示信息
		 * 2、刷新购物车页面 所需数据（重新加载）
		 */
		
		return mv;
	}
	
	/**
	 * @param goodsnumber 传入更改后的数目
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView updateNumCart(HttpServletRequest request, HttpServletResponse response,
			@RequestParam int goodsid, @RequestParam int goodsnumber){
		HttpSession session=request.getSession();
		ModelAndView mv = new ModelAndView("/home/shopcart.jsp");
		mv.addObject("goodscart", 
				cartService.updateNumOfGoodsCart((String)session.getAttribute("username"), goodsid, goodsnumber));
		/*
		 * 1、提示信息
		 * 2、刷新购物车页面 所需数据（重新加载）
		 */
		
		return mv;
	}
	
	/**
	 * @param goodsnumber 传入更改后的数目
	 * @return
	 */
	@RequestMapping(value="/account")
	public void accountInCart(HttpServletRequest request, HttpServletResponse response,
			@RequestParam int[] goodsid){
		HttpSession session=request.getSession();
		ServicePackage spackage = cartService.accountGoodsInCart((String)session.getAttribute("username"), goodsid);
		/*
		 * 1、提示信息
		 * 2、刷新购物车页面 所需数据（重新加载）
		 */
		
		List<CartPackage> data = (List<CartPackage>)spackage.getDate();
		List<TbGoods> tbgoodslist = new ArrayList<TbGoods>();
		List<Integer> numberlist = new ArrayList<Integer>();
		for(CartPackage temppackage : data){
			tbgoodslist.add(temppackage.getGoods());
			numberlist.add(Integer.parseInt(temppackage.getGoods().getGoodsFreenum()));
			for(TbGoods i : tbgoodslist){
				System.out.println(i.getGoodsName());
			}
			for(Integer ix : numberlist){
				System.out.println(ix);
			}
		}
		
		session.setAttribute("tbgoodslist", tbgoodslist);
		session.setAttribute("numberlist", numberlist);
		try {
			request.getRequestDispatcher("/shopping/selectbyuser").forward(request, response);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		};
	}
}