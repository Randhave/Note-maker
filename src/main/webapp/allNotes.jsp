<%@page import="com.Entities.note"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.Helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="links.jsp"%>
<link href="css/style.css" rel="stylesheet">
<title>All Notes</title>
</head>
<body>
<%@include file="navbar.jsp"%>
	<div class="container">
		<%
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("from note"); // This are HQL query 
		List<note> notes = q.list();
		for (note note : notes) {
		%>
		<div class="container-fluid mt-5">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">
						<%=note.getTitle()%>
					</h5>
					<p class="card-text">
						<%=note.getContent()%>
					</p>
					<a href="deleteNotes?note_id=<%=note.getId()%>"
						class="btn btn-warning">Delete</a>
						 <a
						href="updateNote.jsp?note_id=<%=note.getId()%>"
						class="btn btn-success">Update</a> 
						<a href="index.jsp"
						class="btn btn-primary outline">Home</a>
				</div>
			</div>
		</div>
		<%
		} 
		s.close();
		%>
	</div>
</body>
</html>