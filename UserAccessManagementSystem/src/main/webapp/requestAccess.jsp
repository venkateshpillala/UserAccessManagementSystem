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
<c:when test="${request == 1}">
	<center>Request sent success</center>
</c:when>
<c:when test="${not empty requests}">
<center>

<table>
<tr>
<th>Request Id</th>
<th>User Id</th>
<th>Software Id</th>
<th>Access Type</th>
<th>Status</th>
</tr>
<c:forEach var="request" items="${requests}">

	<tr>
	<td>${request.id}</td>
	<td>${request.user_id}</td>
	<td>${request.software_id}</td>
	<td>${request.access_type}</td>
	<td>${request.status}</td>
	</tr>

</c:forEach>
</table>
</center>
</c:when>
<c:otherwise>
	<center>
	
	<form action="./employee/getSoftware">
		<table>
			<tr>
			<td>
			<lable for="software">Software</lable>
			</td>
			<td>
				<select name="name" required>
            	<option value="">--Select a Book--</option>
            	<c:forEach var="software" items="${softwares}">
            		<option value="${software.name}">${software.name}</option>
            	</c:forEach>
        </select>
			</td>
			</tr>
			<tr>
			<td>
			<lable for="Access Type">AccessType</lable>
			</td>
			<td>
				<select name="access_type" required>
            	<option value="Read">Read</option>
            	<option value="Read">Write</option>
        </select>
			</td>
			</tr>
		<tr>
		<td>
		<lable for="Reason">Reason</lable>
		</td>
		<td>
		<textarea name="reason" rows="5" cols="40" placeholder="Enter your reason here..." required></textarea>
		</td>
		</tr>
		<tr>
		<td>
		</td>
		<td>
		<input type="subimt" value="Request"/>
		</td>
		</tr>
		</table>
	
	</form>
			<a href="./employee/status">Request status</a>
	</center>
	</c:otherwise>
	</c:choose>
		
</body>
</html>