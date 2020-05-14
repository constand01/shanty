package service.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SecondHand_user;
import service.userdao;

/**
 * Servlet implementation class douserdel
 */
@WebServlet("/manager/admin_douserdel")
public class douserdel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public douserdel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				String id=request.getParameter("id");
				
	
				
				int count=0;
				count=userdao.del(id);
				//�ɹ���ʧ���ض���
				if(count > 0) {
					response.sendRedirect("/SecondHand/manager/admin_douserselcet?cp="+request.getParameter("cpage"));
					
				}
				else
				{
					PrintWriter out=response.getWriter();
					out.write("<script>");
					out.write("alert('用户删除失败');");
					out.write("location.href='/SecondHand/manager/admin_douserselect?cp="+request.getParameter("cpage")+"';");
					out.write("</script>");
				}
				
			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//�����ַ���;
		response.setContentType("text/html;charset=utf-8");
	
		String ids[]=request.getParameterValues("id[]");
        for(int i=0;i<ids.length;i++) {
        	userdao.del(ids[i]);
        }
	   
		//�ɹ���ʧ���ض���
			response.sendRedirect("/SecondHand/manager/admin_douserselcet");
			
		
		
	}

}
