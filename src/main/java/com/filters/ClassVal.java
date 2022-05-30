package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class ClassVal
 */
public class ClassVal extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public ClassVal() {
        super();
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
		String cl = request.getParameter("classes");
		String sec = request.getParameter("sect");
		String tch = request.getParameter("teacher");
		String sb = request.getParameter("subject");
		String tm = request.getParameter("time");
		String d = request.getParameter("day");
		if(cl.equals("selectclass") || sec.equals("select") || tch.equals("chooseteach") || sb.equals("choose") || tm.isEmpty() || d.equals("selectday")) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("addclass.jsp").include(request, response);
			out.println("<center><span style='color:red'> Kindly fill the details correctly ! </span></center>");
		}else {
			request.setAttribute("classes", cl);
			request.setAttribute("sect", sec);
			request.setAttribute("teach", tch);
			request.setAttribute("sub", sb);
			request.setAttribute("time", tm);
			request.setAttribute("day", d);
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
