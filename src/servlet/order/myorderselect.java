package servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SecondHand_cate;
import bean.SecondHand_item;
import bean.SecondHand_order;
import bean.SecondHand_product;
import service.categorydao;
import service.itemdao;
import service.orderdao;
import service.productdao;

/**
 * Servlet implementation class myorderselect
 */
@WebServlet("/myorderselect")
public class myorderselect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String id=request.getParameter("id");
		
		ArrayList<SecondHand_order> list=orderdao.selectbyid(id);
		
		ArrayList <SecondHand_item> ilist=new ArrayList <SecondHand_item>();
		 
		
		ArrayList <SecondHand_cate> flist= categorydao.selectcat("father");
		request.setAttribute("flist", flist);
		
		ArrayList <SecondHand_cate> clist= categorydao.selectcat("child");
		request.setAttribute("clist", clist);	
		String oid;
		
		// 循环遍历 list中所有的订单id,并将每个订单id得到的item list对象拼接成一个
		for(int i=0;i<list.size();i++) {
			
			oid=String.valueOf(list.get(i).getOrder_id());
			ArrayList<SecondHand_item> ilist1=itemdao.selectbyid(oid);
			ilist.addAll(ilist1);
		}
		
			 request.setAttribute("ilist", ilist);
			request.setAttribute("orderlist", list);
			request.setAttribute("id", id);
			request.getRequestDispatcher("myorderq.jsp").forward(request, response);
	}

		
		
		
		
	}


