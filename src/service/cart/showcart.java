package service.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SecondHand_cart;
import bean.SecondHand_user;
import service.cartdao;

/**
 * Servlet implementation class showcart
 */
@WebServlet("/showcart")
public class showcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		 
	        HttpSession session=request.getSession();
	        
	        String isLogin=(String)session.getAttribute("isLogin");


	        SecondHand_user user=(SecondHand_user)session.getAttribute("name");
	        
	        if(user!=null&& isLogin.equals("1")) {
	        
	        	String uid=(String)user.getUser_id();
	        	
	             ArrayList<SecondHand_cart> list=cartdao.getcart(uid);
	             request.setAttribute("shoplist", list);
	             request.setAttribute("uid", uid);
	             
	           
	             request.getRequestDispatcher("cart.jsp").forward(request, response);
	            
	             
	        }else {
	        	PrintWriter out=response.getWriter();
				out.write("<script>");
				out.write("alert('请先登录');");
				out.write("location.href='login.jsp';");
				out.write("</script>");
				out.close();
				return;
	        }

		
	}

}
