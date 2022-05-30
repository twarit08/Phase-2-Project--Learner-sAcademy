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
 * Servlet Filter implementation class AssignSubVal
 */
public class AssignSubVal extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AssignSubVal() {
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
		String sbname = request.getParameter("subjectname");
		String sbcode = request.getParameter("subcode");
		String classes = request.getParameter("classes");
		
		if(sbname.equals("setname") || sbcode.equals("select") || classes.equals("selectclass")) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("assignsubject.jsp").include(request, response);
			out.println("<center><span style='color:red'> Kindly select correct option ! </span></center>");
		}else {
			request.setAttribute("sbname", sbname);
			request.setAttribute("sbcode", sbcode);
			request.setAttribute("classes", classes);
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
