<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.raj {    
	background-image: linear-gradient(to bottom right,Red, Orange, Yellow ,white, Blue,Green  , Indigo, Violet);
}</style>
</head>
<body >
	<div class="raj">
	<c:if test="${not empty sessionScope.user}">
	
		<h3>
			Hii,
			<c:out value="${sessionScope.user.firstName}"></c:out></h3>
			
			 <h4>
			 <a href="<c:url value="/ctl/User"/>" style="color: black; ">Add User</a> | <a
				href="<c:url value="/ctl/UserList"/>" style="color: black ">User List</a> | <a
				href="<c:url value="/Login?operation=logout"/>" style="color: black ">Logout</a>
				</h4>
		
	</c:if>
	<c:if test="${empty sessionScope.user}">
		<h3>Hii, Guest</h3>
		<a href="Login" style="color: black ">Login User</a>
	</c:if>
	<hr>
	</div>
</body>
</html>