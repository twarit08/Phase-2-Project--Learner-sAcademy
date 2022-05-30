package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentsDao;
/**
 * Servlet implementation class AddStudent
 */
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eroll = (String) request.getAttribute("erollno");
		String fname = (String) request.getAttribute("fname");
		String lname = (String) request.getAttribute("lname");
		String age = (String) request.getAttribute("age");
		String classes = (String) request.getAttribute("classes");
		String sect = (String) request.getAttribute("sect");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		StudentsDao sd = new StudentsDao();
		sd.enroll(eroll, fname, lname, classes, sect, age);
		request.getRequestDispatcher("addstudent.jsp").include(request, response);
		out.println("<center><span style='color:green'> Student added successfully ! </span></center>");
		
		
	}

}
