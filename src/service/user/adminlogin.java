package service.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SecondHand_user;
import service.userdao;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/manager/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//�����ַ���;
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		int count=userdao.selectbyna(username,password);
		if(count >0) {
			HttpSession session=request.getSession();
			
			SecondHand_user user=userdao.selectadmin(username,password);
			session.setAttribute("name", user);
			session.setAttribute("isLogin","1");
			
			if(user.getUser_status()==2) {
			session.setAttribute("isAdminLogin","1");
			response.sendRedirect("/SecondHand/manager/admin_index.jsp");}
			
			else {
				response.sendRedirect("/SecondHand/index.jsp");
			}
			
			
		}else {
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('用户登录失败');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
		}
	}
}
