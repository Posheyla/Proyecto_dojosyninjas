<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/dojoshow.css" />
	</head>
		<div class="container">
			<h1>Ninjas</h1>
		</div>
		<a class="btn btn-secondary " href="/dojos">Inicio</a>
		<table class="table table-dark">
			<tr class="table-info">
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Edad</th>
			</tr>
			<c:forEach var="ninja" items="${listaNinjas}">
				<tr>
					
					<td><c:out value="${ninja.getNombres()}"/></td>
					<td><c:out value="${ninja.getApellidos()}"/></td>
					<td><c:out value="${ninja.getEdad()}"/></td>
					
				</tr>
			</c:forEach>
		</table>
	</body>
</html>