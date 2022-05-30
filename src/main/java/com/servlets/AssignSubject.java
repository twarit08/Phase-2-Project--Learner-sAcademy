package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.SubjClassDao;
/**
 * Servlet implementation class AssignSubject
 */
public class AssignSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sbname = (String) request.getAttribute("sbname");
		String sbcode = (String) request.getAttribute("sbcode");
		String classes = (String) request.getAttribute("classes");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		SubjClassDao subas = new SubjClassDao();
		subas.assign(sbname, sbcode, classes);
		request.getRequestDispatcher("assignsubject.jsp").include(request, response);
		out.println("<center><span style='color:green'> Subject assigned successfully ! </span></center>");
		
	}

}
