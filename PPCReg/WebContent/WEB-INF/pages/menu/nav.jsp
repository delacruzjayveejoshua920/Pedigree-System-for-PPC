<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">PPC - PBKC</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="#">Home</a></li>
						<li><a href="/PPCReg/pedigree/list">Pedigree</a></li>
						<li class="active"><a href="/PPCReg/advertisement/list">Advertisement</a></li>
						<li><a href="/PPCReg/print/list">Print</a></li>
						<li><a href="/PPCReg/user/list">User</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<!--  icons -->
						<li><a href="#"><span class="glyphicon glyphicon-user"></span>Welcome,
								${loginheader}</a></li>
						<li><a href="<c:url value="/logout"  />"><span class="glyphicon glyphicon-log-out"></span>
								Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>
</body>
</html>