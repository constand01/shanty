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
 * Servlet implementation class admin_logout
 */
@WebServlet("/manager/admin_logout")
public class admin_logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session=request.getSession();
		session.removeAttribute("name");
		session.removeAttribute("isLogin");
		session.removeAttribute("isAdminLogin");


		PrintWriter out=response.getWriter();
		out.write("<script>");
		out.write("alert('已退出校园二手交易网站后台');");
		out.write("location.href='login.jsp';");
		out.write("</script>");
	
	}

}
