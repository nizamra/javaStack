<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>

	<div class="container">

		<div>
			<a href="/">home</a> | <a href="/logout">Logout</a>
		</div>

		<h1 class="title">Create a new course</h1>


		<section>
			<div class="columns">
				<div class="column">

					<form:form method="POST" action="/courses/update"
						modelAttribute="course">
						<form:input path="id" type="hidden" />
						<form:input path="guests" type="hidden" />
						<table>
							<tr>
								<td><form:label path="name">Name:</form:label></td>
								<td><form:input path="name" class="input" /></td>
								<td><form:errors path="name" /></td>
							</tr>

							<tr>
								<td><form:label path="instructor">Instructor:</form:label></td>
								<td><form:input path="instructor" class="input" /></td>
								<td><form:errors path="instructor" /></td>
							</tr>
							<tr>
								<td><form:label path="maxPeople">Capacity:</form:label></td>
								<td><form:input path="maxPeople" class="input"
										type="number" /></td>
								<td><form:errors path="maxPeople" /></td>
							</tr>
						</table>
						<div class="buttons has-addons">
							<input type="submit" value="Update" class="button" />
						</div>
					</form:form>

				</div>
				<div class="column"></div>
			</div>

		</section>


	</div>
</body>
</html>