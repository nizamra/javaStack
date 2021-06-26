<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>some answer for you</title>
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
<a href="/">Home</a>
<h1> ${so2alak.question} </h1>
<h1> Tags: 
<c:forEach items="${so2alak.tags}" var="farawla">
	      			<button>${farawla.subject}</button>
			    </c:forEach></h1>
	<table>
	  <thead>
	    <tr>
	      <th>Answers</th>
	    </tr>
	  </thead>
	  <tbody>
			<c:forEach items="${so2alak.answers}" var="lubna">
			    <tr>
	      			<td>${lubna.answer}</td>
			    </tr>
		    </c:forEach>
	  </tbody>
	</table>
	<br><br><br>
	<form:form action="/answer/create/${so2alak.id}" method="post" modelAttribute="sarab">
    <p>
        <form:label path="answer">Answer</form:label>
        <form:errors path="answer"/>
        <form:input  path="answer"/>
    </p>
    <input type="submit" value="Answer it!"/>
</form:form> 
	
</body>
</html>