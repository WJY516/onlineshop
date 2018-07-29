package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommentService {
	public int InsertCommentByOrder(String username,String order_id,String goods_id,String comment,String comment_type);
	
	public int DeleteCommentByOrder(int order_id);
	public int DeleteCommentByGoods(String goods_id);
	public int DeleteCommentByUser(String username);
	public int DeleteCommentByType(int comment_type,String goods_id);
	
	public int UpdateCommentByOrder(int id,String comment,int comment_type);
	
	public List SelectCommentByUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public List SelectCommentByGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public List SelectCommentByOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public List SelectCommentByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
