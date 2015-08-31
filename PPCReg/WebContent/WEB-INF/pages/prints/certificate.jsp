<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/ppc certificate.css">

<style>
@page {
	size: size:11in 8.5in; /* auto is the initial value */
	/* this affects the margin in the printer settings */
	margin: 0mm 0mm 0mm 0mm;
}

body {
	background:
		url("${pageContext.request.contextPath }/resources/image/ppc certificate.png");
	background-size: 1000px 780px;
	background-repeat: no-repeat;
	-webkit-print-color-adjust: exact;
}

.header {
	height: 120px;
}

.main {
	height: 360px;
}

.childName {
	width: 140px;
	font-size: 16px;
	margin-top: -20px;
	font-weight: bold;
	font-family: Aparajita Bold;
	position: absolute;
}

.pedigreeborder {
	border-left: solid thick;
	border-top: solid thick;
	border-bottom: solid 7px black;
}

.issuedate {
	margin-top: -43px;
	margin-left: 617px;
	color: white;
	font-size: 9px;
}

.pedigreeTable {
	color: black;
	font-size: 14px;
	width: 500px;
	margin-top: -150px;
	margin-left: 334px;
	padding: 0px;
	vertical-align: bottom;
	text-align: center;
	font-family: Time new roman;
	font-size: 16px;
	font-weight: bold;
}

.pedigreeTableTwo {
	color: black;
	font-size: 16px;
	width: 500px;
	margin-top: 20px;
	margin-left: 334px;
	padding: 0px;
	font-weight: bold;
	vertical-align: bottom;
	text-align: center;
}

.pedigreeParentDetails {
	color: black;
}

th, td {
	padding: 0px;
}

.damParent {
	
}

.footer {
	
}

td {
	padding: 0px;
}

.select {
	width: 20px;
}

table {
	margin-left: 260px;
	margin-top: -19px;
	color: #e2ef57;
	font-size: 13px;
	font-family: Time new roman;
	font-weight: bold;
}

/* top   */
.pedigreechild {
	margin-left: 130px;
	margin-top: 100px;
	padding: 0px;
}

.footer {
	height: 190px;
}
</style>
</head>
<body>

	<div id="container">

		<div class="header"></div>

		<div class="main">
			<!-- Child -->
			<div class="pedigreechild">
				<img
					src="${pageContext.request.contextPath}/asset/${p.pedigreeimage.fileName }"
					width=125px height=125px /> <br>
				<div class="childName">
					<p>
						${p.name} <font size=2>(${p.colorMarking })</font>
					</p>
				</div>
			</div>



			<!-- Sire -->
			<c:forEach items="${sireList}" var="s">
				<c:if test="${s.id == p.sire}">



					<!-- table sire -->
					<c:forEach items="${sireList}" var="s">
						<c:if test="${s.id == p.sire}">
							<table class="pedigreeTable">
								<tr>
									<td></td>
									<td valign="bottom">
									<c:choose>
									  <c:when test="${s.sire > 0}">
										
									<c:forEach items="${sireList}"
											var="sGrandParent">
											<c:if test="${s.sire == sGrandParent.id}">
												<!--  grandparent sire of parent sire -->
													${sGrandParent.name}
													<!-- grandparent -->

											</c:if>
											
										</c:forEach>
										</c:when>
										<c:otherwise>N/A</c:otherwise>
										</c:choose>
										</td>
										
								</tr>
								<tr>

									<td width=250px style="padding: 13px">
										<!-- SIRE PARENTS --> ${s.name}<br> <font size="2">(${s.colorMarking})</font>

									</td>
									<td class="pedigreeborder"></td>
								</tr>
								<tr>
									<td></td>


									<td class="borderbuttom">
											<c:choose>
												<c:when test="${s.sire > 0}">
												    <c:forEach items="${damList}"
											var="sGrandParent2">
													<c:if test="${s.dam == sGrandParent2.id}">
														<!--  grandparent dam of parent sire -->
												
														${sGrandParent2.name} 
														<!-- grandparent -->
														
													</c:if>
													</c:forEach>
												</c:when>
												<c:otherwise>N/A</c:otherwise>
											</c:choose>
										</td>



								</tr>

								<tr>
									<td style="padding: 20px">PARENTS</td>
									<td>GRANDPARENTS</td>
								</tr>

								<c:forEach items="${damList}" var="d">
									<c:if test="${s.id == p.sire}">
										<tr>

										</tr>
									</c:if>
								</c:forEach>
							</table>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>

			<!-- end of table sire -->

			<c:forEach items="${damList}" var="d">
				<c:if test="${d.id == p.dam}">
					<!-- table dam -->
					<c:forEach items="${damList}" var="d">
						<c:if test="${d.id == p.dam}">
							<table class="pedigreeTableTwo">
								<tr>
									<td></td>
									<td valign="bottom">
									<c:choose>
									<c:when test="${d.dam > 0}">
									<c:forEach items="${sireList}"
											var="sGrandParent">
											<c:if test="${d.sire == sGrandParent.id}">
												<!--  grandparent sire of parent sire -->
													${sGrandParent.name}
													<!-- grandparent -->


											</c:if>
										</c:forEach>
									
									</c:when>
									<c:otherwise>N/A</c:otherwise>
									</c:choose>
									
									</td>
								</tr>
								<tr>

									<td width=250px style="padding: 13px">
										<!-- SIRE PARENTS --> ${d.name}<br> <font size="2">(${d.colorMarking})</font>

									</td>
									<td class="pedigreeborder"></td>
								</tr>
								<tr>
									<td></td>
									<td class="borderkuttom">
									
									<c:choose>
									<c:when test="${d.dam gt 0}">
									<c:forEach items="${damList}"
											var="dGrandParent2">
											<c:if test="${d.dam == dGrandParent2.id}">
												<!--  grandparent dam of parent sire -->
												
														${dGrandParent2.name} 
														<!-- grandparent -->

											</c:if>

										</c:forEach>
									</c:when>
									<c:otherwise>N/A</c:otherwise>
									</c:choose>
									</td>
								</tr>


								<c:forEach items="${damList}" var="d">
									<c:if test="${s.id == p.sire}">
										<tr>

										</tr>
									</c:if>
								</c:forEach>
							</table>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>





			<!--  end of sire -->


		</div>

		<div class="footer">
			<div class="footer-pedigree-info">
				<table class="table">
					<thead>
						<tr>
							<td>Registration No</td>
							<td>:</td>
							<td>${p.registrationNo }</td>
						</tr>

						<tr>
							<td>Pedigree For</td>
							<td>:</td>
							<td>${p.name }</td>
						</tr>

						<tr>
							<td>Breeder</td>
							<td>:</td>
							<td>${p.breeder }</td>
						</tr>

						<tr>
							<td>Owner</td>
							<td>:</td>
							<td>${p.user.firstName}&nbsp${p.user.lastName}</td>
						</tr>

						<tr>
							<td>Address</td>
							<td>:</td>
							<td width="180px">${p.user.address}</td>
						</tr>

						<tr>
							<td>Breed</td>
							<td>:</td>
							<td>${p.breed}</td>
						</tr>

						<tr>
							<td>Date of Birth</td>
							<td>:</td>
							<td><fmt:formatDate pattern="MMMM d, y"
									value="${p.birthDate}" /></td>
						</tr>

						<tr>
							<td>Sex</td>
							<td>:</td>
							<td>${p.sex}</td>
						</tr>

						<tr>
							<td>Color Marking</td>
							<td>:</td>
							<td>${p.colorMarking}</td>
						</tr>
					</thead>
				</table>
			</div>
		</div>

		<p class="issuedate">

			<fmt:formatDate pattern="y" value="${print.dateIssue}" />
		</p>
	</div>
</body>
</html>