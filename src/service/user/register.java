package service.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SecondHand_user;
import service.userdao;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("username");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String year=request.getParameter("birthday");
		String email=request.getParameter("email");
		String mobile=request.getParameter("phone");
		String address=request.getParameter("address");
		
		SecondHand_user u=new SecondHand_user(username,name,password,sex,year,email,mobile,address,1);
		
		//加入到数据库的用户表中
		int count=0;
		count=userdao.insert(u);
		//
		if(count > 0) {
		
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('注册成功');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('用户注册失败');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
		}
		
	}
}
