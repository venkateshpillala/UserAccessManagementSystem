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
<c:choose>
	<c:when test=""></c:when>
	<c:otherwise>
	
		<table>
			<tr>
			<th>Request ID</th>
			<th>User ID</th>
			<th>Software ID</th>
			<th>Access Type</th>
			<th>Reason</th>
			<th>status</th>
			<th>Approve</th>
			</tr>
			<c:forEach var = "request" items="${pending }">
			<tr>
			<td>${request.id}</td>
			<td>${request.user_id}</td>
			<td>${request.software_id}</td>
			<td>${request.access_type}</td>
			<td>${request.reason }</td>
			<td>${request.status}</td>
			<td>
			
				<form action = "./approvalServlet" method="POST">
				<input type = "hidden" name ="id" value="${request.id}"/>
				<input type="submit" value="submit"/>
				</form>
			</td>
			</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
</body>
</html>