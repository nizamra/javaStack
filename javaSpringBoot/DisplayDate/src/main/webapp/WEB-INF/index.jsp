<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/login" method="post">
		mail <input type="email" name="email">
		password <input type="password" name="password">
		<input type="submit" value="login here hahaha">
	</form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="/add_dojo" method="POST">
        <label>Your Name:</label><input type="text" name="name"><br><br>

            <label>Dojo Location</label>
            <select name="dLocation">
            <option value="San-Jose">San-Jose</option>
            <option value="saad">saad</option>
            <option value="mercei">mercei</option>
            <option value="banana">banana</option>
            </select><br><br>
            <label>Favoriet language</label>
            <select name="fLang">
            <option value="python">python</option>
            <option value="c++">c++</option>
            <option value="JAva">Java</option>
            <option value="Mern">MERN</option>
            </select><br><br>
            <label>add a comment(optional)</label>
            <textarea name="comment"></textarea>
            <br>
            <br>
            <input type="submit" value="add Dojo">

        </form>

</body>
</html>