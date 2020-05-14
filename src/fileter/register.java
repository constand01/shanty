package fileter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class register
 */
@WebFilter("/register")
public class register implements Filter {

    /**
     * Default constructor. 
     */
    public register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		
		req.setCharacterEncoding("utf-8");//�����ַ���;
		resp.setContentType("text/html;charset=utf-8");
		
		String username=req.getParameter("username");
		
		PrintWriter out=resp.getWriter();
		if(username.equals("")) {
			out.write("<script>");
			out.write("alert('用户名称不能为空');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
		
		HttpSession session=req.getSession();
		String verycode=req.getParameter("verycode");
		String syscode=(String)session.getAttribute("code");
		
		if(verycode==null||verycode=="") {
			out.write("<script>");
			out.write("alert('验证码不能为空');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
			out.close();
			return;
			
		}
		
			if(!syscode.equals(verycode)) {
			out.write("<script>");
			out.write("alert('验证码输入有误');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
			out.close();
			return;
		     }
		
       String psw=req.getParameter("password");
       String repsw=req.getParameter("repassword");
		if(!psw.equals(repsw)) {
			out.write("<script>");
			out.write("alert('两次输入的密码不一致');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
			out.close();
			return;
		} 
		if(psw.equals("")) {
			out.write("<script>");
			out.write("alert('密码不能为空');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
			out.close();
			return;
		} 
		
		    // ��ͨ����ֱ��return
		// pass the request along the filter chain
		chain.doFilter(req, resp);  //ͨ����ʹ���������
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
