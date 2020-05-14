package service.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SecondHand_cart;
import bean.SecondHand_sale;
import service.saledao;

/**
 * Servlet implementation class userproduct
 */
@WebServlet("/manager/admin_userproduct")
public class userproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");//�����ַ���;
		response.setContentType("text/html;charset=utf-8");
		
		ArrayList<SecondHand_sale> slist=new ArrayList<SecondHand_sale>();
		
		slist=saledao.selectall();
		 request.setAttribute("slist", slist);
		 
		 request.getRequestDispatcher("admin_showsale.jsp").forward(request, response);
		 
	}

	
	

}
