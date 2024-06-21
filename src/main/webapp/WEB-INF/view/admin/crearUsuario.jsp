<%@ page import="java.util.List" %>
<%@ page import="taw.webdeentrenamiento.entity.Rol" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% List<Rol> roles = (List<Rol>) request.getAttribute("roles"); %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Usuario</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="navbar.jsp"/>

<div class="container">
    <h1 class="text-center mb-4">Crear Usuario</h1>

    <form action="guardarUsuario" method="post">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" class="form-control" id="nombre" name="nombre" value="${usuario.nombre}">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="${usuario.email}">
        </div>
        <div class="mb-3">
            <label for="peso" class="form-label">Peso (kg):</label>
            <input type="number" class="form-control" id="peso" name="peso" value="${usuario.peso}">
        </div>
        <div class="mb-3">
            <label for="altura" class="form-label">Altura (cm):</label>
            <input type="number" class="form-control" id="altura" name="altura" value="${usuario.altura}">
        </div>
        <div class="mb-3">
            <label for="edad" class="form-label">Edad:</label>
            <input type="number" class="form-control" id="edad" name="edad" value="${usuario.edad}">
        </div>

        <div class="mb-3">
            <select name="rol" id="rol">
                <%for (Rol rol : roles) {%>
                <option value="<%=rol.getId()%>"><%=rol.getRolName()%>
                </option>
                <%}%>
            </select>
        </div>


        <button type="submit" class="btn btn-success">Guardar</button>
        <a href="/admin/usuarios" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
