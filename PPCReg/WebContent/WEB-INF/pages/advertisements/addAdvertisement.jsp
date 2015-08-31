<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<script>
	var count = 0;
	function counter() {
		count = count + 1;
		alert(count);
	}
</script>

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
					<a href="/PPCReg/advertisement/ads/${displayAds.id}"><img
						src="${pageContext.request.contextPath}/asset/${displayAds.pedigreeimage.fileName }"
						width=50% height=90px></a>
				</center>
			</div>
			<img
				src="${pageContext.request.contextPath }/resources/image/login.png"
				class="img-responsive" width=100%>
		</div>

		<div class="content">
			<div class="forms">
				<form:form action="/PPCReg/advertisement/add/success" method="POST"
					commandName="advertisement" role="form"
					enctype="multipart/form-data">


					<div class="col-sm-10 ">

						<div class="col-sm-12">
							<h2>Add Advertisement</h2>
						</div>

						<security:authorize access="hasRole('Admin')">
							<div class="col-sm-10 ">
								<div class="form-group form-group-lg">
									<label for="advertiser">Advertiser</label>
									<form:select path="advertiser" type="text" class="form-control"
										placeholder="Enter Advertiser">
										<c:forEach items="${users}" var="user">
											<option value="${user.id}"><c:out
													value="${user.firstName} ${user.middleName} ${user.lastName}" /></option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</security:authorize>

						<security:authorize access="hasRole('Admin')">
							<div class="col-sm-10 ">
								<div class="form-group form-group-lg">
									<label for="typeAds">Type of Ads</label>
									<form:select path="typeAd" class="form-control">
										<option value="Main">Main</option>
										<option value="Subpage">Subpage</option>
										<option value="All">All</option>
									</form:select>
								</div>
							</div>
						</security:authorize>


						<security:authorize access="hasRole('Admin')">
							<div class="col-sm-10 ">
								<div class="form-group form-group-lg">
									<label for="location">Location</label>
									<form:select path="location" class="form-control">
										<option value="Header">Header</option>
										<option value="Footer">Footer</option>
										<option value="Side">Side</option>
									</form:select>
								</div>
							</div>
						</security:authorize>

						<div class="col-sm-10 ">
							<div class="form-group form-group-lg">
								<label for="location">Url</label>
								<form:input path="url" type="text" class="form-control"
									data-validation="url" placeholder="https://" />
							</div>
							${showAds.id}
						</div>

						<security:authorize access="hasRole('Admin')">
							<div class="col-sm-10 ">
								<div class="form-group form-group-lg">
									<label for="location">Price</label>
									<form:input path="price" type="text" class="form-control"
										data-validation="number" data-validation-allowing="float"
										placeholder="Enter Price" />
								</div>
							</div>
						</security:authorize>

						<security:authorize access="hasRole('Admin')">
							<div class="col-sm-10 ">
								<div class="form-group form-group-lg">
									<label for="isApproved">Is Approved</label>
									<form:select path="isApproved" class="form-control">
										<option value="true">Yes</option>
										<option value="false">No</option>
									</form:select>

								</div>
							</div>
						</security:authorize>

						<div class="col-sm-10 ">
							<div class="form-group form-group-lg">
								<label for="file">Upload</label> <input type="file" name="file"
									data-validation="mime size"
									data-validation-allowing="jpg, png, gif" class="form-control"
									class="span3" />

							</div>
						</div>


						<div class="col-sm-4">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>

						<script
							src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
						<script
							src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js"></script>
						<script>
							$.validate({
								decimalSeparator : ','
							});

							$.validate({
								modules : 'file'
							});
						</script>



					</div>
					<div class="col-sm-2 "></div>
					<div class="col-sm-2 ">
						<!--  advetisement -->
						<div class="adSide">
							<a href="/PPCReg/advertisement/ads/${adSide.id}"><img
								src="${pageContext.request.contextPath}/asset/${adSide.pedigreeimage.fileName }"
								width=100% height=590px></a>
						</div>
					</div>
				</form:form>
			</div>
		</div>

	</div>


</body>
<div class="adsFooter">
		<center>
			<a href="/PPCReg/advertisement/ads/${adsFooter.id}"><img
				src="${pageContext.request.contextPath}/asset/${adsFooter.pedigreeimage.fileName }"
				width=50% height=90px></a>
		</center>
		<br>
	</div>
</body>
</html>