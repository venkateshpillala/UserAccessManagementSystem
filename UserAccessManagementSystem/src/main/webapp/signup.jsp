<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<body>
<form action="./signupServlet" method="POST">
	<input type="text" name="username"/>
	<input type="text" name="password"/>
	<input type="hidden" name="role" value="EMPLOYEE"/>
	<input type="submit" value="sign up"/>
</form>

</body>
</html>