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
<title>Add Student</title>
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
			<p style='font-size:30px'><b> Student Entry </b></p>
				<form action="AddStudent" method="post">
					<table>
					<tr>
					<td><b>E.RollNo.</b></td>
					<td><input type="text" name="erollno"></td>
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
					<td><b>Class</b></td>
					<td><select name="classes">
					<option value="selectclass">select class
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