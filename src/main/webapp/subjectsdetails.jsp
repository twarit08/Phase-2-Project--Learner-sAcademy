<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session = "true" %>    
<%@ page import="org.hibernate.cfg.Configuration" %>  
<%@ page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder" %>  
<%@ page import="org.hibernate.SessionFactory" %>   
<%@ page import="org.hibernate.Session" %>   
<%@ page import="org.hibernate.Transaction" %>   
<%@ page import="org.hibernate.query.Query" %>   
<%@ page import="java.util.List" %>
<%@ page import="com.dto.Subjects" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>

body {
	background-color: lightblue;
}

.header {
	padding: 30px;
	text-align: center;
	background: #1abc9c;
	color: white;
}

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: lightgreen;
	color: black;
	text-align: center;
}

#subjects {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 70%;
}

#subjects td, #subjects th {
  border: 1px solid #ddd;
  padding: 8px;
}

#subjects tr:nth-child(even){background-color: #f2f2f2;}

#subjects tr:hover {background-color: #ddd;}

#subjects th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}

a {
  color: #003366;
  font-size: 20px;
}

</style>
<title>Subjects Details</title>
</head>
<body>
	<div class="header">
		<h1>Learner's Academy</h1>
		<p>
			A <b>Learning School</b> to achieve your goals.
		</p>
	</div>
	
	<main>
		
		<div align="center">
			<a href="addsubject.jsp">Add Subject</a><br>
			<a href="assignsubject.jsp">Assign a Class for Subject</a><br>
			<p style='font-size:30px'><b> Subjects List </b></p>
			<table id="subjects">
				<thead>
					<tr>
					<th>Subject Id</th>
					<th>Subject Name</th>
					<th>Subject Code</th>
					</tr>
				</thead>
				<tbody>
					<%
						try{
							Configuration cfg = new Configuration().configure();
							cfg.addAnnotatedClass(com.dto.Subjects.class);
							StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
							SessionFactory factory = cfg.buildSessionFactory(builder.build());
							Session s = factory.openSession();
							Transaction tx = s.beginTransaction();
							Query query = s.createQuery("from Subjects");
							List<Subjects> sbj = query.list();
							for(Subjects sb:sbj){
								out.println("<tr><td>"+sb.getSubid()+"</td><td>"+sb.getSubjectname()+"</td><td>"+sb.getSubcode()+"</td></tr>");
							}
							tx.commit();
							s.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					%>
				</tbody>
			</table>
			<br><br><br>
		</div>
	</main>
	
	<div class="footer">
		<p>Learner's Academy.All Rights Reserved.This Website is developed by Twarit Soni.</p>
	</div>

</body>
</html>