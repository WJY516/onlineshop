package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domain.TbGoods;
import com.domain.TbSubscribeKey;
import com.service.TbMemberService;
import com.service.TbSubscribeService;

@Controller
@RequestMapping("/subscribe")
public class SubscribeController {
	
	@Autowired
	TbSubscribeService subscribeService;
	
	@RequestMapping("/getSubscribe")
	public ModelAndView selectSubscribe(HttpSession session){
		String userName = (String) session.getAttribute("username");
		List<TbGoods> goodsList = subscribeService.selectSubscribe(userName);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/person/collection.jsp");//System.out.println("username---goodList size"+userName+"------"+goodsList.size());
		mav.addObject("goodsList", goodsList);
		return mav;
	}
	@RequestMapping("/insertSubscribe")
	//http://127.0.0.1/onlineshop/subscribe/subscribe?username=111&goodsId=001
	public String subscribe(HttpSession session,@RequestParam("goodsId")Integer goodsId){
		TbSubscribeKey subscribe = new TbSubscribeKey();
		subscribe.setGoodsId(goodsId);
		subscribe.setUsername((String) session.getAttribute("username"));
		
		subscribeService.insertSubscribe(subscribe);
		return "redirect:/subscribe/getSubscribe";	
	}
	@RequestMapping("/insertAnySubscribe")
	//http://127.0.0.1/onlineshop/subscribe/subscribe?username=111&goodsId=001
	public String subanyscribe(HttpSession session,@RequestParam("goodsId")int[] goodsId){
		TbSubscribeKey subscribe = new TbSubscribeKey();
		
		for(int goodsid : goodsId){
			subscribe.setGoodsId(goodsid);
			subscribe.setUsername((String) session.getAttribute("username"));
			subscribeService.insertSubscribe(subscribe);
		}
		
		return "redirect:/subscribe/getSubscribe";
	}
	@RequestMapping("/deleteSubscribe")
	public String deleteSubscribe(@RequestParam int goodsId,HttpSession session){
		String userName = (String) session.getAttribute("username");
		subscribeService.deleteSubscribe(userName, goodsId);
		
		return "redirect:/subscribe/getSubscribe";	
	}
	

}
