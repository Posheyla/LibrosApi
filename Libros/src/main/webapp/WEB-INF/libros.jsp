<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Libros</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/index.css" />
		
	</head>
	<body>
		<div class="container">
			<h1>Lista de libros</h1>
		</div>
		<table class="table table-sm">
			<tr class="table-info">
				<th>Título</th>
				<th>Descripción</th>
				<th>Lenguaje</th>
				<th>Páginas</th>
			</tr>
			<c:forEach var="libro" items="${listaLibros}">
				<tr>
					<td><a class="btn btn-primary" href="/libros/${libro.getId()}"><c:out value="${libro.getTitle()}"/></a></td>
					<td><c:out value="${libro.getDescription()}"/></td>
					<td><c:out value="${libro.getLanguage()}"/></td>
					<td><c:out value="${libro.getNumberOfPages()}"/></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>