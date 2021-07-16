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
<title>Insert title here</title>
</head>
<body style="width: 970px; height: 800px; margin: 45px auto;">
	<%-- theLogedInUser allEvents --%>
	<h2>Welcome ${theLogedInUser.firstName} From:
		${theLogedInUser.location} - ${theLogedInUser.state}</h2>

	<a href="/logout">LogOut</a>
	<br>
	<br> events in this state
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>State</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${kolelEventat3indak}" var="nizar">
				<tr>
					<td><a href="/show/event/${ nizar.id } "> ${nizar.name} </a></td>
					<td><fmt:formatDate type="date" value="${nizar.date}" /></td>

					<%--<td><c:out value="${nizar.date.format(DateTimeFormatter.ofPattern('EEEE-dd-MMMM-yyyy'))}"></c:out></td>
					<td><fmt:formatDate type ="time" value ="${nizar.date}" /></td>
					<td><fmt:formatDate type ="both" value ="${nizar.date}" /></td>
					<td><fmt:formatDate pattern = "yyyy-MM-dd" value ="${nizar.date}" /></td>--%>

					<td><c:out value="${nizar.location}"></c:out></td>
					<td><c:out value="${nizar.state}"></c:out></td>
					<td><c:out value="${nizar.host.firstName}"></c:out></td>
					<td><c:choose>
							<c:when test="${ nizar.host.id eq theLogedInUser.id }">
								<p>
									<a href="/edit/event/${ nizar.id } "> Edit</a> <a
										href="/delete/event/${ nizar.id }">Delete</a>
								</p>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when
										test="${ theLogedInUser.attendingEvents.contains(nizar)}">
										<p>
											Joining <a href="/cancel/event/${ nizar.id }">Cancel</a>
										</p>

									</c:when>
									<c:otherwise>
										<p>
											<a href="/join/event/${ nizar.id }">Join</a>
										</p>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br> events in other states
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>state</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${kolelEventatMish3indak}" var="banat">
				<tr>
					<td><a href="/show/event/${ banat.id } "> ${banat.name} </a></td>
					<td><fmt:formatDate pattern="MM dd yyyy" value="${banat.date}" /></td>
					<td><c:out value="${banat.location}"></c:out></td>
					<td><c:out value="${banat.state}"></c:out></td>
					<td><c:out value="${banat.host.firstName}"></c:out></td>
					<td><c:choose>
							<c:when test="${ banat.host.id eq theLogedInUser.id }">
								<p>
									<a href="/edit/event/${ banat.id } "> Edit</a> <a
										href="/delete/event/${ banat.id }">Delete</a>
								</p>
							</c:when>

							<c:when test="${banat.usersAttending.contains(theLogedInUser)}">
								<p>
									Joining <a href="/cancel/event/${ banat.id }">Cancel</a>


								</p>

							</c:when>
							<c:otherwise>
								<p>
									<a href="/join/event/${ banat.id }">Join</a>
								</p>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>

	<form:form action="/event/new" method="post" modelAttribute="newEvent">
		<div class="form-group">
			<label>Name:</label>
			<form:input path="name" class="form-control" />
			<form:errors path="name" class="text-danger" />
		</div>
		<br>
		<div class="form-group">
			<label>Date:</label>
			<%-- <fmt:formatDate pattern = "MM-dd-yyyy" value = "date" /> --%>
			<form:input type="date" path="date" class="date" />
			<form:errors path="date" class="text-danger" />
		</div>
		<br>
		<div class="form-group">
			<label>Location:</label>
			<form:input path="location" class="form-control" />
			<form:errors path="location" class="text-danger" />
		</div>
		<br>
		<div class="form-group">
			<label>state:</label>
			<form:input path="state" class="form-control" />
			<form:errors path="state" class="text-danger" />
		</div>
		<br>
		<input type="submit" value="Create Event" class="btn btn-primary" />
	</form:form>
</body>
</html>