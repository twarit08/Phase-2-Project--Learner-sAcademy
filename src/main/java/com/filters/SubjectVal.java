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
 * Servlet Filter implementation class SubjectVal
 */
public class SubjectVal extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public SubjectVal() {
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
		String sname = request.getParameter("subjectname");
		String scode = request.getParameter("subcode");
		
		if(sname.isEmpty() || scode.isEmpty() || !scode.matches("[A-Z]{2}[0-9]{2}")) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("addsubject.jsp").include(request, response);
			out.println("<center><span style='color:red'> Kindly fill the details correctly ! </span></center>");
		}else {
			request.setAttribute("subname", sname);
			request.setAttribute("subcode", scode);
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
