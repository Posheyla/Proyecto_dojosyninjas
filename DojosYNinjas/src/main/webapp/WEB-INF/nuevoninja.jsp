<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/nuevoninja.css" />
	</head>
	<body>
	    <a class="btn btn-secondary " href="/dojos">Inicio</a>
	    <div class="contenedor">
	        <h1>NEW NINJA</h1>
		        <form:form method="POST" action ="/ninjas/nuevo/registrar" modelAttribute="ninja">
				
				<div class="section">
					<form:label path="dojo" for="dojo">
						Dojo:
					</form:label>
					<form:select  path="dojo" name="dojo" id="dojo">
						<form:option value ="none"></form:option>
						<c:forEach var="dojo" items="${listaDojos}">
							<form:option value="${dojo.getDojo_id()}">
								${dojo.getNombre()}
							</form:option>
						</c:forEach>
						<form:errors path="dojo"/>
					</form:select>
				</div>
				
				<div class="section">
					<form:label path="nombres" for="nombres">
						Nombre:
					</form:label>
					<form:input path="nombres" type="text" name="nombres" id="nombres" />
					<form:errors path="nombres"/>
				</div>
				
				<div class="section">
					<form:label path="apellidos" for="apellidos">
						Apellido:
					</form:label>
					<form:input path="apellidos" type="text" name="apellidos" id="apellidos" />
					<form:errors path="apellidos"/>
				</div>
				
				<div class="section">
					<form:label path="edad" for="edad">
						Edad:
					</form:label>
					<form:input path="edad" type="text" name="edad" id="edad" />
					<form:errors path="edad"/>
				</div>
				
				<button type="submit" class="btn">
					Registrar ninja
				</button>
			</form:form>
	    </div>
	</body>
</html>