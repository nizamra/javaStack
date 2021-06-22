<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Haitham is adding a song</title>
</head>
<body>
<h1>New Song</h1>
<a href="/">dashboard</a>








<form:form action="/song/add" method="post" modelAttribute="songinstance">
    <p>
        <form:label path="title">title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="artist">artist</form:label>
        <form:errors path="artist"/>
        <form:textarea path="artist"/>
    </p>
    <p>
        <form:label path="rating">rating</form:label>
        <form:errors path="rating"/>
        <form:input path="rating"/>
    </p>   
    <input type="submit" value="Add Song"/>
</form:form>    

</body>
</html>