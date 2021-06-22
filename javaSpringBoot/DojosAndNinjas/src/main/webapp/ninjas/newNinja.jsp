<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New person</h1>
<form:form action="/ninjas" method="post" modelAttribute="Ninja">
       <p>
        <form:label path="firstName">firstName</form:label>
        <form:errors path="firstName"/>
        <form:input  path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">lastName</form:label>
        <form:errors path="lastName"/>
        <form:textarea path="lastName"/>
    </p>
    <p>
        <form:label path="age">age</form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/>
    </p>
 <p>
        <form:label path="dojo">Dojo</form:label>
        <form:errors path="dojo"/>
        <form:select path="dojo">
        	<c:forEach items="${x }" var="dojo">
            <form:option value="${dojo.getId() }">${dojo.name }</form:option>
            </c:forEach>
        </form:select>
    </p>
   
  
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>