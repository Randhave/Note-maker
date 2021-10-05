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
	<div class="container col-12 md-12 sm-12 mt-4">
		<form action="saveNotes" method="post">
			<div class="mb-3">
				<label for="title" class="form-label">Title </label> <input required
					type="text" class="form-control" id="title" name="title"
					placeholder="Enter title">
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">Content </label>
				<textarea class="form-control" id="content" rows="10" required
					placeholder="Enter Content" name="content"></textarea>
			</div>
			<button type="submit" class="btn btn-success">Add Note</button>
		</form>
	</div>
</body>
</html>