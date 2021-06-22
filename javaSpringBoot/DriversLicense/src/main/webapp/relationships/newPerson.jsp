<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New person</h1>
<form:form action="/person" method="post" modelAttribute="Person">
    <p>
        <form:label path="fname">firstName</form:label>
        <form:errors path="fname"/>
        <form:input path="fname"/>
    </p>
    <p>
        <form:label path="lname">lastName</form:label>
        <form:errors path="lname"/>
        <form:textarea path="lname"/>
    </p>

  
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>