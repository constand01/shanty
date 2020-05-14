<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!--/sidebar--> 
<head>
  <meta charset="UTF-8">
 <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/calendar.js"></script>
    <script src="js/function.js"></script>
    
     <link rel="stylesheet" type="text/css" href="/SecondHand/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/SecondHand/css/main.css"/>
   </head>
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a>
           </div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/SecondHand/tosale" method="post" enctype="multipart/form-data" id="myform" name="myform" ">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>商品名称：</th>
                                <td>
                                    <input class="common-text required" id="title"  name="salename" type="text">
                                
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>商品图片：</th>
                                <td>
                                    <input class="common-text required" id="title"  name="salefn" type="file">
                               <span></span>
                                </td>
                            </tr>
                            
                            
                             <tr>
                                <th><i class="require-red">*</i>商品描述：</th>
                                <td>
                                    <input class="common-text required" id="title"  name="saledesc" type="text">
                               <span></span>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>商品库存：</th>
                                <td>
                                    <input class="common-text required" id="title"  name="salenumber" type="text">
                               <span></span>
                                </td>
                            </tr>
                             
                             <tr>
                                <th><i class="require-red">*</i>商品价格：</th>
                                <td>
                                    <input class="common-text required" id="title"  name="salep" type="text">
                               <span></span>
                                </td>
                            </tr>
                            
                            
                             <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>



    </div>
    <!--/main-->
</div>
</body>
</html>