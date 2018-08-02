<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>购物车页面</title>

		<link href="/onlineshop/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="/onlineshop/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="/onlineshop/css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="/onlineshop/css/optstyle.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript" src="../basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="../basic/js/quick_links.js"></script>

		<script type="text/javascript" src="../js/list.js"></script>
		<script type="text/javascript">
			function _getCheckedBtn(){
				var checkboxs = document.getElementsByName("items");
				var goodsid = new Array();
				var count = 0;
				for(var i=0; i<checkboxs.length; i++){
					if(checkboxs[i].checked==true){
						goodsid[count] = parseInt(checkboxs[i].value);
						count++;
					}
				}
				return goodsid;
			}
			function add(goodsid, nowgoodsnumber){
			    var temp = document.createElement("form");
			    temp.action = "/onlineshop/cart/update";
			    temp.method = "post";
			    temp.style.display = "none";
				
			    var opt1 = document.createElement("textarea");
			    opt1.name = "goodsid";
			    opt1.value = goodsid;
			    temp.appendChild(opt1);
	
			    var opt2 = document.createElement("textarea");
			    opt2.name = "goodsnumber";
			    opt2.value = parseInt(nowgoodsnumber)+1;
			    temp.appendChild(opt2);
			
			    document.body.appendChild(temp);
			    temp.submit();
			    return temp;
			}
			function sub(goodsid, nowgoodsnumber) {
			    var temp = document.createElement("form");
			    temp.action = "/onlineshop/cart/update";
			    temp.method = "post";
			    temp.style.display = "none";
				
			    var opt1 = document.createElement("textarea");
			    opt1.name = "goodsid";
			    opt1.value = goodsid;
			    temp.appendChild(opt1);
	
			    var opt2 = document.createElement("textarea");
			    opt2.name = "goodsnumber";
			    opt2.value = parseInt(nowgoodsnumber)-1;
			    temp.appendChild(opt2);
			
			    document.body.appendChild(temp);
			    temp.submit();
			    return temp;
			}
			function del(agoodsid){
				var temp = document.createElement("form");
				temp.action = "/onlineshop/cart/delete";
				temp.method = "post";
				temp.style.display = "none";
				
				var goodsid = new Array();
				goodsid[0] = agoodsid;
				var opt = document.createElement("textarea");
				opt.name = "goodsid";
				opt.value = goodsid;
				temp.appendChild(opt);
			
			    document.body.appendChild(temp);
			    temp.submit();
			    return temp;
			}
			function account(){
				alert("11");
			    var temp = document.createElement("form");
			    temp.action = "/onlineshop/cart/account";
			    temp.method = "post";
			    temp.style.display = "none";
			    
			    var goodsid = _getCheckedBtn();
				if(goodsid===undefined || goodsid.length==0){
					return;
				}
				
			    var opt1 = document.createElement("input");
			    opt1.name = "goodsid";
			    opt1.value = goodsid;
			    temp.appendChild(opt1);
			
			    document.body.appendChild(temp);
			    temp.submit();
			    return temp;
			}
			function _countNumberAndTotal(){
				var number = 0;
				var total = 0;
				var delname = "J_CheckBox_";
				var checkboxs = document.getElementsByName("items");
				for(var i=0; i<checkboxs.length; i++){
					if(checkboxs[i].checked==true){
						number++;
						btnid = checkboxs[i].id;
						priceid = "price_"+btnid.slice(delname.length);
						numberid = "number_"+btnid.slice(delname.length);
						price = document.getElementById(priceid).innerText;
						number = document.getElementById(numberid).value;
						total += parseInt(price)*parseInt(number);
					}
				}
				var textNumber = document.getElementById("J_SelectedItemsCount");
				textNumber.innerText = number;
				var textTotal = document.getElementById("J_Total");
				textTotal.innerText = total;
			}
			function allfocus(){
				var flag = document.getElementById("J_SelectAllCbx").checked;
				var checkboxs = document.getElementsByName("items");
				for(var i=0; i<checkboxs.length; i++){
					if(checkboxs[i].checked!=flag){
						checkboxs[i].checked = flag;
					}
				}
				_countNumberAndTotal();
			}
			
			function aselect(){
				var checkboxs = document.getElementsByName("items");
				var checknumber = checkboxs.length;
				var count = 0;
				for(var i=0; i<checknumber; i++){
					if(checkboxs[i].checked==true){
						count++;
					}
				}
				var thatbtn = document.getElementById("J_SelectAllCbx");
				thatbtn.checked = (count==checknumber)?true:false;
				_countNumberAndTotal();
			}
			function delany(){
				var temp = document.createElement("form");
				temp.action = "/onlineshop/cart/delete";
				temp.method = "post";
				temp.style.display = "none";
				var goodsid = _getCheckedBtn();
				alert(goodsid + " " + typeof goodsid);
				if(goodsid===undefined || goodsid.length==0){
					return;
				}
				alert(goodsid[0]+" "+typeof goodsid[0]);
				
				var opt1 = document.createElement("textarea");
			    opt1.name = "goodsid";
			    opt1.value = goodsid;
			    temp.appendChild(opt1);
			
			    document.body.appendChild(temp);
			    temp.submit();
			    return temp;
			}
			function subscribeany(){
				var temp = document.createElement("form");
				temp.action = "/onlineshop/subscribe/insertAnySubscribe";
				temp.method = "get";
				temp.style.display = "none";
				
				var goodsId = _getCheckedBtn();
				if(goodsId===undefined || goodsId.length==0){
					return;
				}
				
				alert(typeof goodsId[0] + " " + goodsId[0]);
				alert(typeof goodsId[1] + " " + goodsId[1]);
				var opt1 = document.createElement("input");
			    opt1.name = "goodsId";
			    opt1.value = goodsId;
			    temp.appendChild(opt1);
			
			    document.body.appendChild(temp);
			    temp.submit();
			    return temp;
			}
	</script>

	</head>

	<body>

		<jsp:include page="/home/top.jsp"></jsp:include> 

			<div class="clear"></div>

			<!--购物车 -->
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">
								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">金额</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					
					
					
					<div>
					<c:forEach  items="${goodscart.date}"  var="agoods" varStatus="id">
						<tr class="item-list">
							<div class="bundle  bundle-last ">

								<div class="bundle-hd">
									<div class="bd-promos">
										<div class="bd-has-promo">已享优惠:<span class="bd-has-promo-content">省￥19.50</span>&nbsp;&nbsp;</div>
										<div class="act-promo">
											<a href="#" target="_blank">第二支半价，第三支免费<span class="gt">&gt;&gt;</span></a>
										</div>
										<span class="list-change theme-login">编辑</span>
									</div>
								</div>
								<div class="clear"></div>

								<div class="bundle-main">
								<!-- 可以用mv的商品数据 -->
									<ul class="item-content clearfix">
										<!-- *按钮没有处理， 不是唯一的-->
										<li class="td td-chk">
											<div class="cart-checkbox ">
												<input class="acheck" id="J_CheckBox_${id.index}" name="items" value="${agoods.goods.goodsId}" type="checkbox" onclick="aselect.call(this)"/>
												<label for="J_CheckBox_${id.index}"></label>
											</div>
										</li>
										<!-- *图片来源没有处理-->
										<li class="td td-item">
											<div class="item-pic">
												<a href="/onlineshop/Goods/introduction?goodsId=${agoods.goods.goodsId}" target="_blank" data-title="${agoods.goods.goodsName}" class="J_MakePoint" data-point="tbcart.8.12">
													<img src="/onlineshop/images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg"></a>
											</div>
											<div class="item-info">
												<div class="item-basic-info">
													<a href="/onlineshop/Goods/introduction?goodsId=${agoods.goods.goodsId}" target="_blank" title="${agoods.goods.goodsName}" class="item-title J_MakePoint" data-point="tbcart.8.11">${agoods.goods.goodsName}</a>
												</div>
											</div>
										</li>
										<!-- *类型没有修改-->
										<li class="td td-info">
											<div class="item-props item-props-can">
												<span class="sku-line">${agoods.brand.type1}</span>
												<span class="sku-line">${agoods.brand.type2}</span>
												<span tabindex="0" class="btn-edit-sku theme-login">修改</span>
												<i class="theme-login am-icon-sort-desc"></i>
											</div>
										</li>
										<!-- *没有优惠，所以没有price-now-->
										<li class="td td-price">
											<div class="item-price price-promo-promo">
												<div class="price-content">
													<div class="price-line">
														<em class="price-original">${agoods.goods.goodsPrice}</em>
													</div>
													<div class="price-line">
														<em class="J_Price price-now" id="price_${id.index}" tabindex="0">${agoods.goods.goodsPrice}</em>
													</div>
												</div>
											</div>
										</li>
										<!-- ?数量 : onclick时需要阻塞这里吗-->
										<li class="td td-amount">
											<div class="amount-wrapper ">
												<div class="item-amount ">
													<div class="sl">
														<input class="min am-btn" 
																name="" 
																type="button" 
																value="-"
																onclick="sub('${agoods.goods.goodsId}', '${agoods.goods.goodsFreenum}')" />
														<!--这里要onclick-->
														<input class="text_box text-input" 
																id="number_${id.index}"
																name="goodsnumber" 
																type="text" 
																value="${agoods.goods.goodsFreenum}" 
																style="width:30px;" />
														<input class="add am-btn" 
																name="" 
																type="button" 
																value="+"
																onclick="add('${agoods.goods.goodsId}', '${agoods.goods.goodsFreenum}')" />
													</div>
													<!--在这里加c:if-->
												</div>
											</div>
										</li>
										<!-- 当前总价格-->
										<li class="td td-sum">
											<div class="td-inner">
												<em tabindex="0" class="J_ItemSum number">${agoods.goods.goodsPrice*agoods.goods.goodsFreenum}</em>
											</div>
										</li>
										<!-- *收藏与删除-->
										<li class="td td-op">
											<div class="td-inner">
												<a title="移入收藏夹" class="btn-fav" href="/onlineshop/subscribe/insertSubscribe?goodsId=${agoods.goods.goodsId}"> 移入收藏夹</a>
												<a href="javascript:void(0)" data-point-url="#" class="delete" onclick="del('${agoods.goods.goodsId}');return false;"> 删除</a>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</tr>
						<div class="clear"></div>
					</c:forEach>
					</div>
					
					
					
					
					
				</div>
				<div class="clear"></div>

				<div class="float-bar-wrapper">
					<div id="J_SelectAll2" class="select-all J_SelectAll">
						<div class="cart-checkbox">
							<input class="check-all check" id="J_SelectAllCbx" name="select-all" value="true" type="checkbox"  onclick="allfocus()"/>
							<label for="J_SelectAllCbx"></label>
						</div>
						<span>全选</span>
					</div>
					<div class="operations">
						<a href="javascript:void(0)" hidefocus="true" class="deleteAll" onclick="delany()">删除</a>
						<a href="javascript:void(0)" hidefocus="true" class="J_BatchFav" onclick="subscribeany()">移入收藏夹</a>
					</div>
					<div class="float-bar-right">
						<div class="amount-sum">
							<span class="txt">已选商品</span>
							<em id="J_SelectedItemsCount">0</em><span class="txt">件</span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								<span class="arrow"></span>
							</div>
						</div>
						<div class="price-sum">
							<span class="txt">合计:</span>
							<strong class="price">¥<em id="J_Total">0.00</em></strong>
						</div>
						<div class="btn-area">
							<a href="javascript:void(0)" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算" onclick="account()"/>
								<span>结&nbsp;算</span></a>
						</div>
					</div>

				</div>

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

			<!--操作页面-->

			<div class="theme-popover-mask"></div>

			<div class="theme-popover">
				<div class="theme-span"></div>
				<div class="theme-poptit h-title">
					<a href="javascript:;" title="关闭" class="close">×</a>
				</div>
				<div class="theme-popbod dform">
					<form class="theme-signin" name="loginform" action="" method="post">

						<div class="theme-signin-left">

							<li class="theme-options">
								<div class="cart-title">颜色：</div>
								<ul>
									<li class="sku-line selected">12#川南玛瑙<i></i></li>
									<li class="sku-line">10#蜜橘色+17#樱花粉<i></i></li>
								</ul>
							</li>
							<li class="theme-options">
								<div class="cart-title">包装：</div>
								<ul>
									<li class="sku-line selected">包装：裸装<i></i></li>
									<li class="sku-line">两支手袋装（送彩带）<i></i></li>
								</ul>
							</li>
							<div class="theme-options">
								<div class="cart-title number">数量</div>
								<dd>
									<input class="min am-btn am-btn-default" name="" type="button" value="-" />
									<input class="text_box" name="" type="text" value="1" style="width:30px;" />
									<input class="add am-btn am-btn-default" name="" type="button" value="+" />
									<span  class="tb-hidden">库存<span class="stock">1000</span>件</span>
								</dd>

							</div>
							<div class="clear"></div>
							<div class="btn-op">
								<div class="btn am-btn am-btn-warning">确认</div>
								<div class="btn close am-btn am-btn-warning">取消</div>
							</div>

						</div>
						<div class="theme-signin-right">
							<div class="img-info">
								<img src="/onlineshop/images/kouhong.jpg_80x80.jpg" />
							</div>
							<div class="text-info">
								<span class="J_Price price-now">¥39.00</span>
								<span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
							</div>
						</div>

					</form>
				</div>
			</div>
		<!--引导 -->
		<div class="navCir">
			<li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li class="active"><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="../person/information.jsp"><i class="am-icon-user"></i>我的</a></li>					
		</div>
	</body>

</html>