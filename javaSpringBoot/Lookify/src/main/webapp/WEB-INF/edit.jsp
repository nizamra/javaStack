<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Book</h1>
<form:form action="/songs/${songinstance.id}" method="post" modelAttribute="songinstance">
    <input type="hidden" name="_method" value="put">
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
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>