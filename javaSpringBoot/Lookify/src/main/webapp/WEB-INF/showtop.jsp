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
<a href="/songs/new">addnew</a>
<a href="/songs/top">Top Tens</a>


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
        <c:forEach items="${baram}" var="song">
        <tr>
            <td><c:out value="${song.title}"/></td>
            <td><c:out value="${song.artist}"/></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/songs/delete/${song.id}">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
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
        <c:forEach items="${baramas}" var="song">
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