package servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SecondHand_cate;
import bean.SecondHand_product;
import service.categorydao;
import service.productdao;

/**
 * Servlet implementation class selectbykey
 */
@WebServlet("/selectbykey")
public class selectbykey extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//�����ַ���;
		response.setContentType("text/html;charset=utf-8");
		
		String proname=request.getParameter("str");
		ArrayList<SecondHand_product> pl=productdao.selectbykey(proname);
		
		ArrayList <SecondHand_cate> flist= categorydao.selectcat("father");
		request.setAttribute("flist", flist);
		
		ArrayList <SecondHand_cate> clist= categorydao.selectcat("child");
		request.setAttribute("clist", clist);
		
		 String fid=request.getParameter("fid");
		 String cid=request.getParameter("cid");
		
		 
		 int id=0;
		 ArrayList<SecondHand_product>list=null;
	     if(fid!=null) {
	    	 id=Integer.parseInt(fid);
	    	 list=productdao.selectallbyfid(id);
	     }
		 
	     if(cid!=null) {
	    	 id=Integer.parseInt(cid);
	    	 list=productdao.selectallbycid(id);
	     }
	     
	      request.setAttribute("title", categorydao.selectbyid(id).getCate_name());
	     
	     request.setAttribute("list", list);
		
		
		request.setAttribute("plist", pl);
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
		
	}

}
