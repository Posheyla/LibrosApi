<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Seleccionar libro</title>
		
	</head>
	<body>
		<h1>Título<c:out value="${libro.getTitle() }"/></h1>
		<h3>Descripción: <c:out value="${libro.getDescription()}"/></h3>
		<h3>Lenguaje: <c:out value="${libro.getLanguage()}"/></h3>
	    <h3>Páginas: <c:out value="${libro.getNumberOfPages()}"/></h3>

	</body>
</html>