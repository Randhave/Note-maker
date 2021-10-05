<%@page import="com.Entities.note"%>
<%@page import="org.hibernate.Transaction"%>
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
<title>Add Note</title>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<%
	int noteId = Integer.parseInt(request.getParameter("note_id").trim());
	Session s = FactoryProvider.getFactory().openSession();

	note notes = s.get(note.class, noteId);
	%>
	<div class="container col-12 md-12 sm-12 mt-4">
		<h2>Update Your Notes :</h2>

		<form action="updateNotes" method="post">
			<input value="<%=notes.getId()%>" name="note_id" id="note_id"
				type="hidden" />
			<div class="mb-3">
				<label for="title" class="form-label">Title </label> <input required
					type="text" class="form-control" id="title" name="title"
					value="<%=notes.getTitle()%>" placeholder="Enter title">
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">Content </label>
				<textarea class="form-control" id="content" rows="10" required
					placeholder="Enter Content" name="content"><%=notes.getContent()%>
					</textarea>
			</div>
			<a href="allNotes.jsp" class="btn btn-secondary">Back</a>
			<button type="submit" class="btn btn-success">Add Note</button>

		</form>
	</div>
</body>
</html>