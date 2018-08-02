package filter;

import java.io.IOException;

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
 * Servlet Filter implementation class MakesureFilter
 */
public class MakesureFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MakesureFilter() {
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
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
			
			HttpServletResponse response = (HttpServletResponse) res; 
			HttpServletRequest request = (HttpServletRequest) req;	
			String url = request.getRequestURI();	
			HttpSession session = request.getSession(true);
			Object obj = session.getAttribute("username");
			
			//如果session为空，则说明用户没有登录，将当前网页重定向到登录页面
			if(null == obj || ((String) obj).length() ==0){
				System.out.println(url);
				//request.getRequestDispatcher("login.html").forward(request, response);
				response.sendRedirect("/onlineshop/home/login.jsp");
				System.out.println(this.getClass()+"拦截了request");
				//chain.doFilter(req, res);
				return;
			}else{
				//System.out.println("session is not null");
				chain.doFilter(req, res);	
				return;
			}
}
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
