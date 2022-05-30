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
<title>Add Subject</title>
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
			<p style='font-size:30px'><b> Subject Entry </b></p>
				<form action="AddSubject" method="post">
					<table>
					<tr>
					<td><b>SubjectName</b></td>
					<td><input type="text" name="subjectname"></td>
					</tr>
					<tr>
					<td><b>SubjectCode</b></td>
					<td><input type="text" name="subcode"></td>
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