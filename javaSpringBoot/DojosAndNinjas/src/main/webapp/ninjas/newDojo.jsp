<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New person</h1>
<form:form action="/dojos" method="post" modelAttribute="Dojo">
    <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
   
  
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>