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
 * Servlet Filter implementation class StudentVal
 */
public class StudentVal extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public StudentVal() {
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
		
		String eroll = request.getParameter("erollno");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String age = request.getParameter("age");
		String classes = request.getParameter("classes");
		String sect = request.getParameter("sect");
		
		if(!eroll.matches("[A-Z]{2}[0-9]{4}") || eroll.isEmpty() || fname.isEmpty() || lname.isEmpty()|| age.isEmpty() || classes.equals("selectclass") || sect.equals("select")) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("addstudent.jsp").include(request, response);
			out.println("<center><span style='color:red'> Kindly fill the details correctly ! </span></center>");
		}else {
			request.setAttribute("erollno", eroll);
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("age", age);
			request.setAttribute("classes", classes);
			request.setAttribute("sect", sect);
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
