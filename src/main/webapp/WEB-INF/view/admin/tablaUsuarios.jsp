<%@ page import="java.util.List" %>
<%@ page import="taw.webdeentrenamiento.entity.Usuario" %>
<%@ page import="taw.webdeentrenamiento.dao.RutinaRepository" %>
<%
    List<Usuario> users = (List<Usuario>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 20px;
        }
        .container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>

<div class="container">
    <h1 class="text-center mb-4">Usuarios</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Cliente</th>
            <th>Rutina Asignada</th>
            <th></th>
        </tr>
        </thead>
        <tbody
        <% for (Usuario u : users) { %>
        <tr>
            <td><%= u.getNombre() %></td>
            <td><%=u.getRol().getRolName()%></td>
            <td><a href="user?id=<%= u.getId() %>" class="btn btn-primary">Modificar Perfil</a> <a href="deleteUser?id=<%= u.getId() %>" class="btn btn-danger"> Borrar Usuario</a></td>

        </tr>
        <% } %>
        </tbody>
    </table>
    <a href="nuevoUsuario" class="btn btn-primary mb-4">Crear Usuario</a>


</div>

<!-- Bootstrap 5 Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
