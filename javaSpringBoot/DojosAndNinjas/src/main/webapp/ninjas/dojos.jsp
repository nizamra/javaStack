<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Dojo name is <c:out value="${x.name }"></c:out></h1>
<table class="table">
  <thead>
    <tr>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Age</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${xg }" var="ninja">
  
    <tr>
      <td><c:out value="${ninja.firstName }"></c:out></td>
      <td><c:out value="${ninja.lastName }"></c:out></td>
      <td><c:out value="${ninja.age }"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>