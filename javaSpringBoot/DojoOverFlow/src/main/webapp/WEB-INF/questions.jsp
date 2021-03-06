<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions By Khamees</title>
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

table > tr {
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
td:nth-child(1) { background: hsl(150, 50%, 50%); }
td:nth-child(2) { background: hsl(160, 60%, 50%); }
</style>
</head>
<body>
<a href="/logout">LogOut</a>

<h1> Questions Dashboard</h1>
<h1> Logged in as: ${logedInUser.email}</h1>
	<table>
	  <thead>
	    <tr>
	      <th>number</th>
	      <th>Question</th>
	      <th>Tags</th>
	      <th>Action</th>
	    </tr>
	  </thead>
	  <tbody>
		  <c:forEach items="${kolesso2alat}" var="samar">
		    <tr>
		      <td><c:out value="${samar.id}"></c:out></td>
		      <td><a href="/question/${samar.id}"><c:out value="${samar.question}"></c:out></a></td>
				<td><c:forEach items="${samar.tags}" var="lubna">
	      			${lubna.subject}, 
			    </c:forEach></td>
			    <td><a href="/question/delete/${samar.id}">Delete</a></td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	<a href="/question/new">New Question</a>
</body>
</html>