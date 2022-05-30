package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.TeachersDao;

/**
 * Servlet implementation class AddTeacher
 */
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tid = (String) request.getAttribute("teacherid");
		String fname = (String) request.getAttribute("fname");
		String lname = (String) request.getAttribute("lname");
		String age = (String) request.getAttribute("age");
		String contact  = (String) request.getAttribute("contact");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		TeachersDao td = new TeachersDao();
		td.addTeacher(tid, fname, lname, age, contact);
		request.getRequestDispatcher("addteacher.jsp").include(request, response);
		out.println("<center><span style='color:green'> Teacher details added successfully ! </span></center>");
	}

}
