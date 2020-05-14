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
 * Servlet implementation class admin_douseradd
 */
@WebServlet("/manager/admin_douserupdate")
public class admin_douserupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_douserupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//�����ַ���;
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("username");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String year=request.getParameter("birthday");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String userstatus=request.getParameter("status");
		
		int status=1;
		
		if(userstatus!=null)
		{
			status=Integer.parseInt(userstatus);
		}
		
		SecondHand_user user=new SecondHand_user(username,name,password,sex,year,email,mobile,address,1);
		
		//加入到数据库的用户表中
		int count=userdao.update(user);
		if(count > 0) {
			response.sendRedirect("admin_douserselcet?cp="+request.getParameter("cpage"));
			
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('用户修改失败');");
			out.write("location.href='manager/admin_touserupdate?id='"+username+"';");
			out.write("</script>");
		}
		
	}

}
