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
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.OrederGoods;
import com.domain.TbComment;
import com.domain.TbGoods;
import com.service.CommentService;
import com.service.GoodsService;
import com.service.OrderService;


@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	CommentService commentservice;
	@Autowired
	OrderService orderservice;
	@Autowired
	GoodsService goodsservice;
	@RequestMapping("/insertbyorder")
	public void InsertCommentByOrder(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		String order_id=(String) request.getSession().getAttribute("orderId");
		String goods_id=request.getParameter("goodsid");
		String comment=request.getParameter("comment");
		String comment_type=request.getParameter("comment_type");
		int success=commentservice.InsertCommentByOrder(username, order_id, goods_id, comment, comment_type);
		if(success!=0)
		try {
			request.getRequestDispatcher("/comment/selectbyuser").forward(request, response);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping("/checknull")
	public void checknull(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		String order_id=request.getParameter("orderid");
		request.setAttribute("id",order_id);
		long success=commentservice.ChcekNullByOrder(username,order_id);
		
		List<OrederGoods> checklist=orderservice.ordergoodslist(request, response,order_id);
		List<TbGoods> goodslist=new ArrayList<TbGoods>();
		TbGoods good =null;
		int i=0;
		for(OrederGoods list:checklist){
			i=Integer.valueOf(list.getGoodsId());
			good = goodsservice.queryGoodsById(i);
			goodslist.add(good);
			good=null;
		}
		request.setAttribute("goodslist",goodslist);
		if(success==0){
			request.getRequestDispatcher("/person/commentlist.jsp").forward(request, response);
		}
		else  request.getRequestDispatcher("/comment/selectbyuser").forward(request, response);
	}
	
	
	@RequestMapping("/deletebyorder")            //根据订单号删除
	public void DeleteCommentByOrder(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session=request.getSession();
		Integer id = request.getParameter("order_id") != null && !request.getParameter("order_id").equals("") ? Integer.parseInt(request.getParameter("order_id")) : null;
		int success=commentservice.DeleteCommentByOrder(id);
	}
	
	
	@RequestMapping("/deletebygoods")               //根据商品删除
	public void DeleteCommentByGoods(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session=request.getSession();
		String goods_id=request.getParameter("goods_id");
		int success=commentservice.DeleteCommentByGoods(goods_id);
	}
	
	
	@RequestMapping("/deletebyuser")                //根据用户删除
	public void DeleteCommentByUser(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		int success=commentservice.DeleteCommentByUser(username);
	}
	
	
	@RequestMapping("/deletebytype")                   //根据类型删除
	public void DeleteCommentByType(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session=request.getSession();
		int comment_type=Integer.valueOf(request.getParameter("comment_type"));
		String goods_id=request.getParameter("goods_id");
		int success=commentservice.DeleteCommentByType(comment_type,goods_id);
	}
	
	

	@RequestMapping("/updatebyorder")                   //根据订单修改评论
	public void UpdateCommentByOrder(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session=request.getSession();
		String comment=request.getParameter("comment");
		int id=Integer.valueOf(request.getParameter("comment_id"));
		int comment_type=Integer.valueOf(request.getParameter("comment_type"));
		int success=commentservice.UpdateCommentByOrder(id,comment,comment_type);
	}
	
	
	@RequestMapping("/selectbyuser")            //根据用户搜索
	public void selectByUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<TbComment> list=commentservice.SelectCommentByUser(request,response);
		request.setAttribute("selectbyuserlist", list);
		try {
			request.getRequestDispatcher("/person/comment.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@RequestMapping("/selectbyorder")            //根据订单搜索
	public void selectByOrder(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<TbComment> list=commentservice.SelectCommentByOrder(request,response);
		request.setAttribute("selectbyorder_list", list);
	}
	@RequestMapping("/selectbygoods")            //根据货物编号搜索
	public void selectByGoods(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<TbComment> list=commentservice.SelectCommentByGoods(request,response);
		request.setAttribute("selectbygoods_list", list);
	}
	@RequestMapping("/selectbytype")            //根据类型搜索
	public void selectByType(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<TbComment> list=commentservice.SelectCommentByType(request,response);
		request.setAttribute("selectbytype_list", list);
	}
	
	
	
	
	@RequestMapping("/selectall")           
	public void selectall(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<TbComment> list=commentservice.SelectCommentAll(request,response);
		
		if(list!=null){
			try {
				request.setAttribute("selectalllist", list);
				request.getRequestDispatcher("/admin/comment.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
}
}
