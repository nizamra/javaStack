<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>World</title>
</head>
<body>

	<h2>Countries:</h2>
	<select name="backHomeCountry" id="subject">
		<c:forEach items="${wholeWorld}" var="cnt">
			<option value="${cnt.id}">${cnt.name}</option>
		</c:forEach>
	</select>
	<h2>Countries Local Names:</h2>
	<select name="backHomeCountry" id="subject">
		<c:forEach items="${wholeWorld}" var="cnt">
			<option value="${cnt.id}">${cnt.local_name}</option>
		</c:forEach>
	</select>
	<p>
	<p>
		listOfSlovene:
		<c:forEach items="${listOfSlovene}" var="cnt">
			<p>${cnt[0]} - ${cnt[1]} - ${cnt[2]}</p>
		</c:forEach>
		listOfCities: <select name="backHomeCountry" id="subject">
			<c:forEach items="${listOfCities}" var="cnt">
				<option>${cnt[0]}- ${cnt[1]}</option>
			</c:forEach>
		</select>
	<p>
	<p>What query would you run to get all the cities in Mexico with a
		population of greater than 500,000? Your query should arrange the
		result by population in descending order.
	<p>
		List of Mexico Cities: <select name="backHomeCountry" id="subject">
			<c:forEach items="${listOfMexCities}" var="cnt">
				<option>${cnt}</option>
			</c:forEach>
		</select>
	<p>
	<p>
	<p>What query would you run to get all languages in each country
		with a percentage greater than 89%? Your query should arrange the
		result by percentage in descending order.
	<p>
		<select name="backHomeCountry" id="subject">
			<c:forEach items="${listOfLangPerc}" var="cnt">
				<option>${cnt[0]}- ${cnt[1]}</option>
			</c:forEach>
		</select> List of Language Percentage:
	<p>
	<p>
	<p>What query would you run to get all the countries with Surface
		Area below 501 and Population greater than 100,000?
	<p>
	<p>
	<p>
	<p>What query would you run to get countries with only
		Constitutional Monarchy with a surface area of more than 200 and a
		life expectancy greater than 75 years?
	<p>
	<p>
	<p>
	<p>What query would you run to get all the cities of Argentina
		inside the Buenos Aires district and have the population greater than
		500, 000? The query should return the Country Name, City Name,
		District, and Population.
	<p>
	<p>
	<p>
	<p>What query would you run to summarize the number of countries in
		each region? The query should display the name of the region and the
		number of countries. Also, the query should arrange the result by the
		number of countries in descending order
	<p>
	<p>What query would you run to get all the countries that speak
		Slovene? Your query should return the name of the country, language,
		and language percentage. Your query should arrange the result by
		language percentage in descending order.
	<p>
	<p>
	<p>
	<p>What query would you run to display the total number of cities
		for each country? Your query should return the name of the country and
		the total number of cities. Your query should arrange the result by
		the number of cities in descending order.
	<p>
</body>
</html>