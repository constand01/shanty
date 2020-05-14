package service.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.userdao;

/**
 * Servlet implementation class usernamecheck
 */
@WebServlet("/usernamecheck")
public class usernamecheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usernamecheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name=request.getParameter("name");
		
	   int count=userdao.selectbyname(name);

	   PrintWriter out=response.getWriter();
       if(count>0) {
    	   out.print("false");
       }else {
    	   out.print("true");
       }
		out.close();
	}

	
}
