package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.TbSubscribeKey;
import com.service.TbMemberService;
import com.service.TbSubscribeService;

@Controller
@RequestMapping("/subscribe")
public class SubscribeController {
	
	@Autowired
	TbSubscribeService subscribeService;
	
	public String selectSubscribe(HttpSession session){
		String userName = (String) session.getAttribute("username");
		subscribeService.selectSubscribe(userName);
		return "/person/collection.jsp";
	}
	@RequestMapping("/insertSubscribe")
	//http://127.0.0.1/onlineshop/subscribe/subscribe?username=111&goodsId=001
	public String subscribe(TbSubscribeKey subscribe){
		subscribeService.insertSubscribe(subscribe);
		return null;	
	}
	

}
