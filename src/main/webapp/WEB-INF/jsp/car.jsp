<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>unique</title>
<link type="text/css" href="${contextPath}/assets/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="${contextPath}/assets/js/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${contextPath}/assets/js/js.js"></script>
<script type="text/javascript" src="${contextPath}/assets/js/items.js"></script>

</head>
<body>

 <div class="hrader" id="header">
  <div class="top">
  <%@ include file="header.jspf" %>
   <a href="${contextPath}/login" style="color:#C94E13;">请登录</a> 
   <a href="${contextPath}/reg">注册</a>
   <ul class="topNav">
    <li class="gouwuche"><a href="${contextPath}/car">购物车</a> <strong style="color:#C94E13;">3</strong></li>
    <li class="shoucangjia"><a href="${contextPath}/shoucang">收藏夹</a></li>
    <li class="kefus"><a href="#">联系客服</a></li>
<li><a href="#" class="lan">中文</a></li>
    <li><a href="#" class="lan">English</a></li>
    <div class="clears"></div>
   </ul><!--topNav/-->
  </div><!--top/-->
 </div><!--hrader/-->
 <div class="mid">
  <h1 class="logo" style="text-align:left;">
  <a href="${contextPath}/index"><img src="${contextPath}/assets/images/logo.png" width="304" height="74" /></a>
  </h1>
  <form action="#" method="get" class="subBox">
   <div class="subBox2">
    <input type="text" class="subText" />
    <input type="image" src="${contextPath}/assets/images/sub.jpg" width="95" height="32" class="subImg" />
    <div class="hotci">
    <a href="#">酷派大神</a>	
    <a href="#">三星s5</a>
    <a href="#">诺基亚1020</a>
    <a href="#">Iphone 6</a>
    <a href="#">htc one</a>
   </div><!--hotci/-->
   </div><!--subBox2/-->
  </form><!--subBox/-->
  <div class="ding-gou">
   <div class="ding">
    <a href="${contextPath}/vipOrder"><img src="${contextPath}/assets/images/dingdan.jpg" width="106" height="32" /></a>
   </div><!--ding/-->
   <div class="gou">
    <a href="${contextPath}/car"><img src="${contextPath}/assets/images/gouwuche.jpg" width="126" height="32" /></a>
   </div><!--gou/-->
   <div class="clears"></div>
  </div><!--ding-gou/-->
 </div><!--mid-->
 <div class="navBox navBg3">
  <ul class="nav">
   <li><a href="${contextPath}/index">首页</a></li>
   <li><a href="${contextPath}/buy">买家</a></li>
   <li><a href="${contextPath}/sell">卖家</a></li>
   <li><a href="${contextPath}/vip">会员中心</a></li>
   <li><a href="${contextPath}/xuanshang">悬赏榜</a></li>
   <li><a href="${contextPath}/luntan" class="luntan">论坛</a></li>
   <li class="navCur"><a href="${contextPath}/help">帮助</a></li>
   <div class="clears"></div>
  </ul><!--nav/-->
 </div><!--navBox/-->
 <div class="address">
   <form action="${contextPath}/car" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="addList">
     <label style="width: 18%"><span class="red">* </span>选择地区:</label>
     <select name="whereCity">
      <option>请选择省</option>
      <option>湖南</option>
     </select>
     <select name="whereCity">
      <option>请选择市</option>
      <option>长沙</option>
     </select>
     <select name="whereCity">
      <option>请选择地区</option>
      <option>开福</option>
     </select>
    </div><!--addList-->
    <div class="addList">
     <label style="width: 18%"><span class="red">* </span>详细地址:</label>
     <input type="text" name="streetAddress"/>
    </div><!--addList-->
    <div class="addList">
     <label style="width: 18%"><span class="red">* </span>邮政编码:</label>
     <input type="text" name="postalCode"/>
    </div><!--addList-->
    <div class="addList">
     <label style="width: 18%"><span class="red">* </span>收件人:</label>
     <input type="text" name="consignee"/>
    </div><!--addList-->
    <div class="addList">
     <label style="width: 18%"><span class="red">* </span>电话号码:</label>
     <input type="text" name="phoneNumber"/>
    </div><!--addList--> 
    <div class="addList2" style="margin-left:180px;">
     <input name="" value=" 确 认 " type="submit" class="submit" />
     <input type="reset" value="取消" />
    </div><!--addList2/-->
    </form>
   </div><!--address/-->
 <form action="${contextPath}/success" method="post" id="Immediate-settlement">
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 <div class="car">
  <div class="cont">
   <div class="carImg"><img src="${contextPath}/assets/images/car1.jpg" width="951" height="27" /></div>
   <h4 class="orderTitle" style="font-size: 15px">收货地址&nbsp;<span class="green add">【新增地址】</span></h4>
   <table class="ord">
   <c:forEach items="${address}" var="Address">
    <tr>
     <td width="33%">
      <input type="radio" name="addressId" value="${Address.id}" /> ${Address.consignee}
     </td>
     <td width="54%">
      ${Address.whereCity}, ${Address.streetAddress}, ${Address.postalCode}, ${Address.phoneNumber}
     </td>
     <td>
      <a href="${contextPath}/vipAddress/${Address.id}/updateVipAddress"><span class="green upd">[修改]</span></a>
     </td>
    </tr>
    </c:forEach>
   </table><!--ord/-->
   <table class="orderList">
    <tr>
     <th width="20"><input type="checkbox" name="checkall" onclick="checkAll(checkall)"/></th>
     <th width="450">商品</th>
     <th width="130">单价</th>
     <th width="130">数量</th>
     <th width="130">总金额</th>
     <th width="105">操作</th>
    </tr>
   <c:forEach items="${products}" var="pro">
    <tr>
     <td> </td>
     <td colspan="5" style="text-align:left;color:#930; font-weight:bold;">
      <img src="${contextPath}/assets/images/dianpu.gif" width="20" height="15" style="position:relative;top:2px;" />
      店铺：${pro.product.business}
     </td>
    </tr>
    <tr>
     <td><input type="checkbox" name="productId" value="${pro.product.id}"/></td>
     <td>
      <dl>
       <dt><a href="${contextPath}/proinfo"><img src="${contextPath}/assets/images/phone.png" width="85" height="85" /></a></dt>
       <dd style="font-weight: bolder;">${pro.product.brand} ${pro.product.model} ${pro.product.bodyColor}<br/><br/><span class="red">库存：</span>${pro.product.stock}</dd>
       <div class="clears"></div>
      </dl>
     </td>
     <td><strong class="red">￥${pro.product.price}</strong></td>
     <td>
     <div class="jia_jian" style="margin-left: 18px">
     	<input class="min1" name="${pro.id}" type="button" value="&#8211"/> 
		<input class="text_box" name="${pro.id}" type="text" value="${pro.quantity}" style="width:30px;text-align: center"/> 
		<input class="add1" name="${pro.id}" type="button" value="+"/> 
     </div>
     </td>
     <td><strong class="red">￥${pro.product.price*pro.quantity}</strong></td>
     <td><a href="#" class="green">收藏</a><br /><a href="${contextPath}/delete/${pro.id}" class="green">删除</a></td>
    </tr>
    <c:set var="totalPrice" value="${totalPrice+ pro.product.price*pro.quantity}"></c:set>
    </c:forEach>
   </table><!--orderList/--><br/>
   <div class="shanchu"><img src="${contextPath}/assets/images/lajio.jpg" />
    	<a href="#" class="green" id="batch-delete-btn">批量删除</a>
    </div>
    
   <div class="zongji">
    <strong>所需运费：</strong>￥0.00&nbsp;&nbsp;
    <strong>总计(不含运费)：</strong><strong class="red">￥${totalPrice}</strong>
   </div><!--zongji/-->
   <div class="jiesuan">
    <a href="${contextPath}/prolist" class="jie_1">继续购物&gt;&gt;</a>
    <input name="" value=" 立即结算&gt;&gt;" type="submit" class="jie_2" id="Immediate-settlement-input"/>
    <div class="clears"></div>
   </div><!--jiesuan/-->
   <div class="clears"></div>
  </div><!--cont/-->
 </div><!--car/-->
 </form>
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="${contextPath}/index"><img src="${contextPath}/assets/images/ftlogo.jpg" width="240" height="64" /></a>
    <h3 class="ftphone">400 000 0000 </h3>
    <div class="ftKe">
     客服 7x24小时(全年无休)<br />
     <span>客服邮箱：kefu@webqin.net </span>
    </div><!--ftKe/-->
   </div><!--footersLeft/-->
   <div class="footersRight">
    <ul>
     <li class="ftTitle">新手指南</li>
     <li><a href="#">购物流程</a></li>
     <li><a href="#">会员计划及划分</a></li>
     <li><a href="#">优惠券规则</a></li>
     <li><a href="#">联系客服</a></li>
     <li><a href="#">常见问题</a></li>
    </ul>
    <ul>
     <li class="ftTitle">付款方式</li>
     <li><a href="#">在线支付</a></li>
     <li><a href="#">礼品卡支付</a></li>
     <li><a href="#">货到付款</a></li>
     <li><a href="#">银行付款</a></li>
    </ul>
    <ul>
     <li class="ftTitle">配送服务</li>
     <li><a href="#">配送时效及运费</a></li>
     <li><a href="#">超时赔付</a></li>
     <li><a href="#">验货与签收</a></li>
     <li><a href="#">配货信息跟踪</a></li>
    </ul>
    <ul>
     <li class="ftTitle">售后服务</li>
     <li><a href="#">退换货政策</a></li>
     <li><a href="#">退换货区域</a></li>
     <li><a href="#">退款时限</a></li>
     <li><a href="#">先行赔付</a></li>
     <li><a href="#">发票说明</a></li>
    </ul>
    <ul>
     <li class="ftTitle">特色服务</li>
     <li><a href="#">礼品卡</a></li>
     <li><a href="#">产品试用</a></li>
     <li><a href="#">花粉中心</a></li>
     <li><a href="#">快速购物</a></li>
     <li><a href="#">推荐好友</a></li>
    </ul>
    
    <div class="clears"></div>
   </div><!--footersRight/-->
   <div class="clears"></div>
  </div><!--footers/-->
 </div><!--footBox/-->
 <div class="footer" style="text-align:left;">
  <a href="#">关于我们</a>
  <a href="#">友情链接</a>
  <a href="#">版权声明</a>
  <a href="#">网站地图</a>
  <br />
  <span>&copy; 2014 Unqezi 使用前必读 沪ICP备 12007626号-1</span>
 </div><!--footer/-->
 
 	<form style="display: none;" 
 		action="batchDelete" method="post" 
 		id="batch-delete-form">
 		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</body>
</html>