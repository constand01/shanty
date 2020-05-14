package service.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.cartdao;

/**
 * Servlet implementation class cartshopdel
 */
@WebServlet("/cartshopdel")
public class cartshopdel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String esid=request.getParameter("esid");
		
		cartdao.getDeleteDD(Integer.parseInt(esid));
		
		
	}


}
