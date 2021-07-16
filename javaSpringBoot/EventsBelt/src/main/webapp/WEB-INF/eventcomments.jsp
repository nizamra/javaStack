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
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="main"
		style="display: flex; ' width: 970px; height: 800px;">
<a href="/">Home</a>
		<div style="width: 750px">
			<h1>
				Event Name:
				<c:out value="${thisSomeEventinstance.getName()}"></c:out>
			</h1>
			<p>
				Host name:
				<c:out value="${thisSomeEventinstance.getHost().getFirstName()}"></c:out>
			</p>
			<p>
				Date:
				<fmt:formatDate pattern="yyyy-MM-dd"
					value="${thisSomeEventinstance.getDate()}" />
			</p>
			<p>
				Location:
				<c:out value="${thisSomeEventinstance.getLocation()}"></c:out>
			</p>
			<p>
				<c:out value="${thisSomeEventinstance.getUsersAttending().size()}"></c:out>
				attendees
			</p>
			<table class="table" style="width: 500px" class="table table-dark">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Location</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${thisSomeEventinstance.getUsersAttending() }"
						var="usersAttending">
						<tr>
							<th scope="row"><c:out
									value="${usersAttending.getFirstName()}"></c:out> <c:out
									value="${usersAttending.getLastName()}"></c:out></th>
							<td><c:out value="${usersAttending.getLocation()}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div style="width: 700px">
			<h1>All Comments</h1>
			<div class="log">
				<label>users comments:</label>

				<div contenteditable="true"
					style="overflow-y: scroll; border: solid black 1px;">
					<c:forEach items="${thisSomeEventinstance.getMesComments()}"
						var="comment">
						<p>
							<c:out value="${comment.getWriter().getFirstName()}"></c:out>
							:
							<c:out value="${comment.getComment()}"></c:out>
						</p>
						<p>
							<c:out value="*********************************"></c:out>
						</p>
					</c:forEach>
				</div>
			</div>
			<br> <br> <br>
			<%--<c:when test="${thisSomeEventinstance.usersAttending.contains(theLogedInUser)}">
			<c:forEach items="${thisSomeEventinstance.usersAttending}"
				var="atendeeses">
				<c:choose>
					<c:when test="${ atendeeses.id == theLogedInUser.id}">--%>
						<form:form action="/newCommentCreation" method="post"
							modelAttribute="commentCreation">
							<form:input type="hidden" path="writer" value="${theLogedInUser.id}"/>
							
							<form:input type="hidden" path="event" value="${thisSomeEventinstance.id}"/>
							<p>
								<form:label path="comment">Comment</form:label>
								<form:errors path="comment" />
								<form:textarea path="comment" />
							</p>
							<input type="submit" value="Submit" />
						</form:form>
					<%--</c:when>
					<c:otherwise>
						<p>You can't create a comment since you're not attending this
							event</p>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			--%>
		</div>
	</div>
</body>
</html>