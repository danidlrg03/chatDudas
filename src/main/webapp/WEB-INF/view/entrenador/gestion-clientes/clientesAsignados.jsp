<%@ page import="java.util.List" %>
<%@ page import="taw.webdeentrenamiento.entity.Usuario" %>
<%@ page import="taw.webdeentrenamiento.dao.RutinaRepository" %>
<%
    List<Usuario> users = (List<Usuario>) request.getAttribute("usuarios");
    RutinaRepository rutinaRepository;
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
<div class="container">
    <h1 class="text-center mb-4">Tus clientes</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Cliente</th>
            <th>Rutina Asignada</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody
        <% for (Usuario u : users) { %>
        <tr>
            <td><%= u.getNombre() %></td>
            <td><%= u.getRutina().getDescripcion()%></td>
            <td><a href="cliente?usuario_id=<%= u.getId() %>" class="btn btn-primary">Ver Perfil</a></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<!-- Bootstrap 5 Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
