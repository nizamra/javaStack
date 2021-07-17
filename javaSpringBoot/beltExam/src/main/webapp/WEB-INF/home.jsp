<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Regester With Tareq Hamarsheh</title>
</head>
<body style="width: 970px; height: 800px; margin: 45px auto;">

	<form:form action="/register" method="post" modelAttribute="newGuest">
		<div class="form-group">
			<label>User Name:</label>
			<form:input path="firstName" class="form-control" />
			<form:errors path="firstName" class="text-danger" />
		</div>
		<br>
		<div class="form-group">
			<label>User Last Name:</label>
			<form:input path="lastName" class="form-control" />
			<form:errors path="lastName" class="text-danger" />
		</div>
		<br>
		<div class="form-group">
			<label>Email:</label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" class="text-danger" />
		</div>
		<br>
		<div class="form-group">
			<label>location:</label>
			<form:input path="location" class="form-control" />
			<form:errors path="location" class="text-danger" />
		</div>
		<br>
		<div class="form-group">
			<label>Password:</label>
			<form:password path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
		</div>
		<br>
		<div class="form-group">
			<label>Confirm Password:</label>
			<form:password path="confirm" class="form-control" />
			<form:errors path="confirm" class="text-danger" />
		</div>
		<br>
		<input type="submit" value="Register" class="btn btn-primary" />
	</form:form>
	<br>
	<br>

	<form:form action="/login" method="post" modelAttribute="newLogin">
		<div class="form-group">
			<label>Email:</label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" class="text-danger" />
		</div>
		<br>
		<div class="form-group">
			<label>Password:</label>
			<form:password path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
		</div>
		<br>
		<input type="submit" value="Login" class="btn btn-success" />
	</form:form>

</body>
</html>