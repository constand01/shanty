package entity;

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
@WebServlet("/manager/admin_douseradd")
public class admin_douseradd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_douseradd() {
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
		
		SecondHand_user u=new SecondHand_user(username,name,password,sex,year,email,mobile,address,1);
		
		//�������ݿ���û�����
		int count=0;
		count=userdao.insert(u);
		//�ɹ���ʧ���ض���
		if(count > 0) {
			response.sendRedirect("admin_douserselcet");
			
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('用户添加失败');");
			out.write("location.href='admin_useradd.jsp';");
			out.write("</script>");
		}
		
	}

}
