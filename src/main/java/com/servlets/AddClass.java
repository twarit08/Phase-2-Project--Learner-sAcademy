package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ClassDao;
/**
 * Servlet implementation class AddClass
 */
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cls = (String) request.getAttribute("classes");
		String section = (String) request.getAttribute("sect");
		String tc = (String) request.getAttribute("teach");
		String subj	= (String) request.getAttribute("sub");
		String tmg = (String) request.getAttribute("time");
		String d = (String) request.getAttribute("day");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ClassDao clsd = new ClassDao();
		clsd.register(cls, section, tc, subj, tmg, d);
		request.getRequestDispatcher("addclass.jsp").include(request, response);
		out.println("<center><span style='color:green'> Teacher assigned to Class successfully ! </span></center>");
		
	}

}
