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
					<a href="/PPCReg/user/ads/${displayAds.id}"><img
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
				<form:form action="${id}" method="POST" commandName="user"
					role="form">


					<div class="col-sm-10 ">

						<div class="col-sm-12">
							<h2>Edit User</h2>
						</div>

						<div class="col-sm-3 ">
							<div class="form-group form-group-lg">
								<label for="firstName">First Name</label>
								<form:input path="firstName" value="${user.firstName}"
									type="text" class="form-control" placeholder="Enter First Name"
									data-validation="required"
									data-validation-error-msg="First Name is required" />
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label for="lastName">Last Name</label>
								<form:input path="lastName" value="${user.lastName}" type="text"
									class="form-control" placeholder="Enter Last Name"
									data-validation="required"
									data-validation-error-msg="Last Name is required" />
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label for="middleName">Middle Name</label>
								<form:input path="middleName" value="${user.middleName}"
									type="text" class="form-control"
									placeholder="Enter Middle Name" data-validation="required"
									data-validation-error-msg="Middle Name is required" />
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label for="gender">Gender</label>
								<form:select path="gender" class="form-control">
									<option value="Male"
										<c:if test="${user.gender== 'Male'}">selected</c:if>>Male</option>
									<option value="Female"
										<c:if test="${user.gender == 'Female'}">selected</c:if>>Female</option>
								</form:select>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label for="address">Address</label>
								<form:input path="address" value="${user.address }" type="text"
									class="form-control" placeholder="Enter Address"
									data-validation="required"
									data-validation-error-msg="Address is required" />
							</div>
						</div>

						<div class="col-sm-4">
							<div class="form-group">
								<label for="birthdate">Birthday</label>
								<form:input path="birthDate" value="${user.birthDate}"
									type="text" class="form-control datepicker"
									placeholder="Enter Birthday" />
							</div>
						</div>

						<div class="col-sm-4">
							<div class="form-group">
								<label for="contactNo">Contact Number</label>
								<form:input path="contactNo" value="${user.contactNo}"
									type="text" class="form-control"
									placeholder="Enter Contact Number" data-validation="required"
									data-validation-error-msg="Contact no is required" />
							</div>
						</div>

						<div class="col-sm-4">
							<div class="form-group">
								<label for="kennelName">Kennel Name</label>
								<form:input path="kennelName" value="${user.kennelName}"
									type="text" class="form-control"
									placeholder="Enter Kennel Name" data-validation="required"
									data-validation-error-msg="Kennel Name is required" />
							</div>
						</div>

						<div class="col-sm-4">
							<div class="form-group">
								<label for="kennelName">Email</label>
								<form:input path="email" value="${user.email}" type="email"
									class="form-control" placeholder="Enter Email"
									data-validation="email"
									data-validation-error-msg="You did not enter a valid e-mail" />
							</div>
						</div>

						<div class="col-sm-4">
							<div class="form-group">
								<label for="username">Username</label>
								<form:input path="username" value="${user.username}" type="text"
									class="form-control" placeholder="Enter Username"
									data-validation="required" />
							</div>
						</div>

						<div class="col-sm-4">
							<div class="form-group">
								<label for="password">Password</label>
								<form:input path="password" value="${user.password}"
									type="password" class="form-control"
									placeholder="Enter Password" data-validation="length"
									data-validation-length="min8" />
							</div>
						</div>


						<security:authorize access="hasRole('Admin')">
							<div class="col-sm-10 ">
								<div class="form-group form-group-lg">
									<label for="isActive">Is Approved</label>
									<form:select path="isActive" class="form-control">
										<option value="true"
											<c:if test="${user.isActive == true}">selected</c:if>>Yes</option>
										<option value="false"
											<c:if test="${user.isActive == false}">selected</c:if>>No</option>
									</form:select>

								</div>
							</div>

							<div class="col-sm-10 ">
								<div class="form-group form-group-lg">
									<label for="role">Role</label>
									<form:select path="role" class="form-control">
										<option value="Admin"
											<c:if test="${user.role == 'Admin'}">selected</c:if>>Admin</option>
										<option value="User"
											<c:if test="${user.role == 'User'}">selected</c:if>>User</option>
									</form:select>

								</div>
							</div>
						</security:authorize>


						<div class="col-sm-4">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>

						<script
							src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
						<script
							src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
						<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
						<script
							src="${pageContext.request.contextPath }/resources/js/datepicker.js"></script>
						<script
							src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js"></script>
						<script>
							$.validate({
								modules : 'location, date, security, file',
								onModulesLoaded : function() {
									$('#country').suggestCountry();
								}
							});

							$.validate({
								modules : 'security'
							});

							// Restrict presentation length
							$('#presentation').restrictLength(
									$('#pres-max-length'));
						</script>


					</div>
					<div class="col-sm-2 ">
						<div class="adSide">
							<a href="/PPCReg/user/ads/${adSide.id}"><img
								src="${pageContext.request.contextPath}/asset/${adSide.pedigreeimage.fileName }"
								width=100% height=590px></a>
						</div>
					</div>
					<div class="col-sm-2 ">
						<!--  advetisement -->

					</div>

				</form:form>
			</div>
		</div>

	</div>


</body>
<div class="adsFooter">
	<center>
		<a href="/PPCReg/user/ads/${adsFooter.id}"><img
			src="${pageContext.request.contextPath}/asset/${adsFooter.pedigreeimage.fileName }"
			width=50% height=90px></a>
	</center>
	<br>
</div>
</body>
</html>