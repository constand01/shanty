package servlet.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SecondHand_cate;
import bean.SecondHand_product;
import service.categorydao;
import service.productdao;

/**
 * Servlet implementation class selectproductview
 */
@WebServlet("/selectproductview")
public class selectproductview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		ArrayList <SecondHand_cate> flist= categorydao.selectcat("father");
		request.setAttribute("flist", flist);
		
		ArrayList <SecondHand_cate> clist= categorydao.selectcat("child");
		request.setAttribute("clist", clist);
		  
		String id=request.getParameter("id");
		
		
		//获取最近访问
		
		HttpSession session=request.getSession();
		 
		//从session 获取是否有ids
		
		ArrayList<Integer> ids=(ArrayList<Integer>)session.getAttribute("ids");
		
		if(ids==null) {
			ids=new ArrayList<Integer>();
		}
		
		//最多放5个,如果多出5个将第一个删除
		
		if(ids.size()>=5) {
			ids.remove(0);
		}
		
		//添加列表里，不重复
		if(id!=null&&(!ids.contains(Integer.parseInt(id)))) {
		ids.add(Integer.parseInt(id));
		}
		
		session.setAttribute("ids", ids);
		ids=(ArrayList<Integer>)session.getAttribute("ids");
		
		
		if(ids!=null) {
			
			ArrayList<SecondHand_product> lastlylist=productdao.selectallbyid(ids);
			request.setAttribute("lastlylist", lastlylist);
		}
			
		
		SecondHand_product p=null;
		
		if(id!=null) {
			p=productdao.selectbyid(Integer.parseInt(id));
			request.setAttribute("p", p);
		}
		
		
		if(p!=null) {
			
			int cid=p.getProduct_cid();
			ArrayList<SecondHand_product> classlist=productdao.selectallbycid(cid);
			request.setAttribute("classlist", classlist);
			
			SecondHand_cate cate=categorydao.selectbyid(cid);
			request.setAttribute("cate",cate);
		}
		
		request.getRequestDispatcher("productview.jsp").forward(request, response);
	}

}
