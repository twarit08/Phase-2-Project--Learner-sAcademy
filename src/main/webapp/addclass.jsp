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

a {
  color: #003366;
  font-size: 20px;
}

</style>
<title>Assign Class</title>
</head>
<body>
	
	<div class="header">
		<h1>Learner's Academy</h1>
		<p>
			A <b>Learning School</b> to achieve your goals.
		</p>
	</div>
	
	<main>
		<%
			Configuration cfg = new Configuration().configure();
			cfg.addAnnotatedClass(com.dto.Subjects.class);
			cfg.addAnnotatedClass(com.dto.Teachers.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			SessionFactory factory = cfg.buildSessionFactory(builder.build());
			Session s = factory.openSession();
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery("from Subjects");
			Query query1 = s.createQuery("from Teachers");
			List<Subjects> sbj = query.list();
			List<Teachers> tch = query1.list();
		%>
	
		<div align="center">
			<p style='font-size:30px'><b> Assign Teacher to a Class with Subject </b></p>
			<form action="AddClass" method="post">
				<table>
					<tr>
					<td><b>Class</b></td>
					<td><select name="classes">
					<option value="selectclass">select class</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					</select></td>
					</tr>
					<tr>
					<td><b>Section</b></td>
					<td><select name="sect">
					<option value="select">select section</option>
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
					</select></td>
					</tr>
					<tr>
					<td><b>Teacher</b></td>
					<td><select name="teacher">
					<option value="chooseteach">select teacher</option>
						<%
							for(Teachers tc : tch){
								String tname = tc.getFname()+" "+tc.getLname();
							
						%>
					<option value="<%=tname%>"><%=tname %></option>	
						<%
							}
						%>
					</select></td>
					</tr>
					<tr>
					<td><b>Subject</b></td>
					<td><select name="subject">
					<option value="choose">choose subject</option>
						<%
							for (Subjects sb : sbj) {
								String sname = sb.getSubjectname();
						%>
					<option value="<%=sname%>"><%=sname%></option>
						<%
							}
						%>
					</select></td>
					</tr>
					<tr>
					<td><b>Timing</b></td>
					<td><input type="text" name="time"></td>
					</tr>
					<tr>
					<td><b>Day</b></td>
					<td><select name="day">
					<option value="selectday">select day</option>
					<option value="Monday">Monday</option>
					<option value="Tuesday">Tuesday</option>
					<option value="Wednesday">Wednesday</option>
					<option value="Thursday">Thursday</option>
					<option value="Friday">Friday</option>
					<option value="Saturday">Saturday</option>
					</select></td>
					</tr>
				</table>
				<br>
				<input type="submit" value="Assign"/>
			</form>
			<br>
			<a href="dashboard.jsp">Click here for Dashboard</a>
		</div>
		
	</main>
	
	<div class="footer">
		<p>Learner's Academy.All Rights Reserved.This Website is developed by Twarit Soni.</p>
	</div>

</body>
</html>