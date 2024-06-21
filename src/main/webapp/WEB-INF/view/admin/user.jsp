<%@ page import="taw.webdeentrenamiento.entity.Usuario" %>
<%@ page import="taw.webdeentrenamiento.entity.Rutina" %>
<%@ page import="taw.webdeentrenamiento.entity.Dieta" %>
<%@ page import="taw.webdeentrenamiento.entity.Rol" %>
<%@ page import="taw.webdeentrenamiento.entity.TipoRutina" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Usuario usuario = (Usuario) request.getAttribute("user");
    Rutina rutina = usuario.getRutina();
    Dieta dieta = usuario.getDieta();
    Rol rol = usuario.getRol();
    List<Rol> roles = (List<Rol>) request.getAttribute("roles");
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

        .hidden {
            display: none;
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>

<div class="container">
    <h1 class="text-center mb-4">Perfil del <%=usuario.getRol().getRolName()%>
    </h1>

    <!-- Información del Usuario -->
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Información del <%=usuario.getRol().getRolName()%>
            </h4>

            <!-- Mostrar datos -->
            <div id="view-info">
                <p><strong>Nombre:</strong> <%= usuario.getNombre() %>
                </p>
                <p><strong>Email:</strong> <%= usuario.getEmail() %>
                </p>
                <p><strong>Peso:</strong> <%= usuario.getPeso() %> kg</p>
                <p><strong>Altura:</strong> <%= usuario.getAltura() %> cm</p>
                <p><strong>Edad:</strong> <%= usuario.getEdad() %> años</p>
                <p><strong>Rol:</strong> <%= rol != null ? rol.getRolName() : "No definido" %>
                </p>
                <button class="btn btn-primary" onclick="toggleEditMode()">Editar</button>
            </div>

            <!-- Editar datos -->
            <form id="edit-info" class="hidden" action="actualizarUsuario" method="post">
                <input type="hidden" name="id" value="<%= usuario.getId() %>">
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre"
                           value="<%= usuario.getNombre() %>">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%= usuario.getEmail() %>">
                </div>
                <div class="mb-3">
                    <label for="peso" class="form-label">Peso (kg):</label>
                    <input type="number" class="form-control" id="peso" name="peso" value="<%= usuario.getPeso() %>">
                </div>
                <div class="mb-3">
                    <label for="altura" class="form-label">Altura (cm):</label>
                    <input type="number" class="form-control" id="altura" name="altura"
                           value="<%= usuario.getAltura() %>">
                </div>
                <div class="mb-3">
                    <label for="edad" class="form-label">Edad:</label>
                    <input type="number" class="form-control" id="edad" name="edad" value="<%= usuario.getEdad() %>">
                </div>
                <div class="mb-3">
                    <select name="rol" id="rol">
                        <%for (Rol r : roles) {
							String selected = "";
                            if (Objects.equals(r.getId(), rol.getId())){
								selected = "SELECTED";
							}%>

                        <option value="<%=r.getId()%>" label="<%=r.getRolName()%>" <%=selected%> />
                        <%}%>
                    </select>
                </div>

                <button type="submit" class="btn btn-success">Guardar cambios</button>
                <button type="button" class="btn btn-secondary" onclick="toggleEditMode()">Cancelar</button>
            </form>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function toggleEditMode() {
        var viewInfo = document.getElementById('view-info');
        var editInfo = document.getElementById('edit-info');
        viewInfo.classList.toggle('hidden');
        editInfo.classList.toggle('hidden');
    }
</script>
</body>
</html>
