<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">
            </i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户商品审核</span></div>
        </div>
        <div class="result-wrap" >
            <form  action="/SecondHand/manager/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selall(this)" type="checkbox"></th>
                            <th>ID</th>
                            <th>用户</th>
                            <th>图片</th>
                            <th>商品数量</th>
                            <th>商品价格</th>
                            <th>商品描述</th>
                            <th>商品名称</th>
                        </tr>
                        
                        <c:forEach var="u" items="${slist }">
                        <tr>
                            <td class="tc"><input name="id[]" value="${u.sale_id }" type="checkbox"></td>
                          
                          
                          <td> ${u.sale_id } </td>
                             <td> ${u.sale_u_id } </td>
                                <td><img width="120" height="120" src="/SecondHand/image/product/${u.sale_p_filename }"></td>
                                 <td> ${u.sale_p_number } </td>
                                  <td> ${u.sale_p_price } </td>
                                   <td> ${u.sale_p_desc } </td>
                                    <td> ${u.sale_p_name } </td>
                                  
                              
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