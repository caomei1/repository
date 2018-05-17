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
    <li><a href="${contextPath}/order">我的订单 </a></li>
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
    <a href="${contextPath}/order"><img src="${contextPath}/assets/images/dingdan.jpg" width="106" height="32" /></a>
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
   <dl class="vipNav">
    <dt class="vip_1 vipCur">买家中心</dt>
     <dd><a href="${contextPath}/vipOrder">我的订单</a></dd>
     <dd><a href="${contextPath}/vipShoucang">收藏关注</a></dd>
    <dt class="vip_2">账户设置</dt>
     <dd class="ddCur"><a href="${contextPath}/vip">个人信息</a></dd>
     <dd><a href="${contextPath}/vipPwd">密码修改</a></dd>
     <dd><a href="${contextPath}/vipAddress">收货地址</a></dd>
  <!--    <dd><a href="vipXiaofei.html">消费记录</a></dd> -->
    <dt class="vip_3">客户服务</dt>
     <dd><a href="${contextPath}/vipQuxiao">取消订单/退货</a></dd>
     
     <dd><a href="${contextPath}/vipTousu">我的投诉</a></dd>
   </dl><!--vipNav/-->
  </div><!--vipLeft/-->
  <div class="vipRight">
   <h2 class="vipTitle">个人中心</h2>
   <form action="" class="${contextPath}/vip" method="post">
   	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <table class="grzx" width="705" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="90"><span>*&nbsp;</span>真实姓名：</td>
          <td width="430"><input value="${vipUser.realName}" name="realName" type="text" class="text inputxt"/></td>
          <td rowspan="8" valign="top"><div id="tx"><img src="${contextPath}/assets/images/vipImg.jpg" /></div>
<!--           <span><input type="file" id="file" name="picture" /></span> -->
          </td>
        </tr>
        <tr>
          <td><span>*&nbsp;</span>所在城市：</td>        
          <td><select>
              <option>${vipUser.city}</option>
            </select><span>&nbsp;( 重新选择 )</span>
            <select name="city">
              <option>省</option>
              <option>湖南</option>
            </select>
            <select name="city">
              <option>市</option>
              <option>长沙</option>
            </select>
            <select name="city">
              <option>区</option>
              <option>开福</option>
              <option>雨花</option>
            </select></td>
        </tr>
        <tr>
          <td>&nbsp;&nbsp;性别：&nbsp;${vipUser.sex}</td>
          <td><input type="radio" name="sex" value="男" id="person" class="pr1"/>
            男　
            <input type="radio" name="sex" value="女" id="company" class="pr1" />
            女 <span>&nbsp;&nbsp;( 重新选择 )</span></td>
        </tr>
        <tr>
          <td>&nbsp;&nbsp;EMAIL:</td>
          <td><input value="${vipUser.email}" type="text" class="text1" name="email" /></td>
        </tr>
        <tr>
          <td>&nbsp;&nbsp;身份证:</td>
          <td><input value="${vipUser.idCard}" name="idCard" type="text" class="text1 inputxt"/></td>
        </tr>
        <tr>
          <td>&nbsp;<span>*&nbsp;</span>类别：</td>
          <td><span style="font-weight: bold;">${vipUser.role} ：</span>  
          	<span style="color: blue;">超</span><span style="color: green;">级</span><span>会</span><span style="color: orange;">员</span></td>
        </tr>
        <tr>
          <td>&nbsp;&nbsp;个人简介：</td>
          <td><textarea tip="请在这里输入您的简介。" class="gray" name="introduce">${vipUser.introduce}</textarea></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><input name="" value="保存资料" type="submit" class="submit" /></td>
        </tr>
      </table>
      </form>
  </div><!--vipRight/-->
  <div class="clears"></div>
 </div><!--vipBox/-->
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="index.html"><img src="${contextPath}/assets/images/ftlogo.jpg" width="240" height="64" /></a>
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