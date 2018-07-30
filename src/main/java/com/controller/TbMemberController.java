package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.domain.TbMember;
import com.service.TbMemberService;


@Controller
@RequestMapping("/member")
public class TbMemberController {
	@Autowired
	TbMemberService memberService;
	
	@RequestMapping("/userCenter")//http://127.0.0.1/onlineshop/member/userCenter
	public ModelAndView userCenter(HttpSession session){
		ModelAndView mav = new ModelAndView();
		String username=(String) session.getAttribute("username");
		if(username==null||username.length()<=0){
			mav.setViewName("redirect:/home/login.jsp");
			return mav;
		}
			TbMember member = memberService.selectTbMemberByPK(username);
			mav.addObject("member", member);
			mav.setViewName("/person/information.jsp");
		return mav;
	}
	
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
	public String register(TbMember member,HttpServletRequest request,Model m) throws IOException{
		
		member.setType(0);
		boolean success = memberService.insertMember(member);

		if(success){
			request.getSession().setAttribute("usernmae", member.getUsername());
			return "/home/home1.jsp";
//注册成功
		}
		else{
			return "/home/register.jsp";
//注册失败
		}
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
	public String updateMember(TbMember member){
		memberService.updateMemberByPK(member);
		return "redirect:/member/userCenter";
	}

}
