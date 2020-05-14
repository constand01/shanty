package service.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SecondHand_cate;
import bean.SecondHand_product;
import bean.SecondHand_user;
import service.categorydao;
import service.productdao;
import service.userdao;

/**
 * Servlet implementation class toproductupdate
 */
@WebServlet("/manager/admin_toproductupdate")
public class toproductupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		SecondHand_product pro=productdao.selectbyid(id);
		
		ArrayList <SecondHand_cate> flist= categorydao.selectcat("father");
		request.setAttribute("flist", flist);
		
		ArrayList <SecondHand_cate> clist= categorydao.selectcat("child");
		request.setAttribute("clist", clist);
		
		
	   
	    
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("admin_productmodify.jsp").forward(request, response);
	}

	
}
