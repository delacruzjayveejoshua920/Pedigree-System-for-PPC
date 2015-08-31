<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<security:authorize access="isAuthenticated()">
	<c:redirect url="/pedigree/list" />
</security:authorize>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/js/datepicker.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/loginlayout.css">
</head>

<body>
	<!-- menu -->
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand">Welcome to PPC-PBKC</a>
			</div>

			<div class="navbar-collapse collapse" id="navbar-main">

				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>

				</c:if>
				<form class="navbar-form navbar-right" role="search" method="POST"
					action="${pageContext.request.contextPath}/j_spring_security_check">
					<div class="form-group">
						<input type="text" class="form-control" name="j_username"
							autocomplete="off" type="text" placeholder="Username" id="lg">

					</div>
					<div class="form-group">
						<input class="form-control" name="j_password" type="password"
							placeholder="Enter Password" id="lg">
					</div>
					<button type="submit" class="btn btn-default" data-toggle="modal" data-target="#myModal">Sign In</button>
					<a href="<c:url value="/register"  />"><button type="button"
							class="btn btn-default">Sign Up</button></a>
				</form>
			</div>
		</div>
	</div>

	<div class="adsHeader">
		<center>
			<a href="ads/${displayAds.id}"><img
				src="${pageContext.request.contextPath}/asset/${displayAds.pedigreeimage.fileName }"
				width=50% height=90px></a>
		</center>
	</div>
	<div class="header">

		<img
			src="${pageContext.request.contextPath }/resources/image/philippine pitbull club cover.jpg"
			width=100% class="img-responsive" height=50px>
	</div>

	<div>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-11">
				<h2>About Us</h2>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-3">
			<p class="text-justify">The Philippine Pitbull Club (PPC) was
				first established December 1999 in Pasig City by a group of friends
				who are dog breeders and lovers of Pitbull.</p>

			<p class="text-justify">The PPC is a professional organization
				dedicated in maintaining and preserving the wonderful
				characteristics of the versatile dog breed--the Pitbull.</p>


		</div>
		<div class="col-md-3">
			<p class="text-justify">The PPC envisions itself to be a
				world-class club, actively leading in the arena of pitbull terrier
				dog development and dog transformation through excellence in
				teaching, research and community service.</p>

			<p class="text-justify">The PPC will serve as resource for
				pitbull terrier dog conformation, dog shows and the like. Guided by
				loyal friends and members, PPC is dedicated to the advancement of
				knowledge and appreciation to the art of the pitbull dog culture.</p>
		</div>

		<div class="col-md-3">
			<p class="text-justify">The PPC commits itself to pursue relevant
				and responsive information dissemination programs, research and
				extensive services.</p>
			<p class="text-justify">It also aims to tackle further and foster
				the nurturing deep relations between pets and their respective
				owners.</p>
		</div>



		<div class="col-md-2">
			<div class="adSide">
				<a href="ads/${adSide.id}"><img
					src="${pageContext.request.contextPath}/asset/${adSide.pedigreeimage.fileName }"
					width=100% height=590px></a>
			</div>
		</div>

	</div>



	<!-- menu -->




</body>

<div class="footer">
	<div class="adsFooter">
		<center>
			<a href="ads/${adsFooter.id}"><img
				src="${pageContext.request.contextPath}/asset/${adsFooter.pedigreeimage.fileName }"
				width=50% height=90px></a>
		</center>
		<br>
	</div>
</div>
<c:if test="${not empty param.error}">
	<script>
		alert("Invalid Username or Password");
	</script>
</c:if>
</html>