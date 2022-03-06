<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="/css/dojos.css" />
	</head>
	<body>
        <div class="contenedor">
            <div class="derecha">
                <form:form action="/dojos/nuevo" method="POST" modelAttribute="dojo">
                    <div>
                        <form:label path="nombre" for="nombre">
                            Nuevo Dojo
                        </form:label>
                        <form:input path="nombre" type="text" name="nombre" id="nombre"/>
                        <form:errors path="nombre"/>
                    </div>
                    <button type="submit" class="btn1">
                        Crear
                    </button>
                </form:form>
            </div>
            <div class="izquierda">
                <div>
                    <h1>Todos los dojos</h1>
                   
                   	<c:forEach var="dojo" items="${listaDojos}">
	                   	<div class="section">
	                    	<a href="/dojos/${dojo.getDojo_id()}"><c:out value="${dojo.getNombre()}"/></a>
	                    </div>
               		</c:forEach>
                   
                </div>
                <form action="/ninjas/nuevo" method="GET">
                    <button class="btn3">
                        Agregar ninja
                    </button>
                </form>
            </div>
        </div>
    </body>
</html>