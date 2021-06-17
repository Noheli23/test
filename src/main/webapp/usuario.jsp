<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aplicación Gestión de Usuarios</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand text-center">Gestión de Usuarios</a>
			</div>
			
			<ul>
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link"></a></li>
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${usuario != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${usuario == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
				<h2>
				<c:if test="${usuario != null}">Editar usuario</c:if>
				<c:if test="${usuario == null}">Agregar nuevo usuario</c:if>
				</h2>
				</caption>
				
				<c:if test="${usuario != null}">
				 <input type="hidden" name="id" value="<c:out value='${usuario.id}'/>"/>
				</c:if>
				
				<fieldset class="form-group">
					<label>Nombre de Usuario</label> <input type="text" value="<c:out value='${usuario.nombre}'/>" class="form-control" name="nombre" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Email del Usuario</label> <input type="text" value="<c:out value='${usuario.email}'/>" class="form-control" name="email" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>País del Usuario</label> <input type="text" value="<c:out value='${usuario.pais}'/>" class="form-control" name="pais" required="required">
				</fieldset>
				<button type="submit" class="btn btn-success " >Guardar</button>
				</form>
			</div>
		</div>
	
	</div>
</body>
</html>