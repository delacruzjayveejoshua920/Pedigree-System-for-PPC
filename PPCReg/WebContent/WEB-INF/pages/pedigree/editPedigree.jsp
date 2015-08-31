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
					<a href="/PPCReg/pedigree/ads/${displayAds.id}"><img
						src="${pageContext.request.contextPath}/asset/${displayAds.pedigreeimage.fileName }"
						width=50% height=120px></a>
				</center>
				<img
					src="${pageContext.request.contextPath }/resources/image/login.png"
					class="img-responsive" width=100%>
			</div>

			<div class="content">
				<div class="forms">
					<form:form action="${p.id }" method="POST" commandName="pedigree"
						role="form" enctype="multipart/form-data">


						<div class="col-sm-10 ">

							<div class="col-sm-12">
								<h2>Edit Pedigree</h2>
							</div>

							<security:authorize access="hasRole('User')">
								<div class="col-sm-4 ">
									<div class="form-group form-group-lg">
										<label for="registrationNo">Registration No</label>
										<form:input path="registrationNo" value="${p.registrationNo}"
											type="text" class="form-control" id="disabledInput"
											readOnly="readonly" />
									</div>
								</div>
							</security:authorize>

							<security:authorize access="hasRole('Admin')">
								<div class="col-sm-4 ">
									<div class="form-group form-group-lg">
										<label for="registrationNo">Registration No</label>
										<form:input path="registrationNo" value="${p.registrationNo}"
											type="text" class="form-control"  />
									</div>
								</div>
							</security:authorize>

							<div class="col-sm-4 ">
								<div class="form-group form-group-lg">
									<label for="dogName">Dog's Name</label>
									<form:input path="name" value="${p.name}" type="text"
										class="form-control" placeholder="Enter Dog's Name"
										data-validation="required"
										data-validation-error-msg="Name is required" />
								</div>
							</div>

							

							<div class="col-sm-4 ">
								<div class="form-group form-group-lg">
									<label for="birthdate">Birthdate</label>
									<form:input path="birthDate" value="${p.birthDate}" type="text"
										class="form-control datepicker" placeholder="Enter Birthdate" />
								</div>
							</div>

							<div class="col-sm-4 ">
								<div class="form-group form-group-lg">
									<label for="Sire">Sire</label>
									<form:select path="sire" class="form-control">
										<option value="0">Select Sire</option>
										<c:forEach items="${sireList}" var="s">
											<option value="${s.id}"
												${p.sire == s.id ? 'selected="selected"' : ''}><c:out
													value="${s.name}" /></option>
										</c:forEach>
									</form:select>
								</div>
							</div>

							<div class="col-sm-4 ">
								<div class="form-group form-group-lg">
									<label for="Sire">Dam</label>
									<form:select path="dam" class="form-control">
										<option value="0">Select Dam</option>
										<c:forEach items="${damList}" var="d">
											<option value="${d.id}"
												${p.dam == d.id ? 'selected="selected"' : ''}><c:out
													value="${d.name}" /></option>
										</c:forEach>
									</form:select>
								</div>
							</div>

							<div class="col-sm-4 ">
								<div class="form-group form-group-lg">
									<label for="breeder">Breeder</label>
									<form:input path="breeder" value="${p.breeder}" type="text"
										class="form-control" placeholder="Enter Breeder"
										data-validation="required"
										data-validation-error-msg="Breeder is required" />
								</div>
							</div>

							<div class="col-sm-4 ">
								<div class="form-group form-group-lg">
									<label for="breed">Breed</label>
									<form:input path="breed" value="${p.breed}" type="text"
										class="form-control" placeholder="Enter Breed"
										readOnly="readonly" />
								</div>
							</div>

							<div class="col-sm-4 ">
								<div class="form-group form-group-lg">
									<label for="sex">Sex</label>
									<form:select path="sex" type="text" class="form-control"
										placeholder="Enter Sex">
										<option value="Male"
											<c:if test="${p.sex== 'Male'}">selected</c:if>>Male</option>
										<option value="Female"
											<c:if test="${p.sex == 'Female'}">selected</c:if>>Female</option>
									</form:select>
								</div>
							</div>

							<div class="col-sm-4 ">
								<div class="form-group form-group-lg">
									<label for="colorMarking">Color Marking</label>
									<form:input path="colorMarking" value="${p.colorMarking}"
										type="text" class="form-control"
										placeholder="Enter Color Marking"
										data-validation-error-msg="Color Marking is required" />
								</div>
							</div>

							<div class="col-sm-4 ">
								<div class="form-group form-group-lg">
									<label for="colorMarking">Status</label>
									<form:select path="status" value="${p.status }" type="text"
										class="form-control" placeholder="Enter Status">
										<option value="-"
											<c:if test="${p.status== ''}">selected</c:if>></option>
										<option value="Champion"
											<c:if test="${p.status == 'Champion'}">selected</c:if>>Champion</option>
										<option value="Grand Champion"
											<c:if test="${p.status == 'Grand Champion'}">selected</c:if>>Grand
											Champion</option>
										<option value="Hall of Fame"
											<c:if test="${p.status == 'Hall of Fame'}">selected</c:if>>Hall
											of Fame</option>
									</form:select>
								</div>
							</div>

							<div class="col-sm-10 ">
								<div class="form-group form-group-lg">
									<label for="file">Upload <a
										href="/image/${p.pedigreeimage.id }" target="_blank">(View
											current image)</a></label> <input type="file" name="file"
										class="form-control" class="span3" />

								</div>
							</div>

							<security:authorize access="hasRole('Admin')">
								<div class="col-sm-10 ">
									<div class="form-group form-group-lg">
										<label for="isActive">Is Approved</label>
										<form:select path="isApproved" class="form-control">
											<option value="true"
												<c:if test="${p.isApproved== true}">selected</c:if>>Yes</option>
											<option value="false"
												<c:if test="${p.isApproved== false}">selected</c:if>>No</option>
										</form:select>

									</div>
								</div>
							</security:authorize>

							


							<div class="col-sm-4">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>



						</div>
						<div class="col-sm-2 ">
									<a href="/PPCReg/pedigree/ads/${adSide.id}"><img
										src="${pageContext.request.contextPath}/asset/${adSide.pedigreeimage.fileName }"
										width=100% height=590px></a>
								
							</div>
						</div>

						<div class="col-sm-2 ">
							<!--  advetisement -->

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
							$('#presentation').restrictLength(
									$('#pres-max-length'));
						</script>

					</form:form>
				</div>
			</div>

		</div>
</body>
<div class="adsFooter">
	<center>
		<a href="/PPCReg/pedigree/ads/${adsFooter.id}"><img
			src="${pageContext.request.contextPath}/asset/${adsFooter.pedigreeimage.fileName }"
			width=50% height=90px></a>
	</center>
</div>
</body>
</html>