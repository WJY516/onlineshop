package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.TbMember;
import com.service.TbMemberService;


@Controller
@RequestMapping("/member")
public class TbMemberController {
	@Autowired
	TbMemberService memberService;
	
	@RequestMapping("/query")//http://127.0.0.1/onlineshop/member/query?username=111
	@ResponseBody
	public Object queryMemberByUserName(@RequestParam("username")String username){
		//String username = (String) session.getAttribute("username");
		if(null!=username && username.length()>0){
			TbMember member = memberService.selectTbMemberByPK(username);
			return member;
		}
		return "username null";
	}
	@RequestMapping("/register")//http://127.0.0.1/onlineshop/member/register?username=
	@ResponseBody
	public String register(TbMember member){
		boolean success = memberService.registerMember(member);
		if(success){
			return "success";//注册成功
		}
		return "failed";//注册失败
	}
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteMember(@RequestParam("username")String username){
		//String username = (String) session.getAttribute("username");
		if(null!=username && username.length()>0){
			boolean num = memberService.deleteMemberByPK(username);
			return "num="+num;
		}
		return "/login.jsp";
	}
	//http://127.0.0.1/onlineshop/member/update?username=113&truename=n0728
	@RequestMapping("/update")
	@ResponseBody
	public String updateMember(TbMember member){
		memberService.updateMemberByPK(member);
		return "";
	}

}