<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New License</h1>
<form:form action="/license" method="post" modelAttribute="License">

    <p>
        <form:label path="expirationdate">expirationdate</form:label>
        <form:errors path="expirationdate"/>
        <form:input type="date"  path="expirationdate"/>
    </p>
    <p>
        <form:label path="state">state</form:label>
        <form:errors path="state"/>
        <form:textarea path="state"/>
    </p>
 <p>
        <form:label path="person">person</form:label>
        <form:errors path="person"/>
        <form:select path="person">
        	<c:forEach items="${x }" var="person">
            <form:option value="${person.getId() }">${person.fname }_${person.lname }</form:option>
            </c:forEach>
        </form:select>
    </p>
  
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>