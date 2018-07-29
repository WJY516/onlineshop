package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.CommentService;


@Controller
@RequestMapping("/cooment")
public class CommentController {
	@Autowired
	CommentService commentservice;
	@RequestMapping("insertbyorder")
	public void InsertCommentByOrder(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		String order_id=request.getParameter("order_id");
		String goods_id=request.getParameter("goods_id");
		String comment=request.getParameter("comment");
		String comment_type=request.getParameter("comment_type");
		int success=commentservice.InsertCommentByOrder(username, order_id, goods_id, comment, comment_type);
	}
	
	
	@RequestMapping("deletebyorder")            //根据订单号删除
	public void DeleteCommentByOrder(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session=request.getSession();
		Integer id = request.getParameter("order_id") != null && !request.getParameter("order_id").equals("") ? Integer.parseInt(request.getParameter("order_id")) : null;
		int success=commentservice.DeleteCommentByOrder(id);
	}
	
	
	@RequestMapping("deletebygoods")               //根据商品删除
	public void DeleteCommentByGoods(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session=request.getSession();
		String goods_id=request.getParameter("goods_id");
		int success=commentservice.DeleteCommentByGoods(goods_id);
	}
	
	
	@RequestMapping("deletebyuser")                //根据用户删除
	public void DeleteCommentByUser(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		int success=commentservice.DeleteCommentByUser(username);
	}
	
	
	@RequestMapping("deletebytype")                   //根据类型删除
	public void DeleteCommentByType(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session=request.getSession();
		int comment_type=Integer.valueOf(request.getParameter("comment_type"));
		String goods_id=request.getParameter("goods_id");
		int success=commentservice.DeleteCommentByType(comment_type,goods_id);
	}
}
