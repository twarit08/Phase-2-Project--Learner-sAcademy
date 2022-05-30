package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SubjectsDao;

/**
 * Servlet implementation class AddSubject
 */
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sbname = (String) request.getAttribute("subname");
		String sbcode = (String) request.getAttribute("subcode");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		SubjectsDao sub = new SubjectsDao();
		sub.addsub(sbname, sbcode);
		request.getRequestDispatcher("addsubject.jsp").include(request, response);
		out.println("<center><span style='color:green'> Subject added successfully ! </span></center>");
		
	}

}
