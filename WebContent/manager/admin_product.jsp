<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">
            </i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
        </div>
       
        <div class="result-wrap" id="register">
            <form  action="/SecondHand/manager/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/SecondHand/manager/admin_toproductadd"><i class="icon-font"></i>新增商品</a>            
                      
                     </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>ID</th>
                            <th>商品名称</th>
                            <th>商品描述</th>
                            <th>商品价格</th>
                            <th>商品库存</th>
                            <th>操作</th>
                            
                        </tr>
                        
                        <c:forEach var="p" items="${plist }">
                         <tr>
                          <td>${p.product_id }</td>
                          <td><img src="../image/product/${p.product_filename }" width="80" height="80">
                          ${p.product_name }
                          </td>
                          
                           <td>${p.product_description }</td>
                           <td>${p.product_price }</td>
                            <td>${p.product_stock }</td>
                          <td>
                          <a href="admin_toproductupdate?id=${p.product_id }">修改</a>
                          <a href="admin_toproductdel?id=${p.product_id }">删除</a>
                          </td>
                         </tr>
                        </c:forEach>
                        
                       
                    </table>
                    <div class="list-page">
                                              共${tsum}条记录，当前${cpage}/${tpage}页   
                               <a href="admin_douserselcet?cp=1${seachParams }">首页</a>
                                <a href="admin_douserselcet?cp=${cpage-1<1?1:cpage-1}${seachParams }">上一页</a>
                                 <a href="admin_douserselcet?cp=${cpage+1>tpage?tpage:cpage+1}${seachParams }">下一页</a>
                                  <a href="admin_douserselcet?cp=${tpage} ${seachParams }">尾页</a>
                              </div>
                     </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>