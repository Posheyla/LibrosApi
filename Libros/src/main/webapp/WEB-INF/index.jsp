<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Registro Libros</h1>
		<form method="POST" action ="/api/libros" >
			<div>
				<label for="title">
					Titulo:
				</label>
				<input  type="text" name="title" id="title" />
			</div>
			
			<div>
				<label for="description">
					Descripción:
				</label>
				<input  type="text" name="description" id="description" />
			</div>
			
			<div>
				<label  for="language">
					Lenguaje:
				</label>
				<input  type="text" name="language" id="language" />
			</div>
			
			<div>
				<label  for="pages">
					Páginas:
				</label>
				<input type="text" name="pages" id="pages" />
			</div>
			
			<button type="submit">
				Registrar libro
			</button>
		</form>
	</body>
</html>