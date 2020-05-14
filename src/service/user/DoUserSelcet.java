package service.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.userdao;
import bean.SecondHand_user;
/**
 * Servlet implementation class DoUserSelcet
 */
@WebServlet("/manager/admin_douserselcet")
public class DoUserSelcet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserSelcet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int cpage=1; //当前页
		int count=5;//每页显示条数
		
		//获取用户指定的页面
		
		String cp=request.getParameter("cp");
		
		//获取用户搜索的关键字
		String keyword=request.getParameter("keyword");
		
		if(cp!=null)
		{
			cpage=Integer.parseInt(cp);
		}
		int arr[]=userdao.totalPage(count,keyword);
		
		//获取所有的用户记录
		
		ArrayList<SecondHand_user>list=userdao.selectall(cpage,count,keyword);
		
		//放到请求对象域里
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		if(keyword!=null) {
			request.setAttribute("seachParams", "&keyword="+keyword);
		}
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
		
	}

}
