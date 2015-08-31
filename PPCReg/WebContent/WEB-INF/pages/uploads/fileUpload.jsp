<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
	<form:form modelAttribute="pedigreeImage" enctype="multipart/form-data"
		method="POST">
		<label>Upload File:</label>
		<div>
			<input type="file" name="file" class="span3" />
		</div>
		<label>Description:</label>
		<div>
			<form:textarea required="required"
				placeholder="Describe this file?" path="description" class="span3"
				style="resize:none;height:100px" />
		</div>
		<button type="submit" class="btn">Upload</button>
	</form:form>
	<c:forEach var="current" items="${listPedigreeImage }">
		<img src="${pageContext.request.contextPath}/asset/${current.fileName }" style="height:250px; width:250px" />
		<br/>
	</c:forEach>
</body>
</html>