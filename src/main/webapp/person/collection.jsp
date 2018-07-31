<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Enumeration<String> names=session.getAttributeNames();
System.out.println("session names");
for (;names.hasMoreElements();){
System.out.println("--"+names.nextElement());
}
names=request.getAttributeNames();
System.out.println("request names");
for (;names.hasMoreElements();){
System.out.println("--"+names.nextElement());
}
--%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

        <title>我的收藏</title>

        <link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
        <link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

        <link href="../css/personal.css" rel="stylesheet" type="text/css">
        <link href="../css/colstyle.css" rel="stylesheet" type="text/css">

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
            <div class="col-main">
                <div class="main-wrap">

                    <div class="user-collection">
                        <!--标题 -->
                        <div class="am-cf am-padding">
                            <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">我的收藏</strong> / <small>My&nbsp;Collection</small></div>
                        </div>
                        <hr/>

                        <div class="you-like">
                            <div class="s-bar">
                                我的收藏
                                <a class="am-badge am-badge-danger am-round">降价</a>
                                <a class="am-badge am-badge-danger am-round">下架</a>
                            </div>
                            <div class="s-content">
<!--需要商品列表goodsList                             .. -->
                            <c:forEach items="${goodsList}" var="goods" varStatus="status">                         
                                <div class="s-item-wrap">
                                    <div class="s-item">

                                        <div class="s-pic">
                                            <a href="#" class="s-pic-link">
                                                <img src="../images/-0-saturn_solar.jpg_220x220.jpg" alt="${goods.goodsName}" title="${goods.goodsName}" class="s-pic-img s-guess-item-img">
<!--                                             <span class="tip-title">已下架</span> -->
                                            </a>
                                        </div>
                                        <div class="s-info">
                                            <div class="s-title"><a href="#" title="${goods.goodsDiscribes}">${goods.goodsName}</a></div>
                                            <div class="s-price-box">
                                                <span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">${goods.goodsPrice}</em></span>
                                                <span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">1888.00</em></span>
                                            </div>
                                            <div class="s-extra-box">
                                                <span class="s-comment">好评: 99.93%</span>
                                                <span class="s-sales">月销: 278</span>
                                            </div>
                                        </div>
                                        <div class="s-tp">
                                            <a href="deleteSubscribe?goodsId=${goods.goodsId }" class="ui-btn-loading-before">取消收藏</a>
                                            <i class="am-icon-trash"></i>
                                            <span class="ui-btn-loading-before buy">进入店铺</span>
                                            
                                                
                                            
                                        </div>
                                    </div>
                                </div>

                            </c:forEach> 
                            </div>

                            <div class="s-more-btn i-load-more-item" data-screen="0"><i class="am-icon-refresh am-icon-fw"></i>更多</div>

                        </div>

                    </div>

                </div>
                <!--底部-->
                <div class="footer">
                    <div class="footer-hd">
                        <p>
                            <a href="#">恒望科技</a>
                            <b>|</b>
                            <a href="#">商城首页</a>
                            <b>|</b>
                            <a href="#">支付宝</a>
                            <b>|</b>
                            <a href="#">物流</a>
                        </p>
                    </div>
                    <div class="footer-bd">
                        <p>
                            <a href="#">关于恒望</a>
                            <a href="#">合作伙伴</a>
                            <a href="#">联系我们</a>
                            <a href="#">网站地图</a>
                            <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
                        </p>
                    </div>
                </div>
            </div>

           <jsp:include page="left.jsp"></jsp:include>
        </div>

    </body>

</html>
