<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>校园二手交易网站后台管理</title>
    <link rel="stylesheet" type="text/css" href="/SecondHand/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/SecondHand/css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="/SecondHand/manager/admin_index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="/SecondHand/manager/admin_index.jsp">首页</a></li>
                <li><a href="/SecondHand/index.jsp" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">管理员:${name.user_name }</a></li>
                <li><a href="#">修改密码</a></li>
                <li><a href="/SecondHand/manager/admin_logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="/SecondHand/manager/admin_douserselcet"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="/SecondHand/manager/admin_cateselect"><i class="icon-font">&#xe005;</i>分类管理</a></li>
                        <li><a href="/SecondHand/manager/admin_productselect"><i class="icon-font">&#xe006;</i>商品管理</a></li>
                        <li><a href="/SecondHand/manager/admin_userproduct"><i class="icon-font">&#xe006;</i>用户出售商品审核</a></li>
                    </ul>
                </li>
               
            </ul>
        </div>
    </div>