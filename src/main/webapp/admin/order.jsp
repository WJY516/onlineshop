<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="/onlineshop/admin/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="/onlineshop/admin/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="/onlineshop/admin/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="/onlineshop/admin/assets/css/admin.css">
<script src="/onlineshop/admin/assets/js/jquery.min.js"></script>
<script src="/onlineshop/admin/assets/js/app.js"></script>
<script language="javascript">
	function arriveOrder(formId){				 //送达
		alert('成功');
		$('#'+formId).attr('action', "/onlineshop/order/arrive");
		//document.form${status.count}.action = "/order/arrive";
		$('#'+formId).submit();
			
	}
	function sendOrder(formId) {				 //派送
		alert('成功');
		$('#'+formId).attr('action', "/onlineshop/order/send");
		//document.form${status.count}.action = "/order/arrive";
		$('#'+formId).submit();
	}
	
	
	
	
	
	function faultOrder(formId){				 //拒绝退货
		alert('成功');
		$('#'+formId).attr('action', "/onlineshop/order/faultrefund");
		//document.form${status.count}.action = "/order/arrive";
		$('#'+formId).submit();
			
	}
	function admireOrder(formId) {                 //同意退货
		alert('成功');
		$('#'+formId).attr('action', "/onlineshop/order/admitrefund");
		//document.form${status.count}.action = "/order/arrive";
		$('#'+formId).submit();
	}
</script>
</head>
	<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->

<body>
	<header class="am-topbar admin-header">
		<div class="am-topbar-brand">
			<img src="assets/i/logo.png">
		</div>

		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">

				<li class="am-dropdown tognzhi" data-am-dropdown>
					<button
						class="am-btn am-btn-primary am-dropdown-toggle am-btn-xs am-radius am-icon-bell-o"
						data-am-dropdown-toggle>
						消息管理<span class="am-badge am-badge-danger am-round">6</span>
					</button>
					<ul class="am-dropdown-content">



						<li class="am-dropdown-header">所有消息都在这里</li>


						<li><a href="#">未激活会员 <span class="am-badge am-badge-danger am-round">556</span></a></li>
						<li><a href="#">未激活代理 <span class="am-badge am-badge-danger am-round">69</span></a></a></li>
						<li><a href="#">未处理汇款</a></li>
						<li><a href="#">未发放提现</a></li>
						<li><a href="#">未发货订单</a></li>
						<li><a href="#">低库存产品</a></li>
						<li><a href="#">信息反馈</a></li>



					</ul>
				</li>

				<li class="kuanjie"><a href="#">会员管理</a> <a href="#">奖金管理</a> <a
					href="#">订单管理</a> <a href="#">产品管理</a> <a href="#">个人中心</a> <a
					href="#">系统设置</a></li>

				<li class="soso">

					<p>

						<select
							data-am-selected="{btnWidth: 70, btnSize: 'sm', btnStyle: 'default'}">
							<option value="b">全部</option>
							<option value="o">产品</option>
							<option value="o">会员</option>

						</select>

					</p>

					<p class="ycfg">
						<input type="text" class="am-form-field am-input-sm"
							placeholder="圆角表单域" />
					</p>
					<p>
						<button class="am-btn am-btn-xs am-btn-default am-xiao">
							<i class="am-icon-search"></i>
						</button>
					</p>
				</li>




				<li class="am-hide-sm-only" style="float: right;"><a
					href="javascript:;" id="admin-fullscreen"><span
						class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
			</ul>
		</div>
	</header>

	<jsp:include page="../admin/left.jsp"></jsp:include>
		<div class=" admin-content">

			<div class="daohang">
				<ul>
					<li><button type="button"
							class="am-btn am-btn-default am-radius am-btn-xs">首页</li>
					<li><button type="button"
							class="am-btn am-btn-default am-radius am-btn-xs">
							帮助中心<a href="javascript: void(0)" class="am-close am-close-spin"
								data-am-modal-close="">×</a>
						</button></li>
					<li><button type="button"
							class="am-btn am-btn-default am-radius am-btn-xs">
							奖金管理<a href="javascript: void(0)" class="am-close am-close-spin"
								data-am-modal-close="">×</a>
						</button></li>
					<li><button type="button"
							class="am-btn am-btn-default am-radius am-btn-xs">
							产品管理<a href="javascript: void(0)" class="am-close am-close-spin"
								data-am-modal-close="">×</a>
						</button></li>


				</ul>




			</div>


			<div class="am-popup am-popup-inner" id="my-popup">

				<div class="am-popup-hd">
					<h4 class="am-popup-title">添加商品一级分类</h4>
					<span data-am-modal-close class="am-close">&times;</span>
				</div>

				<div class="am-popup-bd">


					<form class="am-form tjlanmu">


						<div class="am-form-group">
							<div class="zuo">栏目名称：</div>
							<div class="you">
								<input type="email" class="am-input-sm" id="doc-ipt-email-1"
									placeholder="请输入标题">
							</div>
						</div>
						<div class="am-form-group">
							<div class="zuo">栏目关键词：</div>
							<div class="you">
								<input type="password" class="am-input-sm" id="doc-ipt-pwd-1"
									placeholder="请输入关键词">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">栏目描述：</div>
							<div class="you">
								<textarea class="" rows="2" id="doc-ta-1"></textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">栏目图片：</div>
							<div class="you" style="height: 45px;">
								<input type="file" id="doc-ipt-file-1">
								<p class="am-form-help">请选择要上传的文件...</p>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">简介：</div>
							<div class="you">
								<textarea class="" rows="2" id="doc-ta-1"></textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">状态：</div>
							<div class="you" style="margin-top: 3px;">
								<label class="am-checkbox-inline"> <input
									type="checkbox" value="option1"> 显示
								</label> <label class="am-checkbox-inline"> <input
									type="checkbox" value="option2"> 隐藏
								</label>

							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="you">
								<p>
									<button type="submit" class="am-btn am-btn-success am-radius">提交</button>
								</p>
							</div>
						</div>
					</form>





				</div>



			</div>





			<div class="am-popup am-popup-inner" id="my-popups">

				<div class="am-popup-hd">
					<h4 class="am-popup-title">修改栏目名称</h4>
					<span data-am-modal-close class="am-close">&times;</span>
				</div>

				<div class="am-popup-bd">


					<form class="am-form tjlanmu">


						<div class="am-form-group">
							<div class="zuo">栏目名称：</div>
							<div class="you">
								<input type="email" class="am-input-sm" id="doc-ipt-email-1"
									placeholder="请输入标题">
							</div>
						</div>
						<div class="am-form-group">
							<div class="zuo">栏目关键词：</div>
							<div class="you">
								<input type="password" class="am-input-sm" id="doc-ipt-pwd-1"
									placeholder="请输入关键词">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">栏目描述：</div>
							<div class="you">
								<textarea class="" rows="2" id="doc-ta-1"></textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">栏目图片：</div>
							<div class="you" style="height: 45px;">
								<input type="file" id="doc-ipt-file-1">
								<p class="am-form-help">请选择要上传的文件...</p>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">简介：</div>
							<div class="you">
								<textarea class="" rows="2" id="doc-ta-1"></textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">状态：</div>
							<div class="you" style="margin-top: 3px;">
								<label class="am-checkbox-inline"> <input
									type="checkbox" value="option1"> 显示
								</label> <label class="am-checkbox-inline"> <input
									type="checkbox" value="option2"> 隐藏
								</label>

							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="you">
								<p>
									<button type="submit" class="am-btn am-btn-success am-radius">提交</button>
								</p>
							</div>
						</div>
					</form>

				</div>

			</div>




			<div class="admin-biaogelist">

				<div class="listbiaoti am-cf">
					<ul class="am-icon-flag on">订单列表
					</ul>

					<dl class="am-icon-home" style="float: right;">
						当前位置： 首页 >
						<a href="#">商品列表</a>
					</dl>

					<dl>
						<button type="button"
							class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus">
							补充线订单</button>
					</dl>
					<!--这里打开的是新页面-->


				</div>















				<table width="100%"
					class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th class="table-check"><input type="checkbox" /></th>

							<th class="table-id">ID</th>
							<th class="table-author am-hide-sm-only">购买人</th>
							<th class="table-author am-hide-sm-only">地址</th>
							<th class="table-date am-hide-sm-only">购买日期</th>
							<th class="table-author am-hide-sm-only">状态</th>
							<th width="130px" class="table-set">操作</th>
						</tr>
					</thead>


					<c:forEach items="${orderlist}" var="order" varStatus="status">
						<form name="form${status.count }" id="form${status.count}">
							<tbody>
								<tr>
									<td><input type="checkbox" /></td>

									<td>${order.orderId}</td>
									<td class="am-hide-sm-only">${order.username}</td>
									<td class="am-hide-sm-only">${order.address}</td>
									<td class="am-hide-sm-only">${order.orderTime}</td>
									<td class="am-hide-sm-only">${order.orderStatus}</td>
									<td>
									
									
									<input type="hidden" name="orderid" value="${order.orderId}" />
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
<c:choose>
												
	<c:when test="${order.orderStatus=='refund'}">    		
												<input type="submit" name="fault" value="同意退货" onclick="admireOrder('form${status.count}')" /> 
												<input type="button" name="admire" value="撤销退货" onclick="faultOrder('form${status.count}')" />
	
					</c:when>									
												
	<c:when test="${order.orderStatus=='can not refund'}"> 			</c:when>	
	<c:when test="${order.orderStatus=='success refund'}"> 			</c:when>							
<c:otherwise>
												<input type="submit" name="send" value="运送中" onclick="sendOrder('form${status.count}')" /> 
												<input type="button" name="arrive" value="送达" onclick="arriveOrder('form${status.count}')" />
												

</c:otherwise>	</c:choose>											
											</div>
										</div>
						</form>
					</c:forEach>
</body>
</html>