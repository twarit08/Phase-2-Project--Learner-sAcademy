<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session = "true" %>
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
<title>Admin Dashboard</title>
</head>
<body>
	
	<div class="header">
		<h1>Learner's Academy Dashboard</h1>
		<p>
			A <b>Learning School</b> to achieve your goals.
		</p>
	</div>
	<main>
		<div align="center">
			<h1><span style='color:red'> Welcome Admin!</span></h1><hr><br>
			<a href="classdetails.jsp">1. Classes</a><br><br>
			<a href="subjectsdetails.jsp">2. Subjects</a><br><br>
			<a href="teacherdetails.jsp">3. Teachers</a><br><br>
			<a href="studentdetails.jsp">4. Students</a><br><br>
			<a href="classreport.jsp">View Class Report</a><br><br><br><br><br>
			<a href="AdminLogout">Logout</a>
		</div>
	</main>
	
	<div class="footer">
		<p>Learner's Academy.All Rights Reserved.This Website is developed by Twarit Soni.</p>
	</div>

</body>
</html>