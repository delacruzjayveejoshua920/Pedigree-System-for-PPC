<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<li><a href="<c:url value="/logout"  />">Logout</a></li>
	<table class="list-table">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Middle Name</th>
				<th>Last Name</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="current" items="${users }">
				<tr>
					<td>${current.firstName }</td>
					<td>${current.middleName }</td>
					<td>${current.lastName }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>