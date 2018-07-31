<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

        <title>修改密码</title>

        <link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
        <link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

        <link href="../css/personal.css" rel="stylesheet" type="text/css">
        <link href="../css/stepstyle.css" rel="stylesheet" type="text/css">

        <script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
        <script src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>
<%
String result = (String)session.getAttribute("resultOfChangePassWord_jsp");
session.removeAttribute("resultOfChangePassWord_jsp");
if(result!=null && result.length()>0){         
%>
        <script type="text/javascript">
        alert("<%=result%>");
        </script>
        ${result}
<%} %>
    </head>

    <body>
        <!--头 -->
        <header>
            <article>
                <div class="mt-logo">
                    <!--顶部导航条 -->
                    <div class="am-container header">
                        <ul class="message-l">
                            <div class="topMessage">
                                <div class="menu-hd">
                                    <a href="#" target="_top" class="h">亲，请登录</a>
                                    <a href="#" target="_top">免费注册</a>
                                </div>
                            </div>
                        </ul>
                        <ul class="message-r">
                            <div class="topMessage home">
                                <div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
                            </div>
                            <div class="topMessage my-shangcheng">
                                <div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
                            </div>
                            <div class="topMessage mini-cart">
                                <div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
                            </div>
                            <div class="topMessage favorite">
                                <div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
                        </ul>
                        </div>

                        <!--悬浮搜索框-->

                        <div class="nav white">
                            <div class="logoBig">
                                <li><img src="../images/logobig.png" /></li>
                            </div>

                            <div class="search-bar pr">
                                <a name="index_none_header_sysc" href="#"></a>
                                <form>
                                    <input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
                                    <input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
                                </form>
                            </div>
                        </div>

                        <div class="clear"></div>
                    </div>
                </div>
            </article>
        </header>
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

                    <div class="am-cf am-padding">
                        <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">修改密码</strong> / <small>Password</small></div>
                    </div>
                    <hr/>
                    <!--进度条-->
                    <div class="m-progress">
                        <div class="m-progress-list">
                            <span class="step-1 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                                <p class="stage-name">重置密码</p>
                            </span>
                            <span class="step-2 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">2<em class="bg"></em></i>
                                <p class="stage-name">完成</p>
                            </span>
                            <span class="u-progress-placeholder"></span>
                        </div>
                        <div class="u-progress-bar total-steps-2">
                            <div class="u-progress-bar-inner"></div>
                        </div>
                    </div>
                    <form class="am-form am-form-horizontal" action="../member/updatePassword" method="post">
                        <div class="am-form-group">
                            <label for="user-old-password" class="am-form-label">原密码</label>
                            <div class="am-form-content">
                                <input type="password" id="user-old-password" placeholder="请输入原登录密码" name="oldPassword">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="user-new-password" class="am-form-label">新密码</label>
                            <div class="am-form-content">
                                <input type="password" id="user-new-password" placeholder="由数字、字母组合" name="newPassword">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="user-confirm-password" class="am-form-label">确认密码</label>
                            <div class="am-form-content">
                                <input type="password" id="user-confirm-password" placeholder="请再次输入上面的密码">
                            </div>
                        </div>
                        <div class="info-btn">
                            <input class="am-btn am-btn-danger" type="submit" value="保存修改">
                        </div>

                    </form>

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

            <aside class="menu">
                <ul>
                    <li class="person">
                        <a href="index.html">个人中心</a>
                    </li>
                    <li class="person">
                        <a href="#">个人资料</a>
                        <ul>
                            <li> <a href="information.html">个人信息</a></li>
                            <li> <a href="safety.html">安全设置</a></li>
                            <li> <a href="address.html">收货地址</a></li>
                        </ul>
                    </li>
                    <li class="person">
                        <a href="#">我的交易</a>
                        <ul>
                            <li><a href="order.html">订单管理</a></li>
                            <li> <a href="change.html">退款售后</a></li>
                        </ul>
                    </li>
                    <li class="person">
                        <a href="#">我的资产</a>
                        <ul>
                            <li> <a href="coupon.html">优惠券 </a></li>
                            <li> <a href="bonus.html">红包</a></li>
                            <li> <a href="bill.html">账单明细</a></li>
                        </ul>
                    </li>

                    <li class="person">
                        <a href="#">我的小窝</a>
                        <ul>
                            <li> <a href="collection.html">收藏</a></li>
                            <li> <a href="foot.html">足迹</a></li>
                            <li> <a href="comment.html">评价</a></li>
                            <li> <a href="news.html">消息</a></li>
                        </ul>
                    </li>

                </ul>

            </aside>
        </div>

    </body>

</html>
