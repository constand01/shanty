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
import javax.servlet.http.HttpSession;

import bean.SecondHand_cart;
import bean.SecondHand_item;
import bean.SecondHand_order;
import bean.SecondHand_product;
import service.cartdao;
import service.itemdao;
import service.orderdao;
import service.productdao;
import util.RandomUtil;

/**
 * Servlet implementation class ordergen
 */
@WebServlet("/ordergen")
public class ordergen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		
		//获得令牌并判断
		HttpSession session=request.getSession();
		Object obj = session.getAttribute("SESSION_ORDER_TOKEN");
		String mToken = (String) obj;
		
	
		String token=request.getParameter("token");

		boolean flag=true;
		if(obj==null) {
			flag=false;
		}else if(token!=null&&mToken.equals(token)){
			flag=true;
		}else {flag=false;}
		session.removeAttribute("SESSION_ORDER_TOKEN");
		

		
		String id=request.getParameter("id");
		String tp=request.getParameter("totprice");
		String iteminfo=request.getParameter("iteminfo");
	
		int totalprice=Integer.parseInt(tp);
	
		SecondHand_order o=new SecondHand_order(0,id,"0",totalprice,id);
		
		
		ArrayList<SecondHand_product> plist=new ArrayList<SecondHand_product>();
		 
		
		
    	 
		//从数据库获取自动增长的主键值
		int oid=0;
		try {
			oid = orderdao.insert(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		
		
		ArrayList<SecondHand_order> list=orderdao.selectbyid(id);
		//获取jsp传来产品id和产品数量，并插入订单详情表
		String items[]=iteminfo.split("/");
   	 int pid;
   	 int pn=0;
   	 for(int j=0;j<items.length;j++) {
   		 
   		 String its[]=items[j].split("_");
   		 pid=Integer.parseInt(its[1]);
   		SecondHand_product p=productdao.selectbyid(pid);
   		plist.add(p);
   		 pn=Integer.parseInt(its[2]);
   	       itemdao.insert(oid,pid,pn,p.getProduct_filename(),p.getProduct_name(),p.getProduct_price());
   		 
   		 
   	 }
   	 
   	 
   	 
		if(pn>0&&flag) {
			String oids=String.valueOf(oid);
		
			ArrayList <SecondHand_item> ilist=itemdao.selectall();
			
			
			 request.setAttribute("ilist", ilist);
			request.setAttribute("orderlist", list);
			request.setAttribute("id", id);
			request.getRequestDispatcher("myorderq.jsp").forward(request, response);
		}
		else {
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('订单生成失败,请不要重复提交');");
			out.write("location.href='index.jsp';");
			out.write("</script>");
		}
	}


}
