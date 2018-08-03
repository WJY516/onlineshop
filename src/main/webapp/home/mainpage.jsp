<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
					<div id="mainpage">
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
																onkeydown="inputupdata.call(this,event)"
																style="width:30px;" />
														<input class="add am-btn" 
																name="" 
																type="button" 
																value="+"
																onclick="add('${agoods.goods.goodsId}', '${agoods.goods.goodsFreenum}')" />
													</div>
													<c:forEach items="${goodscart.state}" var="astate">
														<c:if test="${astate.key == agoods.goods.goodsId}">
															<c:if test="${astate.value eq 'CARD_CART_KUCUNJINZHANG'}">
																<font size="" color="#FF9900">库存紧张</font>	
															</c:if>
															<c:if test="${astate.value eq 'CARD_CART_NUMBERMIN'}">
																<font size="2" color="#FF9900">最少选购1件</font>	
															</c:if>
														</c:if>
													</c:forEach>
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
