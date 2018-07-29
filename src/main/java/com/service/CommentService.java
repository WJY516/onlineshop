package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommentService {
	public int InsertCommentByOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public int DeleteCommentByOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public int DeleteCommentByGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public int DeleteCommentByUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public int DeleteCommentByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public int UpdateCommentByOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public List SelectCommentByUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public List SelectCommentByGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public List SelectCommentByOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public List SelectCommentByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
