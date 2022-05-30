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
<%@ page import="com.dto.Classes" %>       
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

#classes {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 70%;
}

#classes td, #classes th {
  border: 1px solid #ddd;
  padding: 8px;
}

#classes tr:nth-child(even){background-color: #f2f2f2;}

#classes tr:hover {background-color: #ddd;}

#classes th {
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
<title>Classes</title>
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
		<a href="addclass.jsp">Assign Teacher</a><br>
		<p style='font-size:30px'><b> Classes List </b></p>
		<table id="classes">
			<thead>
				<tr>
				<th>Class</th>
				<th>Section</th>
				<th>Teacher</th>
				<th>Subject</th>
				<th>Time</th>
				<th>Day</th>
				</tr>
			</thead>	
			<tbody>
			<%
				try{
					Configuration cfg = new Configuration().configure();
					cfg.addAnnotatedClass(com.dto.Classes.class);
					StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
					SessionFactory factory = cfg.buildSessionFactory(builder.build());
					Session s = factory.openSession();
					Transaction tx = s.beginTransaction();
					Query query = s.createQuery("from Classes");
					List<Classes> cl = query.list();
					for(Classes cls:cl){
						out.println("<tr><td>"+cls.getClasses()+"</td><td>"+cls.getSection()+"</td><td>"+cls.getTeacher()+"</td><td>"+cls.getSubject()+"</td><td>"+cls.getTime()+"</td><td>"+cls.getDay()+"</td></tr>");
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