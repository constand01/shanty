<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>订单</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body>
<%@ include file="header.jsp"  %>


<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="#" class="fl">首页</a><span>/</span><a
            href="mygxin.jsp">个人中心</a><span>/</span><a href="myorderselect?id=${name.user_id }" class="on">我的订单</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.png"/></a>
             
                <p class="clearfix"><span class="fl">${name.user_name }</span><span class="fr">[退出登录]</span></p></h3>
            <div><h4>我的交易</h4>
                <ul>
                    <li><a href="showcart">我的购物车</a></li>
                    <li><a href="myorderselect?id=${name.user_id }">我的订单</a></li>
                     <li><a href="usersaleadd.jsp?id=${name.user_id }">提交商品</a></li>
                  
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li><a href="mygxin.jsp">我的中心</a></li>
                  
                </ul>
               
            </div>
        </div>
        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">我的订单</h2><a href="#" class="fl">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a href="#2">全部有效订单</a></li>
                    <li><a href="#2">待支付</a></li>
                    <li><a href="#2l">待收货</a></li>
                    <li><a href="#2">已关闭</a></li>
                </ul>
              
            </div>
            
            <c:forEach var="rs" items="${requestScope.orderlist }">
            
            <div class="dkuang"><p class="one"><c:if test="${rs.order_u_status==0 }">未收货</c:if></p>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                       
                        <li>${id }</li>
                        <li>订单号:${rs.order_id }</li>
                        <li>在线支付</li>
                    </ul>
                    <p class="fr">订单金额：<span>${rs.order_totprice }</span>元</p></div>
                    
                    
                    <c:forEach var="irs" items="${requestScope.ilist }">
               
                         <c:if test="${rs.order_id==irs.item_o_id}">
                   
                         
                     <div class="shohou clearfix"><a href="#" class="fl"><img width="69" height="69" src="image/product/${irs.item_p_filename}"/></a>
                        
                                 <p class="fl"><a href="#">${irs.item_p_name }</a><a href="#">${irs.item_p_price }×${irs.item_p_number }</a></p>
                                </div>
                    
                    
                    
                            </c:if>
                       </c:forEach>
                    
                    </div>
            
            
            </c:forEach>
            
            
            
            
           
            
               
            <div class="fenye clearfix"><a href="#"><img src="img/zuo.jpg"/></a><a href="#">1</a><a href="#"><img
                    src="img/you.jpg"/></a></div>
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="cart.html">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.html">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            
        </div>
    </div>
    </div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>