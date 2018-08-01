<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@page import="javax.servlet.*" %>
<div class="hmtop">
			<!--顶部导航条 -->
			
			<div class="am-container header">
				<ul class="message-l">
					<div class="topMessage">
						<div class="menu-hd">
						<%if(session.getAttribute("username")==null){ %>
							<a href="../home/login.jsp" target="_top" class="h">亲，请登录</a>
							<a href="../home/register.jsp" target="_top">免费注册</a>
						<%}else{ %>
						  <a target="_top" class="h">已登录：<%=session.getAttribute("username") %></a>
						 <a href="../log/logout">注销</a>
						<%} %> 
						<c:if test="${sessionScope.type==1}">
						  <a href="../admin/index.jsp">管理中心</a>
						
						</c:if>
					
						</div>
					</div>
				</ul>
				
				<ul class="message-r">
					<div class="topMessage home">
						<div class="menu-hd"><a href="/onlineshop/home/home1.jsp" target="_top" class="h">商城首页</a></div>
					</div>
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng"><a href="/onlineshop/member/userCenter" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd"><a id="mc-menu-hd" href="/onlineshop/cart" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd"><a href="/onlineshop/subscribe/getSubscribe" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
				</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logoBig">
						<li><img src="../images/logobig.png" /></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form action="../Goods/queryname">
							<input id="searchInput" name="goodsname" type="text" placeholder="搜索" autocomplete="off">
							<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>
