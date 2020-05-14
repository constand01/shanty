package service.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checkusernum
 */
@WebServlet("/checkusernum")
public class checkusernum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num=request.getParameter("num");
		  HttpSession session=request.getSession();
		  String syscode=(String)session.getAttribute("code");
		  PrintWriter out=response.getWriter();
	      
		  if(syscode.equals(num)) {
			  out.print("ture");
		  }else {
	    	   out.print("false");
	       }
		  out.close();
		  
	}

	

}
