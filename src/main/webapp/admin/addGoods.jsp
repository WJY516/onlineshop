<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css"/>
<link rel="stylesheet" href="assets/css/admin.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/app.js"></script>
</head>
<body>
<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->






</head>

<body>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand"><img src="assets/i/logo.png"></div>

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

 <li class="kuanjie">
 	
 	<a href="#">会员管理</a>          
 	<a href="#">奖金管理</a> 
 	<a href="#">订单管理</a>   
 	<a href="#">产品管理</a> 
 	<a href="#">个人中心</a> 
 	 <a href="#">系统设置</a>
 </li>

 <li class="soso">
 	
<p>   
	
	<select data-am-selected="{btnWidth: 70, btnSize: 'sm', btnStyle: 'default'}">
          <option value="b">全部</option>
          <option value="o">产品</option>
          <option value="o">会员</option>
          
        </select>

</p>

<p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="圆角表单域" /></p>
<p><button class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p>
 </li>




      <li class="am-hide-sm-only" style="float: right;"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>
<jsp:include page="../admin/left.jsp"></jsp:include>

<div class=" admin-content">
	
		<div class="daohang">
			<ul>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs"> 首页 </li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">帮助中心<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">奖金管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">产品管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
				
				
			</ul>

       

	
</div>
	
	


<div class="admin-biaogelist">
	
    <div class="listbiaoti am-cf">
      <ul class="am-icon-flag on"> 增加商品</ul>
      
      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">商品列表</a></dl>

      
      
    </div>
	
    <div class="fbneirong">
      <!-- <form class="am-form" method="post" action="../admin/addgoods"> -->
      <form class="am-form" id="add_form">
        <div class="am-form-group am-cf">
          <div class="zuo">商品名：</div>
          <div class="you">
            <input type="text" class="am-input-sm" id="goodsName" placeholder="请输入商品名" name="goodsName" value="${TbGoods.goodsName}">
          </div>
        </div>
        <div class="am-form-group am-cf">
          <div class="zuo">品牌：</div>
          <div class="you">
            <input type="text" class="am-input-sm" id="brandName" placeholder="请输入品牌名" name="brandName" value="${TbBrand.brandName }">
          </div>
        </div>
        <div class="am-form-group am-cf">
          <div class="zuo">商品描述：</div>
          <div class="you">
            <textarea class="am-form-group am-cf" rows="2" id="goodsDiscribes" name="goodsDiscribes" value="${TbGoods.goodsDiscribes}"></textarea>
          </div>
        </div>
        
        <div class="am-form-group am-cf">
          <div class="zuo">商品图片：</div>
          <div class="you" style="height: 45px;">
            <input type="file" id="doc-ipt-file-1">
            <p class="am-form-help">请选择要上传的文件...</p>
          </div>
        </div>
        
        
        <div class="am-form-group am-cf">
          <div class="zuo">商品价格：</div>
          <div class="you">
            <textarea class="am-form-group am-cf" rows="1" id="goodsPrice" name="goodsPrice" value="${TbGoods.goodsPrice}"></textarea>
          </div>
        </div>
        
        <div class="am-form-group am-cf">
          <div class="zuo">商品类型：</div>
          <div class="you">
            <textarea class="am-form-group am-cf" rows="1" id="goodsType" name="goodsType" value="${TbGoods.goodsType}"></textarea>
          </div>
        </div>
        
         <div class="am-form-group am-cf">
          <div class="zuo">商品库存：</div>
          <div class="you">
            <textarea class="am-form-group am-cf" rows="1" id="goodsFreenum" name="goodsFreenum" value="${TbGoods.goodsFreenum}"></textarea>
          </div>
        </div>
        
      
        <div class="am-form-group am-cf">
          <div class="you" style="margin-left: 11%;">
              <input type="button" value="发布" id="save-goods"class="am-btn am-btn-secondary am-radius"></input>
				<script>
   				 $(document).ready(function() {
           		 //表单异步提交
            	$("#save-goods").on("click",function(){
	                $.ajax({ 
	                    type: 'post', 
	                    data: $('#add_form').serialize(), 
	                    url: '../admin/addgoods',
	                    cache:false,  
	                    dataType:'text', 
	                    success: function (data) {
	                        if("fail"!=data){
	                           /* layer.msg('发布成功'); */
	                           alert("发布成功");
	                           location.href="../admin/addGoods.jsp";
	                        }else{
	                           alert("发布失败，商品名重复");
	                        }
	                    }   
	                })
	            })
	            })
            </script>
          </div>
        </div>
      </form>
    </div>

  
 
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
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]--> 

<!--[if (gte IE 9)|!(IE)]><!--> 
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->



</body>
</html>