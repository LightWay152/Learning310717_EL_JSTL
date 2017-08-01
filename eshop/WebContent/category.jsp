<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Category Manager</h1>
	<form action="category.php" method="post">
		<div>
			<label>Id</label>
			<input name="id" value="${model.id}" readonly>
		</div>
		<div>
			<label>Name</label>
			<input name="name" value="${model.name}">
		</div>
		<div>
			<label>NameVN</label>
			<input name="nameVN" value="${model.nameVN}">
		</div>
		<div>
			<button formaction="cate-insert.php">Insert</button>
			<button formaction="cate-update.php">Update</button>
			<button formaction="cate-delete.php">Delete</button>
			<button formaction="category.php">Reset</button>
		</div>
	</form>
	<fieldset>
		<legend>List of Categories</legend>
		<table border="1">
		<c:forEach var="c" items="${cates}">
			<tr>
				<td>${c.name}</td>
				<td>${c.nameVN}</td>
				<td><a href="cate-edit.php?id=${c.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	</fieldset>
</body>
</html>