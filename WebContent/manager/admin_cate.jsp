<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">
            </i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">作品管理</span></div>
        </div>
       
        <div class="result-wrap" id="register">
            <form  action="/SecondHand/manager/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/SecondHand/manager/admin_tocateadd"><i class="icon-font"></i>新增分类</a>            
                      
                     </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="40%">
                        <tr>
                            <th>ID</th>
                            <th>分类名称</th>
                            <th>操作</th>
                            
                        </tr>
                        
                        <c:forEach var="cate" items="${catelist }">
                        <c:if test="${cate.cate_parent_id==0}">
                        
                        
                          <tr>
                             <td> ${cate.cate_id }</td>
                             <td> |-${cate.cate_name }</td>
                             <td><a href="admin_tocateupdate?id=${cate.cate_id }">修改</a><a href="javascript:catedel(${cate.cate_id })">删除</a></td>
                          </tr>
                          
                          
                             <c:forEach var="zcate" items="${catelist }">
                             <c:if test="${zcate.cate_parent_id==cate.cate_id}">
                             <tr>
                             <td> ${zcate.cate_id }</td>
                             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${zcate.cate_name }</td>
                             <td><a href="admin_tocateupdate?id=${zcate.cate_id }">修改</a><a href="javascript:catedel(${cate.cate_id })">删除</a></td>
                              </tr>
                              </c:if>
                             </c:forEach>
                             
                             
                             
                             
                           </c:if>
                           
                        </c:forEach>
                        
                        <script>
                        function catedel(id){
                        	if(confirm("你确定删除这个分类吗？")){
                        		location.href="admin_docatedel?id="+id;
                        	}
                        }
                        
                      
                        </script>
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