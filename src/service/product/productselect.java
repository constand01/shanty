package service.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SecondHand_product;
import service.productdao;

/**
 * Servlet implementation class productselect
 */
@WebServlet("/manager/admin_productselect")
public class productselect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<SecondHand_product>   plist=productdao.selectall();
		
		request.setAttribute("plist", plist);
		
		
		request.getRequestDispatcher("admin_product.jsp").forward(request, response);
		
		
	}


}
