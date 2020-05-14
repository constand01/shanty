package service.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SecondHand_cart;
import bean.SecondHand_product;
import bean.SecondHand_user;
import service.cartdao;
import service.productdao;

/**
 * Servlet implementation class cartadd
 */
@WebServlet("/cartadd")
public class cartadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		
        SecondHand_product p=null;
        
        String pid=request.getParameter("id");
        String count=request.getParameter("count");
        String url=request.getParameter("url");
  
        
        
        HttpSession session=request.getSession();
        
        String isLogin=(String)session.getAttribute("isLogin");


        SecondHand_user user=(SecondHand_user)session.getAttribute("name");
        
        if(user!=null&& isLogin.equals("1")) {
        	
        	String uid=(String)user.getUser_id();
        	
        	//通过用户id和购物车中的商品id 查找购物车是否有记录
        	
        	SecondHand_cart srcsp=cartdao.getcartshop(uid,pid);
        	if(srcsp!=null) {
        		
        		int srccount=srcsp.getCart_p_quantity();
        		int newcount=srccount+Integer.parseInt(count);
        		
        		if(newcount>=5) {
        			newcount=5;
        		}
        		
        		cartdao.updatenum(srcsp.getCart_id(),newcount);
        	}else {
        		
        		if(pid!=null) {
            		p=productdao.selectbyid(Integer.parseInt(pid));
            	}
            	
            	SecondHand_cart cart=new SecondHand_cart(
            			0,
            			p.getProduct_filename(),
            			p.getProduct_name(),
            			p.getProduct_price(),
            			Integer.parseInt(count),
            			p.getProduct_stock(),
            			p.getProduct_id(),
            			uid,
            			1
            			);
            	cartdao.insert(cart);
            	
                }
        	}
        	
        	
        	else {

			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('请先登录');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
			return;
        }
	
        if(url.equals("z")) {
        	response.sendRedirect("showcart");
        	
        }else {
        	
        	response.sendRedirect("selectproductview?id="+pid);
        }
        
        
	}

	

}
