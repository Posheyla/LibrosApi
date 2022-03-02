<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>
			Lista de libros
		</h1>
		<ul>
			<c:forEach var="libro" items="${listaLibros}">
				<li>
					<c:out value="${libro.getTitle() }"/>
					<c:out value="${libro.getDescription()}"/>
				</li>
			</c:forEach>
		</ul>
		
		<script src="/js/index.js"></script>
	</body>
</html>