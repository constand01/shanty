package servlet.cate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SecondHand_cate;
import service.categorydao;

/**
 * Servlet implementation class docateupdate
 */
@WebServlet("/manager/admin_docateupdate")
public class docateupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//ÉèÖÃ×Ö·û¼¯;
		response.setContentType("text/html;charset=utf-8");
		

		int  id=Integer.parseInt(request.getParameter("id"));
		int  fid=Integer.parseInt(request.getParameter("parentid"));
		String name=request.getParameter("classname");
		
		 SecondHand_cate cate=new  SecondHand_cate(id,name,fid);
		 categorydao.update(cate);
		
		 response.sendRedirect("admin_cateselect");
	}

}
