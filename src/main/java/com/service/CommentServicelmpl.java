package com.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.TbCommentMapper;
import com.domain.TbComment;
import com.domain.TbCommentExample;
import com.domain.TbCommentExample.Criteria;

public class CommentServicelmpl implements CommentService{
	@Autowired
	TbCommentMapper commentmapper;

	@Override
	public int InsertCommentByOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		long count=0;
		int comment_type = 1;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		String username=(String) session.getAttribute("username");
		String order_id=request.getParameter("order_id");
		String goods_id=request.getParameter("goods_id");
		String comment=request.getParameter("comment");
		if(request.getParameter("comment_type") != "")
			comment_type = Integer.valueOf(request.getParameter("comment_type"));
		Timestamp comment_time=new Timestamp(System.currentTimeMillis());             
		cr.andUsernameEqualTo(username);
		cr.andOrderIdEqualTo(order_id);
		cr.andGoodsIdEqualTo(goods_id);
/*		cr.andCommentEqualTo(comment);
		cr.andCommentTypeEqualTo(comment_type);
		cr.andCommentTimeEqualTo(comment_time);*/
		count=commentmapper.countByExample(ex);
		if(count == 1)
		{
			request.getRequestDispatcher("/insert_comment_error.jsp").forward(request, response);
		}
		else
		{
			
			TbComment record = new TbComment();
			record.setUsername(username);
			record.setOrderId(order_id);
			record.setGoodsId(goods_id);
			record.setComment(comment);
			record.setCommentType(comment_type);
			record.setCommentTime(comment_time);
			count=commentmapper.insert(record);
			request.getRequestDispatcher("/insert_comment_success.jsp").forward(request, response);
		}
		return (int) count;
	}

	@Override
	public int DeleteCommentByOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long count=0;
		int id = 0;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		if(request.getParameter("id") != "")
			id = Integer.valueOf(request.getParameter("id"));
		cr.andIdEqualTo(id);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/delete_comment_error.jsp").forward(request, response);
		}
		else
		{
			count=commentmapper.deleteByPrimaryKey(id);
			request.getRequestDispatcher("/dlete_comment_success.jsp").forward(request, response);
		}
		return (int) count;
	}

	@Override
	public int DeleteCommentByGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long count=0;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		String goods_id=request.getParameter("goods_id");            
		cr.andGoodsIdEqualTo(goods_id);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/delete_comment_error.jsp").forward(request, response);
		}
		else
		{
			count=commentmapper.deleteByExample(ex);
			request.getRequestDispatcher("/delete_comment_success.jsp").forward(request, response);
		}
		return (int) count;
	}

	@Override
	public int DeleteCommentByUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		long count=0;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		String username=(String) session.getAttribute("username");          
		cr.andUsernameEqualTo(username);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/delete_comment_error.jsp").forward(request, response);
		}
		else
		{
			count=commentmapper.deleteByExample(ex);
			request.getRequestDispatcher("/delete_comment_success.jsp").forward(request, response);
		}
		return (int) count;
	}

	@Override
	public int DeleteCommentByType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long count=0;
		int comment_type = 2;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		String goods_id=request.getParameter("goods_id");
		if(request.getParameter("comment_type") != "")
			comment_type = Integer.valueOf(request.getParameter("comment_type"));
		cr.andGoodsIdEqualTo(goods_id);
		cr.andCommentTypeEqualTo(comment_type);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/delete_comment_error.jsp").forward(request, response);
		}
		else
		{
			count=commentmapper.deleteByExample(ex);
			request.getRequestDispatcher("/delete_comment_success.jsp").forward(request, response);
		}
		return (int) count;
	}

	@Override
	public int UpdateCommentByOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long count=0;
		int id =0;
		int comment_type = 1;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		String comment=request.getParameter("comment");
		if(request.getParameter("comment_type") != "")
			comment_type = Integer.valueOf(request.getParameter("comment_type"));
		Timestamp comment_time=new Timestamp(System.currentTimeMillis());             
		cr.andIdEqualTo(id);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/delete_comment_error.jsp").forward(request, response);
		}
		else
		{
			
			TbComment record = new TbComment();
			record.setComment(comment);
			record.setCommentType(comment_type);
			record.setCommentTime(comment_time);
			count=commentmapper.updateByExampleSelective(record, ex);
			request.getRequestDispatcher("/delete_comment_success.jsp").forward(request, response);
		}
		return (int) count;
	}

	@Override
	public List SelectCommentByUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		long count=0;
		List list = null;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		String username=(String) session.getAttribute("username");          
		cr.andUsernameEqualTo(username);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/select_comment_error.jsp").forward(request, response);
		}
		else
		{
			list=commentmapper.selectByExample(ex);
			request.getRequestDispatcher("/select_comment_success.jsp").forward(request, response);
		}
		return list;
	}

	@Override
	public List SelectCommentByGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long count=0;
		List list = null;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		String goods_id=request.getParameter("goods_id");
		cr.andGoodsIdEqualTo(goods_id);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/select_comment_error.jsp").forward(request, response);
		}
		else
		{
			list=commentmapper.selectByExample(ex);
			request.getRequestDispatcher("/insert_comment_success.jsp").forward(request, response);
		}
		return list;
	}

	@Override
	public List SelectCommentByOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long count=0;
		List list = null;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		String order_id=request.getParameter("order_id");
		String goods_id=request.getParameter("goods_id");             
		cr.andOrderIdEqualTo(order_id);
		cr.andGoodsIdEqualTo(goods_id);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/select_comment_error.jsp").forward(request, response);
		}
		else
		{
			list=commentmapper.selectByExample(ex);
			request.getRequestDispatcher("/insert_comment_success.jsp").forward(request, response);
		}
		return list;
	}

	@Override
	public List SelectCommentByType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long count=0;
		List list = null;
		int comment_type = 2;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		String goods_id=request.getParameter("goods_id");
		if(request.getParameter("comment_type") != "")
			comment_type = Integer.valueOf(request.getParameter("comment_type"));            
		cr.andGoodsIdEqualTo(goods_id);
		cr.andCommentTypeEqualTo(comment_type);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/select_comment_error.jsp").forward(request, response);
		}
		else
		{
			list=commentmapper.selectByExample(ex);
			request.getRequestDispatcher("/insert_comment_success.jsp").forward(request, response);
		}
		return list;
	}

}
