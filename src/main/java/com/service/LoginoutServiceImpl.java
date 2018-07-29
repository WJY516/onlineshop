/**
 * 
 */
package com.service;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.*;
import com.domain.*;
import com.domain.TbMemberExample.Criteria;
/**
 * @author 50134
 *
 */
@Service
public class LoginoutServiceImpl implements LoginoutService{
	
	@Autowired
	TbMemberMapper usermapper;
	@Override
	public int Login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		long count=0;
		TbMemberExample ex=new TbMemberExample();
		Criteria cr = ex.createCriteria();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		cr.andUsernameEqualTo(username);
		cr.andPasswordEqualTo(password);
		count=usermapper.countByExample(ex);
		TbMember user=usermapper.selectByPrimaryKey(username);
		if(count!=0){
			session.setAttribute("username",username);
			session.setAttribute("type",user.getType());
			}
		
		
		// TODO 自动生成的方法存根
		
		return (int) count;
	}

	@Override
	public int Logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		// TODO 自动生成的方法存根
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		if(username!=null){
			session.invalidate();
			request.getRequestDispatcher("/index.jsp").forward(request,response);
			}
		else request.getRequestDispatcher("/login.jsp").forward(request,response);
		
		return 0;
	}


}
