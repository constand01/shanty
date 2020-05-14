package servlet.sale;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import bean.SecondHand_sale;
import bean.SecondHand_user;
import service.saledao;

/**
 * Servlet implementation class tosale
 */
@WebServlet("/tosale")
public class tosale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");

         HttpSession session=request.getSession();
         SecondHand_user u=(SecondHand_user) session.getAttribute("name");
 		String sale_u_sid=u.getUser_id();
 		
 		
         SmartUpload su=new SmartUpload ();
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
			System.out.print("图片文件已上传");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		Request requ=su.getRequest();
		
         
		
		String sale_p_name=requ.getParameter("salename");
		String sprice=requ.getParameter("salep");
		 
		String sale_p_desc=requ.getParameter("saledesc");
		int sale_p_number=Integer.parseInt(requ.getParameter("salenumber"));
		
		System.out.print(" 商品名称"+sale_p_name+"价格"+sprice+"数量"+sale_p_number);
		
		
		SecondHand_sale s=new SecondHand_sale(0,sale_u_sid,fname,sale_p_number,Integer.parseInt(sprice),sale_p_desc,sale_p_name);
			int count=saledao.insert(s);
		
			if(count>0) {
				response.sendRedirect("myorderq.jsp");
			}
			else {
				
				PrintWriter out=response.getWriter();
				out.write("<script>");
				out.write("alert('提交商品失败');");
				out.write("location.href='usersaleadd.jsp';");
				out.write("</script>");
				out.close();
				return;
				
			}
	}
}

