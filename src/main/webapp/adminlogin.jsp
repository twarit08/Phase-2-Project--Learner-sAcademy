<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
</style>
<title>Learner's Academy Login</title>
</head>
<body>
	<div class="header">
		<h1>Learner's Academy</h1>
		<p>
			A <b>Learning School</b> to achieve your goals.
		</p>
	</div>
	<main>
		<br>
		<br>
		<div align="center">
			<p style='font-size:30px'><b><u> Welcome to Learner's Academy </u></b></p>
			<p><b>Login Here!</b></p>
			<form action="LoginController" method="post">
				<table>
					<tr>
						<td><b>Username:</b></td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td><b>Password:</b></td>
						<td><input type="password" name="password" /></td>
					</tr>
				</table>
				<br>
				<input type="submit" value="Login" />
			</form>
		</div>
	</main>
	<div class="footer">
		<p>Learner's Academy.All Rights Reserved.This Website is developed by Twarit Soni.</p>
	</div>

</body>
</html>