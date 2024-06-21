<%@ page import="taw.webdeentrenamiento.entity.Usuario" %>
<%@ page import="taw.webdeentrenamiento.entity.Rol" %><%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 22/4/24
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>

    <title>Administrador</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
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
<h1 style="text-align: center;">Vista Administradores</h1><div class="container mt-3">
    <div class="row">
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Crear o modificar Usuarios</h5>
                    <p class="card-text">Revisa y actualiza la lista usuarios.</p>
                    <a href="usuarios" class="btn btn-primary">Gestionar</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Crear o Editar Ejercicios</h5>
                    <p class="card-text">Crea o modifica la lista de ejercicios</p>
                    <a href="#" class="btn btn-primary">Ir</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Asignar clientes</h5>
                    <p class="card-text">Asigna a cada cliente un Entrenador o Dietista</p>
                    <a href="asignar" class="btn btn-primary">Asignar</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
