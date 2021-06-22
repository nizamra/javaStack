<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songs By Haitham Abbas Cousin</title>
</head>
<body>
<a href="/">Dashboard</a>

<h1>Songs By <c:out value="${searchValue}"/> </h1>
<form action="/song/searcher" method="POST">
  <label for="search">search:</label>
  <input type="text" id="search" name="search">
  <input type="submit" value="Search">
</form>

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
        <c:forEach items="${searchResult}" var="song">
        <tr>
            <td><c:out value="${song.title}"/></td>
            <td><c:out value="${song.artist}"/></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/songs/delete/${song.id}">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>