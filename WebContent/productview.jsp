<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>详情页</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@ include file="header.jsp" %>
</div><!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
    <a href="indexselect">首页</a><span>/</span>
    <a href="selectproductlist?cid=${cate.cate_id }">${cate.cate_name }</a><span>/</span>
    <a href="#"  class="on">${p.product_name }</a>
    </div>
</div><!-----------------------Detail------------------------------>
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl"><img class="det" src="image/product/${p.product_filename }"/>
                <div class="smallImg clearfix"><img src="image/product/${p.product_filename }"
                                                    data-src="image/product/${p.product_filename }"></div>
            </div>
            <div class="fr intro">
                <div class="title"><h4>${p.product_name }</h4>
                    <p>【${p.product_description }】</p><span>￥${p.product_price }.00</span></div>
                <div class="proIntro"><p>颜色分类</p>
                    <div class="smallImg clearfix categ"><p class="fl"><img src="image/product/${p.product_filename }"
                                                                            alt="${p.product_description }"
                                                                            data-src="image/product/${p.product_filename }"></p>
                        </div>
                    <p>数量&nbsp;&nbsp;库存<span>${p.product_stock }</span>件</p>
                    <div class="num clearfix">
                    <img class="fl sub" src="img/temp/sub.jpg">
                    <span id="count" class="fl"  contentEditable="true">1</span>
                    <img class="fl add" src="img/temp/add.jpg">
                        <p class="please fl">请选择商品属性!</p></div>
                </div>
                <div class="btns clearfix">
                <a href="javascript:shopadd(${p.product_id },'z')"><p class="buy fl">立即购买</p></a>
                <a href="javascript:shopadd1(${p.product_id },'s')"><p class="cart fr">   加入购物车</p></a></div>
            </div>
        </div>
    </div>
</div>

<script>
       function shopadd(id,url){
    	   var count= document.getElementById("count").innerHTML;
    	   location.href='cartadd?id='+id+'&count='+count+'&url='+url;
       }
       function shopadd1(id,url){
    	   var count= document.getElementById("count").innerHTML;
    	   alert("添加购物车成功");
    	   location.href='cartadd?id='+id+'&count='+count+'&url='+url;
       }

</script>


<div class="gotop"><a href="showcart">
    <dl class="goCart">
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
        <span>1</span></dl>
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
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>