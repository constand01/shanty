package service.product;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import bean.SecondHand_product;
import service.productdao;

/**
 * Servlet implementation class doproductadd
 */
@WebServlet("/manager/admin_doproductadd")
public class doproductadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建smartupload对象

		
		request.setCharacterEncoding("utf-8");//设置字符集;
		response.setContentType("text/html;charset=utf-8");

		SmartUpload su=new SmartUpload ();
		
		//初始化
		su.initialize(this.getServletConfig(), request, response);
		
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Files fs=su.getFiles();
		
		File f=fs.getFile(0);
		//过去上传的文件名称
		String fname=f.getFileName();
		
		try {
			su.save("image/product");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		
		Request reql=su.getRequest();
		
		String pname=reql.getParameter("productname");
		String id=reql.getParameter("parentid");
		String price=reql.getParameter("productprice");
		String desc=reql.getParameter("productdesc");
		String stock=reql.getParameter("productstock");
		
		SecondHand_product p=new SecondHand_product(
				0,
				pname,
				desc,
				Integer.parseInt(price),
				Integer.parseInt(stock),
				Integer.parseInt(id.split("-")[0]),
				Integer.parseInt(id.split("-")[1]),
				fname
				);
		int count =productdao.insert(p);
		
		
		if(count > 0) {
			response.sendRedirect("admin_productselect");
			
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('商品添加失败');");
			out.write("location.href='/manager/admin_toproductadd';");
			out.write("</script>");
		}
		
	
	}

}
