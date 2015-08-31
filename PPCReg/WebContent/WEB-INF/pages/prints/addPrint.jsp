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
					<a href="/PPCReg/print/ads/${displayAds.id}"><img
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
				<form:form action="/PPCReg/print/success" method="POST" commandName="print"
					role="form">


					<div class="col-sm-10 ">

						<div class="col-sm-12">
							<h2>Add Print</h2>
						</div>

						<div class="col-sm-10 ">
								<div class="form-group form-group-lg">
									<label for="advertiser">Name</label>
									<form:select path="user.id" items="${users}" itemValue="id"
										itemLabel="completeName" class="form-control" />
								</div>
							</div>

							<div class="col-sm-10 ">
								<div class="form-group form-group-lg">
									<label for="dogname">Dog's Name</label>
									<form:select path="pedigree.id" items="${dog}"
										cssClass="form-control" itemLabel="name" itemValue="id" />
								</div>
							</div>

						<div class="col-sm-10">
							<div class="form-group">
								<label for="dateIssue">Date Issue</label>
								<form:input path="dateIssue" type="text" required="required" 
									class="form-control datepicker" placeholder="yyyy-MM-dd" />
							</div>
						</div>

						

						<security:authorize access="hasRole('Admin')">
							<div class="col-sm-10 ">
								<div class="form-group form-group-lg">
									<label for="isActive">Is Approved</label>
									<form:select path="isActive" class="form-control">
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
							<a href="ads/${adSide.id}"><img
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
		<a href="ads/${adsFooter.id}"><img
			src="${pageContext.request.contextPath}/asset/${adsFooter.pedigreeimage.fileName }"
			width=50% height=90px></a>
	</center>
	<br>
</div>
</body>
</html>