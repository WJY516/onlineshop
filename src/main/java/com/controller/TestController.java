package com.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.TbMember;
import com.service.TbMemberService;

@Controller
@RequestMapping("/test")
public class TestController {
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	TbMemberService memberService; 
	
	@RequestMapping("/query") //http://127.0.0.1/onlineshop/test/query?userName= &type=
	@ResponseBody
	public TbMember queryMemberById(@RequestParam(name="userName")String userName){
		log.debug("id---------------------------"+userName);
		
		TbMember member = memberService.selectTbMemberByPK(userName);
		
		log.debug("result-----------------------"+member);
		return member;
	}
	@RequestMapping("/register") //http://127.0.0.1/onlineshop/test/register?userName=111
	@ResponseBody
	public boolean register(@RequestParam(name="userName")String userName,@RequestParam(name="type")int type){
		TbMember member = new TbMember();
		member.setUsername(userName);
		member.setType(type);
		boolean bool = memberService.registerMember(member);
		
		return bool;
	}

}
