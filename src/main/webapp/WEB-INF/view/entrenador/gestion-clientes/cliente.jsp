<%@ page import="taw.webdeentrenamiento.entity.Usuario" %>
<%@ page import="taw.webdeentrenamiento.entity.Rutina" %>
<%@ page import="taw.webdeentrenamiento.entity.Dieta" %>
<%@ page import="taw.webdeentrenamiento.entity.Rol" %>
<%@ page import="taw.webdeentrenamiento.entity.TipoRutina" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    Rutina rutina = usuario.getRutina();
    Dieta dieta = usuario.getDieta();
    Rol rol = usuario.getRol();
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
    <h1 class="text-center mb-4">Perfil del Cliente</h1>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Información del Cliente</h5>
            <p><strong>Nombre:</strong> <%= usuario.getNombre() %></p>
            <p><strong>Email:</strong> <%= usuario.getEmail() %></p>
            <p><strong>Peso:</strong> <%= usuario.getPeso() %> kg</p>
            <p><strong>Altura:</strong> <%= usuario.getAltura() %> cm</p>
            <p><strong>Edad:</strong> <%= usuario.getEdad() %> años</p>
            <p><strong>Rol:</strong> <%= rol != null ? rol.getRolName() : "No definido" %></p>
        </div>
    </div>
    <div class="card mt-3">
        <div class="card-body">
            <h5 class="card-title">Rutina Actual</h5>
            <% if (rutina != null) { %>
            <p><strong>Descripción:</strong> <%= rutina.getDescripcion() %></p>
            <p><strong>Tipo de Rutina:</strong> <%= rutina.getTipoRutina().getTipoRutina() %></p>
            <p><strong>Fecha de Creación:</strong> <%= rutina.getFechaCreacion() %></p>
            <% } else { %>
            <p>No se ha asignado una rutina a este cliente.</p>
            <% } %>
        </div>
    </div>
    <div class="card mt-3">
        <div class="card-body">
            <h5 class="card-title">Dieta Actual</h5>
            <% if (dieta != null) { %>
            <p><strong>Descripción:</strong> <%= dieta.getDescripcion() %></p>
            <p><strong>Feedback:</strong> <%= dieta.getFeedback() != null ? dieta.getFeedback() : "Sin feedback" %></p>
            <p><strong>Fecha de Creación:</strong> <%= dieta.getFechaCreacion() %></p>
            <% } else { %>
            <p>No se ha asignado una dieta a este cliente.</p>
            <% } %>
        </div>
    </div>
</div>

<!-- Bootstrap 5 Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


