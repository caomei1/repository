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
   <li class="navCur"><a href="${contextPath}/vip">会员中心</a></li>
   <li><a href="${contextPath}/xuanshang">悬赏榜</a></li>
   <li><a href="${contextPath}/luntan" class="luntan">论坛</a></li>
   <li><a href="${contextPath}/help">帮助</a></li>
   <div class="clears"></div>
  </ul><!--nav/-->
 </div><!--navBox/-->
 <div class="vipBox">
  <div class="vipLeft">
   <h2 class="headImg"><img src="${contextPath}/assets/images/vipImg.jpg" width="183" height="169" /></h2>
   <h3 class="vipName">测试webqin</h3>
   <ul class="buy-nav">
    <li class="buy-nav1"><a href="${contextPath}/vip-sell">卖家中心</a></li>
    <li class="buy-nav2 buy-navCur"><a href="${contextPath}/vip-product">发布产品</a></li>
    <li class="buy-nav3"><a href="${contextPath}/vip-prolist">产品列表</a></li>
    <li class="buy-nav4"><a href="${contextPath}/vip-dingzhi">定制服务</a></li>
    <li class="buy-nav5"><a href="${contextPath}/vip-pingjia">评价留言</a></li>
    <li class="buy-nav6"><a href="${contextPath}/vip-pwd">修改密码</a></li>
    <li class="buy-nav7"><a href="${contextPath}/vip-shou">售后管理</a></li>
   </ul><!--buy-nav/-->
  </div><!--vipLeft/-->
  <div class="vipRight">
   <h2 class="vipTitle">发布产品</h2>
   <form action="${contextPath}/vip-product" method="post" class="vip-pro">
   	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   <table>
    <tr>
     <th><span style="color: red;">*&nbsp;</span>品牌</th>
     <td><input type="text" name="brand"/></td>
    </tr>
    <tr>
     <th><span style="color: red;">*&nbsp;</span>型号</th>
     <td><input type="text" name="model"/></td>
    </tr>
    <tr>
     <th><span style="color: red;">*&nbsp;</span>信息标题</th>
     <td><input type="text" name="title"/></td>
    </tr>
<!--     <tr>
     <th>手机图片</th>
     <td><input type="file" /></td>
    </tr> -->
    <tr>
     <th>智能机</th>
     <td>
      <select name="smartMachine">
       <option>是</option>
       <option>否</option>
      </select>
     </td>
    </tr>
    <tr>
     <th><span style="color: red;">*&nbsp;</span>价格</th>
     <td><input type="text" name="price"/></td>
    </tr>
    <tr>
     <th><span style="color: red;">*&nbsp;</span>商品编号</th>
     <td><input type="text" name="orderNumber"/></td>
    </tr>
    <tr>
     <th><span style="color: red;">*&nbsp;</span>运费</th>
     <td><input type="text" name="freight"/></td>
    </tr>
    <tr>
     <th><span style="color: red;">*&nbsp;</span>机身颜色</th>
     <td><input type="text" name="bodyColor"/></td>
    </tr>
    <tr>
     <th><span style="color: red;">*&nbsp;</span>机身内存</th>
     <td><input type="text" name="memory"/></td>
    </tr>
    <tr>
     <th><span style="color: red;">*&nbsp;</span>库存</th>
     <td><input type="text" name="stock"/></td>
    </tr>
    <tr>
     <th><span style="color: red;">*&nbsp;</span>网络制式</th>
     <td><input type="text" name="networkMode"/></td>
    </tr>
    <tr>
     <th><span style="color: red;">*&nbsp;</span>商家</th>
     <td><input type="text" name="business"/></td>
    </tr>
   </table><!--vip-pro/-->
   <div class="ti-qu">
    <input type="submit" value="提交" />
    <input type="reset" value="取消" />
   </div><!--ti-qu/-->
   </form>
  </div><!--vipRight/-->
  <div class="clears"></div>
 </div><!--vipBox/-->
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="${contextPath}index"><img src="${contextPath}/assets/images/ftlogo.jpg" width="240" height="64" /></a>
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
</body>
</html>
