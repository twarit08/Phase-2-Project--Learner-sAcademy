package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogout
 */
public class AdminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("adminlogin.jsp").include(request, response);
			session.invalidate();
			out.println("<center><span style='color:green'> Successfully logged out! </span></center>");
			out.close();
		} catch (Exception e) {
			request.getRequestDispatcher("adminlogin.jsp").include(request, response);
		}
	}

}
