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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/loginlayout.css">
<script
	src="${pageContext.request.contextPath }/resources/js/datepicker.js"></script>

<style type="text/css">
.flable {
	color: gray;
}

.status {
	font-family: verdana;
	font-size: 12px;
}

.uname {
	color: blue;
}

#status {
	color: white;
}
</style>

<!--  
<script src="${pageContext.request.contextPath }/resources/js/jquery.js" type="text/javascript"></script>  
 <script type="text/javascript">  
          $(document).ready(function(){  
              $("#uname").change(function(){  
                  var uname = $(this).val();  
                  if(uname.length >= 3){  
                      $("#status").html("<font color=gray> Checking availability...</font>");  
                       $.ajax({  
                          type: "POST",  
                          url: "check",  
                          data: "uname="+ uname,  
                          success: function(msg){  
  
                              $("#status").ajaxComplete(function(event, request, settings){  
                                      
                                  $("#status").html(msg);  
  
                              });  
                          }  
                      });   
                  }  
                  else{  
                         
                      $("#status").html("<font color=red>Username should be <b>3</b> character long.</font>");  
                  }  
                    
              });  
          });  
          
          function validateForm() {
        	  var username = document.forms["myForm"]["uname"].value;
        	  var status = document.forms["myForm"]["status"].innerHTML;
        	  if(status == "This username is already in use"){
        		  alert(status);
        		  return false;
        	  }
        	  
        	  
        	  
        	  
          }
          
         
        </script>  
-->

</head>

<body>
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
					<script>
						alert("Incorrect username or password");
					</script>

				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
					<script>
						alert("Incorrect username or password");
					</script>
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
					<button type="submit" class="btn btn-default">Sign In</button>
					<a href="<c:url value="/register"  />"><button type="button"
							class="btn btn-default">Sign Up</button></a>
				</form>
			</div>
		</div>
	</div>
	<div class="header">
		<div class="adsHeader">
			<center>
				<a href="ads/${displayAds.id}"><img
					src="${pageContext.request.contextPath}/asset/${displayAds.pedigreeimage.fileName }"
					width=50% height=190px></a>
			</center>
		</div>
	</div>

	<div class="content">
		<div class="forms">
			<form:form name="myForm" action="registrationProcess" method="POST"
				commandName="register" role="form" autocomplete="off">


				<div class="col-sm-10 ">

					<div class="col-sm-12">
						<h2>Create your account</h2>
					</div>

					<div class="col-sm-3 ">
						<div class="form-group form-group-lg">
							<label for="firstName">First Name</label>
							<form:input path="firstName" name="fname" type="text"
								class="form-control" placeholder="Enter First Name"
								required="required" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="lastName">Last Name</label>
							<form:input path="lastName" type="text" class="form-control"
								placeholder="Enter Last Name" required="required" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="middleName">Middle Name</label>
							<form:input path="middleName" type="text" class="form-control"
								placeholder="Enter Middle Name" required="required" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="middleName">Gender</label>
							<form:select path="gender" class="form-control">
								<option>Male</option>
								<option>Female</option>
							</form:select>
						</div>
					</div>


					<div class="col-sm-8">
						<div class="form-group">
							<label for="address">Address</label>
							<form:input path="address" type="text" class="form-control"
								placeholder="Enter Address" required="required" />
						</div>
					</div>

					<div class="col-sm-4">
						<div class="form-group">
							<label for="birthdate">Birthday</label>
							<form:input path="birthDate" type="text"
								class="form-control datepicker" placeholder="Enter Birthday" />
						</div>
					</div>

					<div class="col-sm-4">
						<div class="form-group">
							<label for="contactNo">Contact Number</label>
							<form:input path="contactNo" type="text" class="form-control"
								placeholder="Enter Contact Number" required="required" />
						</div>
					</div>

					<div class="col-sm-4">
						<div class="form-group">
							<label for="kennelName">Kennel Name</label>
							<form:input path="kennelName" type="text" class="form-control"
								placeholder="Enter Kennel Name" required="required" />
						</div>
					</div>

					<div class="col-sm-4">
						<div class="form-group">
							<label for="kennelName">Email</label>
							<form:input path="email" type="email" class="form-control"
								placeholder="Enter Email" required="required" />
						</div>
					</div>

					<div class="col-sm-4">
						<div class="form-group">
							<label for="username">Username</label>
							<form:input path="username" id="uname" type="text"
								placeholder="Enter Username" class="form-control"
								required="required" />
							<p id="status"></p>
						</div>
					</div>

					<div class="col-sm-4">
						<div class="form-group">
							<label for="password">Password</label>
							<form:input path="password" data-validation="length"
								data-validation-length="min8" type="password"
								class="form-control" placeholder="Enter Password" />
						</div>
					</div>

					<div class="col-sm-4">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>



				</div>
				<div class="col-sm-2 "></div>

				<div class="col-sm-2 ">
					<a href="ads/${adSide.id}"><img
						src="${pageContext.request.contextPath}/asset/${adSide.pedigreeimage.fileName }"
						width=100% height=590px></a>

				</div>

			</form:form>
		</div>
	</div>

	<div class="footer">
		<div class="adsFooter">
			<center>
				<a href="ads/${adsFooter.id}"><img
					src="${pageContext.request.contextPath}/asset/${adsFooter.pedigreeimage.fileName }"
					width=50% height=90px></a>
			</center>
		</div>


	</div>



</body>

</html>