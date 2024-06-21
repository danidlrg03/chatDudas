<%@ page import="taw.webdeentrenamiento.entity.Usuario" %>
<%@ page import="taw.webdeentrenamiento.entity.Rol" %><%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 22/4/24
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee&amp;display=swap">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>

<body>
<div class="container" style="margin-top: 64px;width: 746px;">
    <h1 class="text-center mb-4" style="color: var(--bs-blue);font-family: ABeeZee, sans-serif;">Iniciar Sesión</h1>
    <div class="card">
        <div class="card-body">
            <form action="login" method="post">
                <div class="mb-3"><label class="form-label form-label" for="usuario">Usuario:</label><input class="form-control" id="usuario" name="usuario" required=""></div>
                <div class="mb-3"><label class="form-label form-label" for="contrasena">Contraseña:</label><input class="form-control form-control" type="password" id="contrasena" name="contrasena" required=""></div><button class="btn btn-primary d-flex d-lg-flex align-items-lg-start" type="submit">Iniciar Sesión</button>
                <hr style="margin-top: 24px;">
            </form><a class="text-center d-lg-flex justify-content-lg-center" href="/register" style="text-align: center;position: relative;display: flex;">Crea una Cuenta!</a>
        </div>
    </div>
    <%
        Boolean error = (Boolean) request.getAttribute("error");
        if (error!=null) {
    %>
    <div class="alert alert-danger" role="alert" id="mensajeError" style="margin-top: 8px;"><span> Usuario o contraseña incorrecta<br>Por favor, inténtalo de nuevo.</span><span></span><br></div>
    <% } %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>





