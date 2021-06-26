<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Question</title>
</head>
<body>
<h1>Whats Your Question</h1>
<form:form action="/question/create" method="post" modelAttribute="amal">
    <p>
        <form:label path="question">Question</form:label>
        <form:errors path="question"/>
        <form:input  path="question"/>
    </p>
    <p>
    	tags
		<input name="tagss" title="separate by comma: PC, STP, IP"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>