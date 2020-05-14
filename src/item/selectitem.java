package item;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SecondHand_cate;
import bean.SecondHand_item;
import service.itemdao;

/**
 * Servlet implementation class selectitem
 */
@WebServlet("/selectitem")
public class selectitem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");//�����ַ���;
		response.setContentType("text/html;charset=utf-8");
		
		String oid=request.getParameter("oid");
		ArrayList <SecondHand_item> ilist=itemdao.selectbyid(oid);
		 request.setAttribute("ilist", ilist);
		 request.getRequestDispatcher("myorderq.jsp").forward(request, response);
		
	}

	
}
