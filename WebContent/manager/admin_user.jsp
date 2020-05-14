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
        <div class="search-wrap">
            <div class="search-content">
                <form action="admin_douserselcet" method="get">
                    <table class="search-tab">
                        <tr>
                            <!--  --></th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keyword" value="${param.keyword }" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap" >
            <form  action="/SecondHand/manager/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_useradd.jsp"><i class="icon-font"></i>新增用户</a>            
                       <td><input class="btn btn-primary btn2" name="" value="批量删除" type="submit" onclick="delmore('你确定删除这些用户吗' ,' myform')"></td>                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selall(this)" type="checkbox"></th>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>email</th>
                            <th>手机</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="u" items="${userlist }">
                        <tr>
                            <td class="tc"><input name="id[]" value="${u.user_id }" type="checkbox"></td>
                            <td> ${u.user_id } </td>
                             <td> ${u.user_name } </td>
                                <td> ${u.user_sex=='T'? '男':'女' } </td>
                                 <td> ${u.user_email } </td>
                                  <td> ${u.user_phone } </td>
                             <td>
                                <a class="link-update" href="admin_touserupdate?id=${u.user_id  }&cpage=${cpage}">修改</a>
                               <c:if test="${u.user_status==1 }">
                                <a class="link-del" href="javascript:Delete('你确定要删除该用户[${u.user_name }]吗? ','/SecondHand/manager/admin_douserdel?id=${u.user_id }&cpage=${cpage }')">删除</a>
                               </c:if>
                               
                              </td>
                              
                         </tr>
                        </c:forEach>
                        
                        <script>
                        function Delete(mess,url){
                        	if(confirm(mess)){
                        		location.href=url;
                        	}
                        }
                        
                        function selall(o){
                            var a=document.getElementsByName('id[]');
                 
                        
                        	
                        	for(var i=0;i<a.length;i++){
                        		a[i].checked=o.checked;
                        	}
                        }
                        
                        function delmore(mess,formname){
                        	
                        	if(confirm(mess)){
                        		var form=document.getElementById(formname);
                        		form.submit();
                        	}
                        }
                        </script>
                    </table>
                    <div class="list-page">
                                              共${tsum}条记录，当前${cpage}/${tpage}页   
                               <a href="admin_douserselcet?cp=1${seachParams }">首页</a>
                                <a href="admin_douserselcet?cp=${cpage-1<1?1:cpage-1}${seachParams }">上一页</a>
                                 <a href="admin_douserselcet?cp=${cpage+1>tpage?tpage:cpage+1}${seachParams }">下一页</a>
                                  <a href="admin_douserselcet?cp=${tpage}${seachParams }">尾页</a>
                              </div>
                     </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>