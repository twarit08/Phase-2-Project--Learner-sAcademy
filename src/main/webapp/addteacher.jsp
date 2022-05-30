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
<title>Add teacher</title>
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
			<p style='font-size:30px'><b> Teacher Entry </b></p>
				<form action="AddTeacher" method="post">
					<table>
					<tr>
					<td><b>TeacherId</b></td>
					<td><input type="number" name="teacherid"></td>
					</tr>
					<tr>
					<td><b>FirstName</b></td>
					<td><input type="text" name="fname"></td>
					</tr>
					<tr>
					<td><b>LastName</b></td>
					<td><input type="text" name="lname"></td>
					</tr>
					<tr>
					<td><b>Age</b></td>
					<td><input type="number" name="age"></td>
					</tr>
					<tr>
					<td><b>Contact</b></td>
					<td><input type="tel" name="contact"></td>
					</tr>
					</table>
					<br>
					<input type="submit" value="Add"/>
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