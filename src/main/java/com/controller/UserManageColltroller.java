package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.domain.TbMember;
import com.service.TbMemberService;

@Controller
@RequestMapping("/manager")
public class UserManageColltroller {
	
	@Autowired
	TbMemberService memberService;
	
	@RequestMapping("/getAllMember")//http://127.0.0.1/onlineshop/member/userCenter
	public ModelAndView userCenter(HttpSession session){
		ModelAndView mav = new ModelAndView();
		
			List<TbMember> members = memberService.selectAll();
			mav.addObject("members", members);
			mav.setViewName("/admin/userManage.jsp");
		return mav;
	}
	@RequestMapping("/deleteMember")
	public String deleteMember(String username,HttpSession session){
		boolean success = memberService.deleteMemberByPK(username);
		
		if(success){
			session.setAttribute("resultOfUserManage_jsp", "修改成功");
		}else{
			session.setAttribute("resultOfUserManage_jsp", "修改失败");
		}
		return "redirect:/manager/getAllMember";
	}

}
