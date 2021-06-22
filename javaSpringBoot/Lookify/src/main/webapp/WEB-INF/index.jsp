<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Haitham Abbas songsss</title>
</head>
<body>
<h1>All songs</h1>
<table>
    <thead>
        <tr>
            <th>name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songinstances}" var="song">
        <tr>
            <td><c:out value="${song.title}"/></td>
            <td><c:out value="${song.artist}"/></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/songs/delete/${song.id}">Delete</a> <a href="/songs/edit/${song.id}">Update</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<form:form action="/" method="post" modelAttribute="songinstance">
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