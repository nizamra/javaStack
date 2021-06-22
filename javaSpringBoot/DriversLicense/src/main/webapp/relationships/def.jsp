<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>***************************************</h1>
<c:forEach items="${x }" var="i">
<c:out value="${i.fname }"></c:out>
<br>
</c:forEach>
<h1>***************************************</h1>
<c:forEach items="${xg }" var="i">
<c:out value="${i.state }"></c:out>

<c:out value="${i.person.fname }"></c:out>
<c:out value="${i.getNumber() }"></c:out>


<br>
</c:forEach>
</body>
</html>