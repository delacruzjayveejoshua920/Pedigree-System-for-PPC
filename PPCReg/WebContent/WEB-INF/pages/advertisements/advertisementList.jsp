<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
	href="${pageContext.request.contextPath }/resources/css/mainlayout.css">
</head>

<body>
	<div id="container ">
	  <nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target="#myNavbar">
								<span class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" >PPC - PBKC</a>
						</div>
						<div class="collapse navbar-collapse" id="myNavbar">
							<ul class="nav navbar-nav">
								<li><a href="/PPCReg/pedigree/list">Home</a></li>
								<li class="dropdown"><a class="dropdown-toggle"
									data-toggle="dropdown" href="/PPCReg/pedigree/list">Pedigree<span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="/PPCReg/pedigree/list">Pedigree List</a></li>
										<li><a href="/PPCReg/pedigree/list/disapprove">Disapprove
												Pedigree</a></li>
										<li><a href="/PPCReg/pedigree/add">Add Pedigree</a></li>
									</ul></li>
								<li class="dropdown"><a class="dropdown-toggle"
									data-toggle="dropdown" href="/PPCReg/pedigree/list">Advertisement<span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="/PPCReg/advertisement/list">Advertisement
												List</a></li>
										<li><a href="/PPCReg/advertisement/add">Add
												Advertisement</a></li>
									</ul></li>

								<security:authorize access="hasRole('Admin')">
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="/PPCReg/print/list">Print<span
											class="caret"></span></a>
										<ul class="dropdown-menu">
											<li><a href="/PPCReg/print/list">Print List</a></li>
											<li><a href="/PPCReg/print/add">Print Certificate</a></li>
										</ul></li>


									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="/PPCReg/user/list">User<span
											class="caret"></span></a>
										<ul class="dropdown-menu">
											<li><a href="/PPCReg/user/list">User List</a></li>
											<li><a href="/PPCReg/user/add">Add User</a></li>
										</ul></li>
								</security:authorize>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<!--  icons -->
								<li><a><span class="glyphicon glyphicon-user"></span>Welcome,
										${loginheader}</a></li>
								<li><a href="<c:url value="/logout"  />"><span
										class="glyphicon glyphicon-log-out"></span> Logout</a></li>
							</ul>
						</div>
					</div>
				</nav>
		<div class="header">
		    <div class="adsHeader">
				<center>
					<a href="ads/${displayAds.id}"><img
						src="${pageContext.request.contextPath}/asset/${displayAds.pedigreeimage.fileName }"
						width=50% height=90px></a>
				</center>
			</div>
			
			<img
				src="${pageContext.request.contextPath }/resources/image/login.png"
				class="img-responsive" width=100%>
		</div>

		<div class="content">
			<h2>Advertisements</h2>
			<div>&nbsp<a href="add/"><button class="btn btn-success">Add Ads</button></a></div>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Advertiser</th>
							<th>Type of Ads</th>
							<th>Location</th>
							<th>Url</th>
							<th>Is Approve</th>
							<th>Price</th>
							<th>No of Clicks</th>
							<th>Total</th>
							<th>Image</th>
							<th></th>
							<th></th>
						</tr>

					</thead>
					<tbody>
					<security:authorize access="hasRole('Admin')">
						<c:forEach var="current" items="${advertisements}">
							<tr>
								<td>${current.user.firstName} ${current.user.middleName} ${current.user.lastName }</td>
								<td>${current.typeAd }</td>
								<td>${current.location }</td>
								<td>${current.url }</td>
								<td>${current.isApproved }</td>
								<td>${current.price }</td>
								<td>${current.numberClicks }</td>
								<td>${current.price * current.numberClicks}</td>
								<td><a href="image/${current.pedigreeimage.id }">View Image</a></td>
								<td><a href="edit/${current.id}">Edit</a></td>

								<td><a href="delete/${current.id}">Delete</a></td>

							</tr>
						</c:forEach>
						</security:authorize>
					
					<security:authorize access="hasRole('User')">
					    <c:forEach var="a" items="${AdsUser}">
							<tr>
								<td>${a.user.firstName} ${a.user.middleName} ${a.user.lastName }</td>
								<td>${a.typeAd }</td>
								<td>${a.location }</td>
								<td>${a.url }</td>
								<td>${a.isApproved }</td>
								<td>${a.price }</td>
								<td>${a.numberClicks }</td>
								<td>${a.price * a.numberClicks}</td>
								<td><a href="image/${a.pedigreeimage.id }">View Image</a></td>
							</tr>
						</c:forEach>
					</security:authorize>	
						
					</tbody>
				</table>
			</div>
		</div>
	</div>

	</div>


</body>
<div class="adsFooter">
		<center>
			<a href="ads/${adsFooter.id}"><img
				src="${pageContext.request.contextPath}/asset/${adsFooter.pedigreeimage.fileName }"
				width=50% height=90px></a>
		</center>
		<br>
	</div>
</body>
</html>