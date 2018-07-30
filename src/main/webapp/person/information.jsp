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

        <title>个人资料</title>

        <link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
        <link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

        <link href="../css/personal.css" rel="stylesheet" type="text/css">
        <link href="../css/infstyle.css" rel="stylesheet" type="text/css">
        <script src="../AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
        <script src="../AmazeUI-2.4.2/assets/js/amazeui.js" type="text/javascript"></script>
            
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

                    <div class="user-info">
                        <!--标题 -->
                        <div class="am-cf am-padding">
                            <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small></div>
                        </div>
                        <hr/>

                        <!--头像 -->
                        <div class="user-infoPic">

                            <div class="filePic">
                                <input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*">
                                <img class="am-circle am-img-thumbnail" src="../images/getAvatar.do.jpg" alt="" />
                            </div>

                            <p class="am-form-help">头像</p>

                            <div class="info-m">
                                <div><b>用户名：<i>${username }</i></b></div>
                                <div class="u-level">
                                    <span class="rank r2">
                                         <s class="vip1"></s><a class="classes" href="#">铜牌会员</a>
                                    </span>
                                </div>
                                <div class="u-safety">
                                    <a href="safety.html">
                                     账户安全
                                    <span class="u-profile"><i class="bc_ee0000" style="width: 60px;" width="0">60分</i></span>
                                    </a>
                                </div>
                            </div>
                        </div>

                        <!--个人信息 -->
                        <div class="info-main">
                            <form class="am-form am-form-horizontal" action="update" method="post">

                                <div class="am-form-group">
                                    <label for="user-name2" class="am-form-label">昵称</label>
                                    <div class="am-form-content">
                                        <input type="text" id="user-name2" placeholder="nickname" value="${member.truename}" name="truename">

                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-phone" class="am-form-label">电话</label>
                                    <div class="am-form-content">
                                        <input id="user-phone" placeholder="telephonenumber" type="tel" value="${member.tel}" name="tel">

                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-form-label">电子邮件</label>
                                    <div class="am-form-content">
                                        <input id="user-email" placeholder="Email" type="email" value="${member.email}" name="email">

                                    </div>
                                </div>
                                <div class="am-form-group address">
                                    <label for="user-address" class="am-form-label">收货地址</label>
                                    <div class="am-form-content address">
                                        <a href="address.html">
                                            <p class="new-mu_l2cw">
                                                <span class="province">湖北</span>省
                                                <span class="city">武汉</span>市
                                                <span class="dist">洪山</span>区
                                                <span class="street">雄楚大道666号(中南财经政法大学)</span>
                                                <span class="am-icon-angle-right"></span>
                                            </p>
                                        </a>

                                    </div>
                                </div>
                                <div class="am-form-group safety">
                                    <label for="user-safety" class="am-form-label">账号安全</label>
                                    <div class="am-form-content safety">
                                        <a href="safety.html">

                                            <span class="am-icon-angle-right"></span>

                                        </a>

                                    </div>
                                </div>
                                <div class="info-btn">
                                    <input class="am-btn am-btn-danger" type="submit" value="保存修改"/>
                                </div>

                            </form>
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

            <aside class="menu">
                <ul>
                    <li class="person">
                        <a href="index.html">个人中心</a>
                    </li>
                    <li class="person">
                        <a href="#">个人资料</a>
                        <ul>
                            <li class="active"> <a href="information.html">个人信息</a></li>
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
