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
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		try {
			if(username.equalsIgnoreCase("admin@learnersacademy.com") && password.equals("admin12345")) {
				rd = request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
				HttpSession session = request.getSession();
			}else {
				rd = request.getRequestDispatcher("adminlogin.jsp");
				rd.include(request, response);
				out.println("<center><span style='color:red'> Invalid Credentials! </span></center>");
			}
		} catch (Exception e) {
			request.getRequestDispatcher("adminlogin.jsp").include(request, response);
		}
		
    }
	

}
