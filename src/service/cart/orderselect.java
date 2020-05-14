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
import bean.SecondHand_item;
import bean.SecondHand_user;
import service.cartdao;
import service.itemdao;
import service.orderdao;
import util.RandomUtil;

/**
 * Servlet implementation class orderselect
 */
@WebServlet("/orderselect")
public class orderselect extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		//生成令牌，提交到jsp页面，jsp页面使用隐藏表单接收。 
	        HttpSession session=request.getSession();
	      
			final String SESSION_ORDER_TOKEN="SESSION_ORDER_TOKEN";
			session.setAttribute(SESSION_ORDER_TOKEN, RandomUtil.generateString(16));
	        
			
			
	        String isLogin=(String)session.getAttribute("isLogin");
                 

	        SecondHand_user user=(SecondHand_user)session.getAttribute("name");
	        
	        
	        String eids=request.getParameter("eids");
	        String iteminfo=request.getParameter("iteminfo");
	      
	       //判断是否登录 
	        if(user!=null&& isLogin.equals("1")) {
	        	 String ids[]=eids.split(",");
	        	int totalprice=0;
	        	
	        	 
	        	 ArrayList<SecondHand_cart> list=new ArrayList<SecondHand_cart>();
	        	
	        	 for(int i=0;i<ids.length;i++) {
	        		 SecondHand_cart es=cartdao.getcartshop(ids[i]);
	        		 
	        		 int dprice=es.getCart_p_price()*es.getCart_p_quantity();
	        		 
	        		 totalprice+=dprice;
	        		 list.add(es);
	        	 }
	      
	        	
	        	 
	        	 request.setAttribute("shoplist",list);
	        	 request.setAttribute("totalprice", totalprice);
	        	 request.setAttribute("iteminfo", iteminfo);
	        	 request.getRequestDispatcher("order.jsp").forward(request, response);
	        	 
	        	 
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
