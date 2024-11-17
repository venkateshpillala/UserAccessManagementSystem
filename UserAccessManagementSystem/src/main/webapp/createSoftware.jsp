<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="./createSoftware" method="POST">
	<input type="text" name="name"/>
	<textarea name="description" rows="5" cols="40" placeholder="Enter your description here..." required></textarea>
	<input type="checkbox" name="access_level" value="Read"> Read<br>
    <input type="checkbox" name="access_level" value="Write">Write<br>
    <input type="checkbox" name="access_level" value="admin">Admin<br>
    <input type="submit" value="submit"/>
</form>

</body>
</html>