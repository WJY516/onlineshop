package com.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TbCommentMapper;
import com.domain.TbComment;
import com.domain.TbCommentExample;
import com.domain.TbCommentExample.Criteria;

@Service
public class CommentServicelmpl implements CommentService{
	@Autowired
	TbCommentMapper commentmapper;

	@Override
	public int InsertCommentByOrder(String username,String order_id,String goods_id,String comment,String comment_type){
		
		long count=0;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		int comment_type1=1;
		if(comment_type == "")
			comment_type = String.valueOf(comment_type);
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
			return 0;
		}
		else
		{
			
			TbComment record = new TbComment();
			record.setUsername(username);
			record.setOrderId(order_id);
			record.setGoodsId(goods_id);
			record.setComment(comment);
			record.setCommentType(comment_type1);
			record.setCommentTime(comment_time);
			count=commentmapper.insert(record);
			return (int) count;
		}
		
	}

	@Override
	public int DeleteCommentByOrder(int order_id){
		long count=0;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		cr.andIdEqualTo(order_id);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			return (int) count;
		}
		else
		{
			count=commentmapper.deleteByPrimaryKey(order_id);
			return (int) count;
		}
	}

	@Override
	public int DeleteCommentByGoods(String goods_id){
		long count=0;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();           
		cr.andGoodsIdEqualTo(goods_id);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			return (int) count;
		}
		else
		{
			count=commentmapper.deleteByExample(ex);
			return (int) count;
		}
		
	}

	@Override
	public int DeleteCommentByUser(String username){
		long count=0;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();         
		cr.andUsernameEqualTo(username);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			return (int) count;
		}
		else
		{
			count=commentmapper.deleteByExample(ex);
			return (int) count;
		}
	}

	@Override
	public int DeleteCommentByType(int comment_type,String goods_id){
		long count=0;
		int comment_type1 = 2;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		if(comment_type==1||comment_type==0||comment_type==-1)
			comment_type1=Integer.valueOf(comment_type);
		else return 0;
		cr.andGoodsIdEqualTo(goods_id);
		cr.andCommentTypeEqualTo(comment_type1);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			return 0;
		}
		else
		{
			count=commentmapper.deleteByExample(ex);
			return (int) count;
		}
	}

	@Override
	public int UpdateCommentByOrder(int id,String comment,int comment_type){
		long count=0;
		
		int comment_type1 = 1;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		if(comment_type==1||comment_type==0||comment_type==-1)
			comment_type1=Integer.valueOf(comment_type);
		else return 2;
		Timestamp comment_time=new Timestamp(System.currentTimeMillis());             
		cr.andIdEqualTo(id);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			return 0;
		}
		else
		{
			
			TbComment record = new TbComment();
			record.setComment(comment);
			record.setCommentType(comment_type1);
			record.setCommentTime(comment_time);
			count=commentmapper.updateByExampleSelective(record, ex);
			return (int) count;
		}
	}

	@Override
	public List SelectCommentByUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		long count=0;
		List<TbComment> list = null;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		String username=(String) session.getAttribute("username");          
		cr.andUsernameEqualTo(username);
		count=commentmapper.countByExample(ex);
		list=commentmapper.selectByExample(null);
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
	@Override
	public List SelectCommentByUserUncomment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		long count=0;
		List list = null;
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		String username=(String) session.getAttribute("username");
		String comment="";
		cr.andUsernameEqualTo(username);
		cr.andCommentEqualTo(comment);
		count=commentmapper.countByExample(ex);
		if(count == 0)
		{
			request.getRequestDispatcher("/色lect_comment_error.jsp").forward(request, response);
		}
		else
		{
			list=commentmapper.selectByExample(ex);
			request.getRequestDispatcher("/色lect_comment_success.jsp").forward(request, response);
		}
		return list;
}

	@Override
	public long ChcekNullByOrder(String username, String order_id) {
		TbCommentExample ex = new TbCommentExample();
		Criteria cr = ex.createCriteria();
		cr.andCommentIsNull();
		cr.andOrderIdEqualTo(order_id);
		long count = commentmapper.countByExample(ex);
		return count;
	}


}
