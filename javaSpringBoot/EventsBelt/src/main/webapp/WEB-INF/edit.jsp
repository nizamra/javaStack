<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing Events</title>
</head>
<body>
<a href="/">Home</a>
	<h1>Edit Event: ${SomeEvent.name}</h1>
	<%-- <script>
		var time = "<fmt:formatDate pattern = 'yyyy-MM-dd' value ='${SomeEvent.date}' />"
		alert(time)
	</script>--%>
	<form:form action="/editevents/${SomeEvent.id}" method="post"
		modelAttribute="wxyz">
		<input type="hidden" name="_method" value="put">
		<form:input type="hidden" path="host" value="${SomeEvent.host}"/>
		<form:input type="hidden" path="usersAttending" value="${SomeEvent.usersAttending}"/>
		<p>

			<form:label path="name">name</form:label>
			<form:errors path="name" />
			<form:input path="name" value="${SomeEvent.name}" />
		</p>
		<%-- <c:set var="time" value="EEE, d MMM YYYY"/>--%>
		<p>
			<form:label path="date">date</form:label>
			<form:errors path="date" />
			<form:input path="date" value="${SomeEvent.date }" />
		</p>
		<p>
			<form:label path="location">location</form:label>
			<form:errors path="location" />
			<form:input path="location" value="${SomeEvent.location}" />
		</p>
		<p>
			<form:label path="state">State</form:label>
			<form:errors path="state" />
			<form:input path="state" value="${SomeEvent.state}" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>