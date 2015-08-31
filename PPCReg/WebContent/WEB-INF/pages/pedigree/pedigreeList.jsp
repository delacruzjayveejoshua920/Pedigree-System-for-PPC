<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand">PPC - PBKC</a>
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
						width=50% height=120px></a>
				</center>

				<img
					src="${pageContext.request.contextPath }/resources/image/login.png"
					class="img-responsive" width=100%>
			</div>


			<div class="content">
				<div class="menu">
					<div id="custom-search-input">
						<div class="col-sm-10 ">
							<form:form action="list" method="POST" commandName="pedigree">


								<div class="col-sm-12">
									<h2>Pedigree</h2>
								</div>

								<div class="col-sm-5 ">
									<div class="form-group">
										<form:input path="name" type="text" class="form-control"
											placeholder="Search Pedigree" />
									</div>
								</div>

								<div class="col-sm-3 ">
									<div class="form-group">
										<input type="submit" class="btn btn-success" value="Search" />


									</div>
								</div>
							</form:form>
						</div>


						<div class="col-sm-3 ">
						&nbsp &nbsp
							<a href="/PPCReg/pedigree/add"><button
									class="btn btn-primary">Add</button></a> 
							<a href="/PPCReg/print/add"><button class="btn btn-primary">Print
									Certificate</button></a>
						</div>

					</div>
				</div>


				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
							<tr>
								<th>Dog's Name</th>
								<th>Owner</th>
								<th>Birthdate</th>
								<th>Sire</th>
								<th>Dam</th>
								<th>Breeder</th>
								<th>Sex</th>
								<th>Color Marking</th>
								<th>Status</th>
								<th>Image</th>
								<security:authorize access="hasRole('Admin')">
									<th colspan="3">Action</th>
								</security:authorize>
								<th></th>
								<th></th>

							</tr>


						</thead>
						<tbody>
							<security:authorize access="hasRole('Admin')">

								<c:forEach var="p" items="${pedigrees}">

									<tr>
										<td>${p.name }</td>
										<td>${p.user.completeName }</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd"
												value="${p.birthDate}" /></td>

										<td><c:forEach items="${sireList}" var="s">
												<c:if test="${s.id == p.sire}">
								      ${s.name }
								  </c:if>
											</c:forEach></td>

										<td><c:forEach items="${damList}" var="d">
												<c:if test="${d.id == p.dam}">
								      ${d.name }
								  </c:if>

											</c:forEach></td>

										<td>${p.breeder }</td>
										<td>${p.sex }</td>
										<td>${p.colorMarking}</td>
										<td>${p.status }</td>
										<td><a href="image/${p.pedigreeimage.id }">View image</a>
										<td>
											<!--  <td><a href="print/${p.id}">Print</a></td>-->
										<td><a href="edit/${p.id}">Edit</a></td>
										<td><a href="delete/${p.id}">Delete</a></td>

									</tr>
								</c:forEach>
							</security:authorize>

							<security:authorize access="hasRole('User')">
								<c:forEach var="current" items="${pedigreesByUser}">

									<tr>
										<td>${current.name }</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd"
												value="${current.birthDate}" /></td>

										<td><c:forEach items="${sireList}" var="s">
												<c:if test="${s.id == current.sire}">
								      ${s.name }
								  </c:if>
											</c:forEach></td>

										<td><c:forEach items="${damList}" var="d">
												<c:if test="${d.id == current.dam}">
								      ${d.name }
								  </c:if>

											</c:forEach></td>

										<td>${current.breeder }</td>
										<td>${current.sex }</td>
										<td>${current.colorMarking}</td>
										<td>${current.status }</td>
										<td><a href="image/${current.pedigreeimage.id }">View
												image</a>
										<td>
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
<div class="footer">
	<div class="adsFooter">
		<center>
			<a href="ads/${adsFooter.id}"><img
				src="${pageContext.request.contextPath}/asset/${adsFooter.pedigreeimage.fileName }"
				width=50% height=90px></a>
		</center>
	</div>
</html>