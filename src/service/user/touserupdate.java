package service.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SecondHand_user;
import service.userdao;

/**
 * Servlet implementation class touserupdate
 */
@WebServlet("/manager/admin_touserupdate")
public class touserupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public touserupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id=request.getParameter("id");
		
		//ͨ通过id 到数据里查找
		SecondHand_user user=userdao.selectbyid(id);
		
		request.setAttribute("user", user);
		
		request.setAttribute("cpage", request.getParameter("cpage"));
		request.getRequestDispatcher("admin_usermodify.jsp").forward(request, response);
		
	}

	

}
