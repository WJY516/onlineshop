<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>订单管理</title>

		<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="../css/personal.css" rel="stylesheet" type="text/css">
		<link href="../css/orstyle.css" rel="stylesheet" type="text/css">

		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>

	</head>

	<body>
		
<jsp:include page="/home/top.jsp"></jsp:include>

            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="#">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">限时抢</a></li>
                                <li class="qc"><a href="#">团购</a></li>
                                <li class="qc last"><a href="#">大包装</a></li>
							</ul>
						    <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main" style="width: 1169px; ">
				<div class="main-wrap" style="height: 596px; width: 1181px; ">

					<div class="user-order">

						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small></div>
						</div>
						<hr/>

						<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

							

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									
									<div class="order-main">
										<div class="order-list">
											
											
											<!--交易失败-->
											<c:forEach items="${orderlist}" var="orderlist">
											<div class="order-status0">
												<div class="order-title">
													<div class="dd-num">订单编号：<a href="">${orderlist.orderId}</a></div>
													<div class="dd-num"> 总计   ${orderlist.orderPrice }</div>
													<div class="dd-num">TIME: ${orderlist.orderTime}</div>
													
													
												</div>
												
													<a href="/onlineshop/order/checkordergoods?id=${orderlist.orderId}&address=${orderlist.address}">详情</a>
													
													
													<%-- <c:if test="${orderlist.orderStatus == "pay" }">
													
													</c:if> --%>
													
													
													
													<c:choose>
														<c:when test="${orderlist.orderStatus == 'paying' }"> <a href="/onlineshop/order/refund?id=${orderlist.orderId}">退款</a></c:when>
														<c:when test="${orderlist.orderStatus == 'success refund' }"> 退款成功</c:when>
														<c:when test="${orderlist.orderStatus == 'can not refund' }"> 退款失败</c:when>
														<c:otherwise> 退款中 </c:otherwise>
													</c:choose>
													
													
													
													
											<%-- 		<%if(){%><a href="/onlineshop/order/refund?id=${orderlist.orderId}"></a>										
											<%} else if(${orderlist.orderStatus}=="success refund"){%>
											<%} else if(${orderlist.orderStatus}=="can not refund"){%>
											<%} else {%>
											<%} %> --%>
											</c:forEach>
										
									</div>

								</div>
								

								</div>
							</div>

						</div>
					</div>
				</div>
				

				</div>
				<div><jsp:include page="../person/left.jsp"></jsp:include></div>
			</div>


	</body>

</html>