<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
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
					<a href="/PPCReg/pedigree/ads/${displayAds.id}"><img
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
				<form:form action="add/success" method="POST" commandName="pedigree"
					enctype="multipart/form-data" role="form">


					<div class="col-sm-10 ">

						<div class="col-sm-12">
							<h2>Add Pedigree</h2>
						</div>

						<security:authorize access="hasRole('Admin')">
							<div class="col-sm-4 ">
								<div class="form-group form-group-lg">
									<label for="registrationNo">Registration No</label>
									<form:input path="registrationNo" placeholder="Enter Registration No" value="${p.registrationNo}"
										type="text" class="form-control" id="disabledInput" />
								</div>
							</div>
						</security:authorize>

						<div class="col-sm-4 ">
							<div class="form-group form-group-lg">
								<label for="dogName">Dog's Name</label>
								<form:input path="name" type="text" class="form-control"
									placeholder="Enter Dog's Name" data-validation="length"
									data-validation-length="1-90" />
							</div>
						</div>


						<div class="col-sm-4 ">
							<div class="form-group form-group-lg">
								<label for="birthdate">Birthdate</label>
								<form:input path="birthDate" type="text"
									class="form-control datepicker" placeholder="Enter Birthdate"
									data-validation="required"
									data-validation-error-msg="Date of Birth is required" />
							</div>
						</div>

						<div class="col-sm-4 ">
							<div class="form-group form-group-lg">
								<label for="Sire">Sire</label>
								<form:select path="sire" class="form-control">
									<option value="0">Select Sire</option>
									<c:forEach items="${sireList}" var="s">
										<option value="${s.id}"><c:out value="${s.name}" /></option>
									</c:forEach>
								</form:select>
							</div>
						</div>

						<div class="col-sm-4 ">
							<div class="form-group form-group-lg">
								<label for="Dam">Dam</label>
								<form:select path="dam" class="form-control">
									<option value="0">Select Dam</option>
									<c:forEach items="${damList}" var="d">
										<option value="${d.id}"><c:out value="${d.name}" /></option>
									</c:forEach>
								</form:select>
							</div>
						</div>

						<div class="col-sm-4 ">
							<div class="form-group form-group-lg">
								<label for="breeder">Breeder</label>
								<form:input path="breeder" type="text" class="form-control"
									placeholder="Enter Breeder" data-validation="required"
									data-validation-error-msg="Address is required" />
							</div>
						</div>

						<div class="col-sm-4 ">
							<div class="form-group form-group-lg">
								<label for="breed">Breed</label>
								<form:input path="breed" type="text" class="form-control"
									placeholder="Enter Breed" value="American Bully"
									readOnly="readonly" />
							</div>
						</div>

						<div class="col-sm-4 ">
							<div class="form-group form-group-lg">
								<label for="sex">Sex</label>
								<form:select path="sex" type="text" class="form-control"
									placeholder="Enter Sex">
									<option value="Male">Male</option>
									<option value="Female">Female</option>
								</form:select>
							</div>
						</div>

						<div class="col-sm-4 ">
							<div class="form-group form-group-lg">
								<label for="colorMarking">Color Marking</label>
								<form:input path="colorMarking" type="text" class="form-control"
									placeholder="Enter Color Marking" data-validation="required"
									data-validation-error-msg="Color Marking is required" />
							</div>
						</div>

						<div class="col-sm-4 ">
							<div class="form-group form-group-lg">
								<label for="colorMarking">Status</label>
								<form:select path="status" type="text" class="form-control"
									placeholder="Enter Status">
									<option value="">-</option>
									<option value="Champion">Champion</option>
									<option value="Grand Champion">Grand Champion</option>
									<option value="Hall of Fame">Hall of Fame</option>
								</form:select>
							</div>
						</div>

						<div class="col-sm-10 ">
							<div class="form-group form-group-lg">
								<label for="file">Upload</label> <input type="file" name="file"
									class="form-control" class="span3" data-validation="mime size"
									data-validation-allowing="jpg, png, gif" />

							</div>
						</div>

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

						
						


						<div class="col-sm-4">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>



					</div>
					<div class="col-sm-2 ">
						<div class="adSide">
							<a href="/PPCReg/pedigree/ads/${adSide.id}"><img
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/js/datepicker.js"></script>
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
		$('#presentation').restrictLength($('#pres-max-length'));
	</script>
</body>
<div class="adsFooter">
		<center>
			<a href="/PPCReg/pedigree/ads/${adsFooter.id}"><img
				src="${pageContext.request.contextPath}/asset/${adsFooter.pedigreeimage.fileName }"
				width=50% height=90px></a>
		</center>
		<br>
	</div>
</body>
</html>