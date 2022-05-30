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
<%@ page import="com.dto.Students" %>
<%@ page import="com.dto.Classes" %>
<%@ page import="com.dto.SubjectClass" %>
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

#report {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 70%;
}

#report td, #report th {
  border: 1px solid #ddd;
  padding: 8px;
}

#report tr:nth-child(even){background-color: #f2f2f2;}

#report tr:hover {background-color: #ddd;}

#report th {
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
<title>Get Report</title>
</head>
<body>
	<div class="header">
		<h1>Learner's Academy</h1>
		<p>
			A <b>Learning School</b> to achieve your goals.
		</p>
	</div>
	
	<main>
		<% String clss = request.getParameter("classes");
		   String sec = request.getParameter("sect");   %>
	
		<div align="center">
			<a href="dashboard.jsp">Click here for Dashboard</a><br>
			<h2>Class:<%=clss%> Section:<%=sec%> Report</h2><hr>
			<p style='font-size:30px'><b> Classes List </b></p>
			<table id="report">
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
					String classquery = "from Classes C where C.classes="+clss+" and C.section='"+sec+"'";
					Query query = s.createQuery(classquery);
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
		<br>
		<p style='font-size:30px'><b> Students List </b></p>
		<table id="report">
					<thead>
						<tr>
					<th>E.Roll No.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
					<th>Class</th>
					<th>Section</th>
					</tr>
					</thead>
					<tbody>
						<%
							try{
								Configuration cfg = new Configuration().configure();
								cfg.addAnnotatedClass(com.dto.Students.class);
								StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
								SessionFactory factory = cfg.buildSessionFactory(builder.build());
								Session s = factory.openSession();
								Transaction tx = s.beginTransaction();
								String stdquery = "from Students S where S.classes="+clss+" and S.section='"+sec+"'";
								Query query = s.createQuery(stdquery);
								List<Students> stl = query.list();
								for(Students st:stl){
									out.println("<tr><td>"+st.getRollno()+"</td><td>"+st.getFname()+"</td><td>"+st.getLname()+"</td><td>"+st.getAge()+"</td><td>"+st.getClasses()+"</td><td>"+st.getSection()+"</td></tr>");
								}
								tx.commit();
								s.close();
							}catch(Exception e){
								e.printStackTrace();
							}
						%>
					</tbody>
				</table>
				<br>
				<p style='font-size:30px'><b>Subjects List</b></p>
				<table id="report">
				<thead>
					<tr>
					<th>Subject Name</th>
					<th>Subject Code</th>
					<th>Class Assigned</th>
					</tr>
				</thead>
				<tbody>
					<%
						try{
							Configuration cfg = new Configuration().configure();
							cfg.addAnnotatedClass(com.dto.SubjectClass.class);
							StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
							SessionFactory factory = cfg.buildSessionFactory(builder.build());
							Session s = factory.openSession();
							Transaction tx = s.beginTransaction();
							String subjquery = "from SubjectClass SC where SC.classes="+clss;
							Query query = s.createQuery(subjquery);
							List<SubjectClass> sbc = query.list();
							for(SubjectClass sb:sbc){
								out.println("<tr><td>"+sb.getSubjectname()+"</td><td>"+sb.getSubcode()+"</td><td>"+sb.getClasses()+"</td></tr>");
							}
							tx.commit();
							s.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					%>
				</tbody>
			</table>
			<br>
		</div>
	
	</main>
		
</body>
</html>