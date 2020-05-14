<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/calendar.js"></script>
    <script src="js/function.js"></script>
    
    <style>
    .reg p .error{
        display:inline-block;
        border:1px solid #ff855a;
        backgroud-color:#ffe8e0;
        height:25px;
        line-height:25px;
        padding:0px 20px;
        margin-left:20px;
            }
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return checkFrom(this)"><h1><a href="index.jsp">首页</a></h1>
        <h1 style="padding:0px;magin:0px;width:450px;font-size:15px;background:#3344AA;text-align:center;line-height:60px;color:#FFFFFF">用户注册</h1>
        <p><input type="text" name="username" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"  placeholder="请输入用户名" ><span ></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"  placeholder="请输入姓名"><span></span></p>
        <p><input type="text" name="password" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请确认密码"><span></span></p>
        <p><input type="text" name="repassword" value=""   onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入确认密码"><span></span></p>
        <p>
        <input style="width:15px;height:15px" type="radio" name="sex" value="T" checked="checked">男
        <input style="width:15px;height:15px" type="radio" name="sex" value="F" >女
       </p>
        <p><input type="text" name="birthday" value="" onfocus="c.show(this)" placeholder="请确认出生日期" autocomplete="off"><span></span></p>
        <p><input type="text" name="email" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入邮箱"><span></span></p>
        <p><input type="text" name="phone" value="" placeholder="请输入手机号码"><span></span></p>
        <p><input type="text" name="address" value="" placeholder="请确认送货地址"><span></span></p>
        <p class="txtL txt"><input height="25" class="code" type="text" name="verycode" onfocus="FocusItem(this)" onblur="CheckItem(this)" value="" placeholder="验证码">
        <img src="getCode" alt="看不清，换一张" onclick="change(this)" ><span></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txt"><a href="login.jsp"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>