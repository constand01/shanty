<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login1.css"/>
</head>
<body><!-------------------login-------------------------->
  <video id="v1" autoplay loop="-1" muted>
              <source src="/SecondHand/video/video.mp4" type="video/mp4"  />
        </video>
<div class="login">
    <form action="login" method="post"><h1></h1>
        <p></p>
        <a href="index.jsp">首页</a>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p><input type="text" name="username" value="" placeholder="昵称/邮箱/手机号"></p>
        <p><input type="text" name="password" value="" placeholder="密码"></p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="reg.jsp">免费注册</a><a href="forget.html">忘记密码？</a></p></form>
</div>
</body>
<script>
  var video= document.getElementById('v1');
   video.playbackRate = 1.0;
</script>
</html>