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
<%@ page import="com.dto.Teachers" %>      
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

#teachers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 70%;
}

#teachers td, #teachers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#teachers tr:nth-child(even){background-color: #f2f2f2;}

#teachers tr:hover {background-color: #ddd;}

#teachers th {
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
<title>Teachers details</title>
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
			<a href="addteacher.jsp">Add Teacher</a><br>
			<p style='font-size:30px'><b> Teachers List </b></p>
			<table id="teachers">
				<thead>
					<tr>
				<th>Teacher Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Contact</th>
				</tr>
				</thead>
				<tbody>
					<%
						try{
							Configuration cfg = new Configuration().configure();
							cfg.addAnnotatedClass(com.dto.Teachers.class);
							StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
							SessionFactory factory = cfg.buildSessionFactory(builder.build());
							Session s = factory.openSession();
							Transaction tx = s.beginTransaction();
							Query query = s.createQuery("from Teachers");
							List<Teachers> tl = query.list();
							for(Teachers t:tl){
								out.println("<tr><td>"+t.getTid()+"</td><td>"+t.getFname()+"</td><td>"+t.getLname()+"</td><td>"+t.getAge()+"</td><td>"+t.getContact()+"</td></tr>");
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