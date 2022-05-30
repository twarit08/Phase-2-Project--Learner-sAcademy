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
 * Servlet Filter implementation class TeacherVal
 */
public class TeacherVal extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public TeacherVal() {
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
		String teacherid = request.getParameter("teacherid");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String age = request.getParameter("age");
		String contact = request.getParameter("contact");
		if(!teacherid.matches("[0-9]{3}") || fname.isEmpty() || lname.isEmpty() || !age.matches("[0-9]{2}") || !contact.matches("[0-9]{10}") || age.isEmpty() || contact.isEmpty()) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("addteacher.jsp").include(request, response);
			out.println("<center><span style='color:red'> Kindly fill the details correctly ! </span></center>");
		}else {
			request.setAttribute("teacherid", teacherid);
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("age", age);
			request.setAttribute("contact", contact);
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
