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
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/SecondHand/manager/admin_docateadd" method="post" id="myform" name="myform" onsubmit="return checkFrom(this)">
                    <table class="insert-tab" width="100%">
                        <tbody>
                           
                             <tr>
                                <th><i class="require-red">*</i>父级分类：</th>
                                <td>
                                    <select class="common-text required"  name="parentid" type="text">
                                    <option value="0" selected="selected">根分类</option>
                                         <c:forEach var="cate" items="${catelist }">
                                            <c:if test="${cate.cate_parent_id==0}">
                                         <option value="${cate.cate_id }">${cate.cate_name}</option>
                                         </c:if>
                                          </c:forEach>
                                    </select>
                                <span></span>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>分类名称：</th>
                                <td>
                                    <input class="common-text required" id="title"  name="classname" type="text">
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