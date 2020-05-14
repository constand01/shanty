<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="admin_menu.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!--/sidebar--> 
<head>
  <meta charset="UTF-8">
 <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/calendar.js"></script>
    <script src="js/function.js"></script>
   </head>
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_product.jsp">商品管理</a><span class="crumb-step">&gt;</span><span>商品修改</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/SecondHand/manager/admin_doproductupdate" method="post" enctype="multipart/form-data" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <input class="common-text required" id="title"  name="productid" type="hidden" value="${pro.product_id }">
                            <tr>
                                <th><i class="require-red">*</i>商品名称：</th>
                                <td>
                                    <input class="common-text required" id="title"  name="productname" type="text" value="${pro.product_name }">
                             
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>商品分类：</th>
                                <td>
                                    <select class="common-text required"  name="parentid" type="text">
                                      
                                         <c:forEach var="f" items="${flist }">
                                            <option value="${f.cate_id }"  disabled="disabled">|-${f.cate_name}</option>
                                            <c:forEach var="c" items="${clist }">
                                               <c:if test="${c.cate_parent_id==f.cate_id}">
                                          <option value="${f.cate_id }-${c.cate_id}" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${c.cate_name}</option>
                                               </c:if>
                                               </c:forEach>
                                             
                                          </c:forEach>
                                    </select>
                                <span></span>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>商品图片：</th>
                                <td>
                                    <input class="common-text required" id="title"  name="photo" type="file" >
                               <span></span>
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>商品价格：</th>
                                <td>
                                    <input class="common-text required" id="title"  name="productprice" type="text" value="${pro.product_price }">
                               <span></span>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>商品描述：</th>
                                <td>
                                    <input class="common-text required" id="title"  name="productdesc" type="text" value="${pro.product_description }">
                               <span></span>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>商品库存：</th>
                                <td>
                                    <input class="common-text required" id="title"  name="productstock" type="text" value="${pro.product_stock }" >
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