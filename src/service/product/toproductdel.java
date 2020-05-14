package service.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.productdao;
import service.userdao;

/**
 * Servlet implementation class toproductdel
 */
@WebServlet("/manager/admin_toproductdel")
public class toproductdel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id=request.getParameter("id");
		

		
		int count=0;
		count=productdao.del(id);
		if(count > 0) {
			response.sendRedirect("/SecondHand/manager/admin_productselect");
			
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('商品删除失败');");
			out.write("location.href='/SecondHand/manager/admin_productselect");
			out.write("</script>");
		}
		
		
		
		
	}

}
