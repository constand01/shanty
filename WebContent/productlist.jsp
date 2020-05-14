<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>${title }</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@ include file="header.jsp"  %>
<div class="banner"><a href="#"><img src="img/temp/shopview.jpg"/></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix"><a href="indexselect">首页</a><span>/</span><a href="#" class="on">${title }</a></div>
</div><!-------------------current---------------------->
<div class="current">
    <div class="wrapper clearfix"><h3 class="fl">${title }</h3>
       
    </div>
</div><!----------------proList------------------------->
<ul class="proList wrapper clearfix">

  <c:forEach var="p" items="${list }">

    <li><a href="selectproductview?id=${p.product_id }">
        <dl>
            <dt><img src="image/product/${p.product_filename }"></dt>
            <dd>${p.product_name }</dd>
            <dd>￥${p.product_price }.00</dd>
        </dl>
    </a></li>
    </c:forEach>
    
    <c:forEach var="pl" items="${plist }">
            <a href="selectproductview?id=${pl.product_id }">
            <dl>
            <dt><img src="image/product/${pl.product_filename }"  width="268" height="268"></dt>
            <dd>${pl.product_name }</dd>
            <dd>￥${pl.product_price }.00</dd>
        </dl>
    </a></li>
    </c:forEach>
    
  
</ul><!----------------mask------------------->
<div class="mask"></div><!-------------------mask内容------------------->

<div class="gotop"><a href="cart.jsp">
    <dl class="goCart">
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
        <span>1</span></dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.jsp">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div>
<div class="msk"></div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
           
        </div>
    </div>
    </div>
<script src="/SecondHand/WebContent/js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/SecondHand/WebContent/js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="/SecondHand/WebContent/js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="/SecondHand/WebContent/js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="/SecondHand/WebContent/js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>