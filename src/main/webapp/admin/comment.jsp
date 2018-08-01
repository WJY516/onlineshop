<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<link rel="stylesheet" href="/onlineshop/admin/assets/css/amazeui.min.css"/>
<link rel="stylesheet" href="/onlineshop/admin/assets/css/admin.css">
<script src="/onlineshop/admin/assets/js/jquery.min.js"></script>
<script src="/onlineshop/admin/assets/js/app.js"></script>
</head>
<body>
<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->

</head>

<body>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand"><img src="/onlineshop/admin/assets/i/logo.png"></div>
  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">
      <li class="am-dropdown tognzhi" data-am-dropdown>
        <button class="am-btn am-btn-primary am-dropdown-toggle am-btn-xs am-radius am-icon-bell-o" data-am-dropdown-toggle> 消息管理<span class="am-badge am-badge-danger am-round">6</span></button>
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
      <li class="kuanjie"> <a href="#">会员管理</a> <a href="#">奖金管理</a> <a href="#">订单管理</a> <a href="#">产品管理</a> <a href="#">个人中心</a> <a href="#">系统设置</a> </li>
      <li class="soso">
        <p>
          <select data-am-selected="{btnWidth: 70, btnSize: 'sm', btnStyle: 'default'}">
            <option value="b">全部</option>
            <option value="o">产品</option>
            <option value="o">会员</option>
          </select>
        </p>
        <p class="ycfg">
          <input type="text" class="am-form-field am-input-sm" placeholder="圆角表单域" />
        </p>
        <p>
          <button class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button>
        </p>
      </li>
      <li class="am-hide-sm-only" style="float: right;"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>
<div class="am-cf admin-main">
  <div class="nav-navicon admin-main admin-sidebar">
    <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：清风抚雪</div>
    <div class="sideMenu">
      <h3 class="am-icon-flag"><em></em> <a href="#">商品管理</a></h3>
      <ul>
        <li><a href="">商品列表</a></li>
        <li class="func" dataType='html' dataLink='msn.htm' iconImg='images/msn.gif'>添加新商品</li>
        <li>商品分类</li>
        <li>用户评论</li>
        <li>商品回收站</li>
        <li>库存管理 </li>
      </ul>
      <h3 class="am-icon-cart-plus"><em></em> <a href="#"> 订单管理</a></h3>
      <ul>
        <li>订单列表</li>
        <li>合并订单</li>
        <li>订单打印</li>
        <li>添加订单</li>
        <li>发货单列表</li>
        <li>换货单列表</li>
      </ul>
      <h3 class="am-icon-users"><em></em> <a href="#">会员管理</a></h3>
      <ul>
        <li>会员列表 </li>
        <li>未激活会员</li>
        <li>团队系谱图</li>
        <li>会员推荐图</li>
        <li>推荐列表</li>
      </ul>
      <h3 class="am-icon-volume-up"><em></em> <a href="#">信息通知</a></h3>
      <ul>
        <li>站内消息 /留言 </li>
        <li>短信</li>
        <li>邮件</li>
        <li>微信</li>
        <li>客服</li>
      </ul>
      <h3 class="am-icon-gears"><em></em> <a href="#">系统设置</a></h3>
      <ul>
        <li>数据备份</li>
        <li>邮件/短信管理</li>
        <li>上传/下载</li>
        <li>权限</li>
        <li>网站设置</li>
        <li>第三方支付</li>
        <li>提现 /转账 出入账汇率</li>
        <li>平台设置</li>
        <li>声音文件</li>
      </ul>
    </div>
    <!-- sideMenu End --> 
    
    <script type="text/javascript">
			jQuery(".sideMenu").slide({
				titCell:"h3", //鼠标触发对象
				targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
				effect:"slideDown", //targetCell下拉效果
				delayTime:300 , //效果时间
				triggerTime:150, //鼠标延迟触发时间（默认150）
				defaultPlay:true,//默认是否执行效果（默认true）
				returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
				});
		</script> 
  </div>

    
    
    
    
    <div class="admin-biaogelist">
      <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">
          用户评论
        </ul>
        <dl class="am-icon-home" style="float: right;">
          当前位置： 首页 > <a href="#">用户评论</a>
        </dl>
        <dl>
          <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" data-am-modal="{target: '#my-popup'}"> 给商品添加评论</button>
        </dl>
        <!--data-am-modal="{target: '#my-popup'}" 弹出层 ID  弹出层 190行 开始  271行结束--> 
        
      </div>
      
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
          <thead>
            <tr class="am-success">
              <th class="table-check"><input type="checkbox" /></th>
              <th class="table-id am-text-center">ID</th>
              <th class="table-title">商品ID</th>
              <th class="table-type">商品评论</th>
              <th class="table-author am-hide-sm-only">会员ID</th>
             
              <th width="125px" class="table-set">操作</th>
            </tr>
            
          </thead>
          
          
             <script type="text/javascript">
function deleteAction(){
    document.demo.action="/onlineshop/comment/deletebygoods";
    document.demo.submit();
}
</script>
          <c:forEach items="${selectalllist}"  var = "commentall">
          
          <form action="/onlineshop/comment/deletebygoods">
          <tbody>
            <tr>
              <td><input type="checkbox" /></td>
               <td class="am-hide-sm-only">${commentall.id}</td>
              <td class="am-text-center">${commentall.goodsId}</td>
              <input type="hidden" value="${commentall.username}" name="username">
              <td>${commentall.comment}</td>
              <td>${commentall.username}</td>
              <td class="am-hide-sm-only">访问</td>
              <input type="hidden" value="${commentall.goodsId}" name="goods_id">
              <td><div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                     <input type="submit" value="删除"/>
                  </div>
                </div></td>
            </tr>
            
            </form>

            </c:forEach>
            
            
 

      <div class="foods">
        <ul>
          版权所有@2015. 模板收集自 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> -  More Templates<a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
        </ul>
        <dl>
          <a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
        </dl>
      </div>
    </div>
  </div>
</div>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="/onlineshop/admin/assets/js/polyfill/rem.min.js"></script>
<script src="/onlineshop/admin/assets/js/polyfill/respond.min.js"></script>
<script src="/onlineshop/admin/assets/js/amazeui.legacy.js"></script>
<![endif]--> 

<!--[if (gte IE 9)|!(IE)]><!--> 
<script src="/onlineshop/admin/assets/js/amazeui.min.js"></script> 
<!--<![endif]-->

</body>
</html>