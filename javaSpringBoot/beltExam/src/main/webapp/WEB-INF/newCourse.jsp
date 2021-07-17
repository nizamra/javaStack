<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:message key="generic.date.toStringFormat" var="dateFormat" />
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<style>
table {
	border-collapse: collapse;
	display: table;
	border-spacing: 2px;
	border-color: gray;
}

thead {
	display: table-header-group;
	vertical-align: middle;
	border-color: inherit;
	background: hsl(200, 99%, 50%);
}

tbody {
	display: table-row-group;
	vertical-align: middle;
	border-color: inherit;
	background: hsl(170, 70%, 50%);
}

tfoot {
	display: table-footer-group;
	vertical-align: middle;
	border-color: inherit
}

table>tr {
	vertical-align: middle;
}

col {
	display: table-column
}

colgroup {
	display: table-column-group
}

tr {
	display: table-row;
	vertical-align: inherit;
	border-color: inherit
}

td, th {
	display: table-cell;
	vertical-align: inherit;
	border: 1px solid #999;
}

th {
	font-weight: bold
}

caption {
	display: table-caption;
	text-align: -webkit-center
}

td:nth-child(1) {
	background: hsl(150, 50%, 50%);
}

td:nth-child(2) {
	background: hsl(160, 60%, 50%);
}
</style>
<title>Course are created HERE</title>
</head>
<body style="width: 970px; height: 800px; margin: 45px auto;">
	<div>
		<a href="/">home</a> | <a href="/logout">Logout</a>
	</div>




	<h1>Create a new Course</h1>
	<br>


	<form:form method="post" action="/courses/new" modelAttribute="course">

		<form:label path="name">Name:
        <form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</form:label>
		<br>
		<br>

		<form:label path="instructor">Instructor:
        <form:errors path="instructor"></form:errors>
			<form:input path="instructor"></form:input>
		</form:label>
		<br>
		<br>

		<form:label path="maxPeople">Limit:
        <form:errors path="maxPeople"></form:errors>
			<form:input type="number" path="maxPeople"></form:input>
		</form:label>
		<br>
		<br>

		<input type="submit" value="Create New Course">
		<br>
	</form:form>
	<br>

</body>
</html>