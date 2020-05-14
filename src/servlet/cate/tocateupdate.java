package servlet.cate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SecondHand_cate;
import service.categorydao;

/**
 * Servlet implementation class tocateupdate
 */
@WebServlet("/manager/admin_tocateupdate")
public class tocateupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		SecondHand_cate cate=categorydao.selectbyid(id);
		
		ArrayList<SecondHand_cate> catelist=categorydao.selectall();
			
			request.setAttribute("catelist",catelist);
			request.setAttribute("cate1",cate);
			request.getRequestDispatcher("admin_catemodify.jsp").forward(request, response);
			
			}

	

}
