<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
            
            <c:if test="${isLogin !=1}">
            <a href="login.jsp" id="login"  >登录</a> <a href="reg.jsp" id="reg">注册</a>
            </c:if>
            
            <c:if test="${isLogin ==1}">
                <b>你好:</b><a href="login.jsp" id="login">${name.user_name }</a> 
            </c:if>
            
            
            <c:if test="${isAdminLogin ==1}">
               <a href="/SecondHand/manager/admin_index.jsp" id="login1">进入后台</a> 
            </c:if>
            
            
            </p>
                <form action="selectbykey" method="get" class="fl"><input id="search" type="text" placeholder="热门搜索：电脑配件"/><input
                        type="button"  onclick="tosearch()"/></form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                        
                        <c:if test="${isLogin ==1}">
                        <a href="showcart"><img src="img/gwc.png"/></a>
                        </c:if>
                    
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
      
        
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">首页</a></li>
           
         
         
         
         
           <c:forEach var="f" items="${flist }">
               <li><a href="selectproductlist?fid=${f.cate_id }">${f.cate_name }</a>
                <div class="sList2">
                    <div class="clearfix">
                    
                    
                  <c:forEach var="c" items="${clist }">
                         <c:if test="${f.cate_id==c.cate_parent_id }">
                          <a href="selectproductlist?cid=${c.cate_id }">${c.cate_name }</a>
                           </c:if>
                  </c:forEach>
                
                
                
                     </div>
                </div>
              </li>
          </c:forEach>
             
             
             
        </ul>
    </div>
    <script>
    function  tosearch(){
    	
    	var str=document.getElementById("search").value;
    	location.href="selectbykey?str="+str;
    	
    }
    
  
    </script>
</div>
</body>
</html>