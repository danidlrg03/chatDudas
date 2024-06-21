<%@ page import="taw.webdeentrenamiento.entity.Usuario" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Asignar Entrenador</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-4">Asignar Entrenador</h1>

    <form action="<%= request.getContextPath() %>/asignarCliente" method="POST" class="my-4">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="cliente">Cliente</label>
                <select id="cliente" name="clienteId" class="form-control">
                    <option selected></option>
                    <%
                        List<Usuario> clientes = (List<Usuario>) request.getAttribute("clientes");
                        for (Usuario cliente : clientes) {
                    %>
                        <option value="<%= cliente.getId() %>"><%= cliente.getNombre() %></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div class="form-group col-md-6">
                <div class="form-group">
                    <label for="entrenador">Entrenador</label>
                    <select id="entrenador" name="entrenadorId" class="form-control">
                        <option selected>Seleccionar...</option>
                        <%
                            List<Usuario> entrenadores = (List<Usuario>) request.getAttribute("entrenadores");
                            for (Usuario entrenador : entrenadores) {
                        %>
                            <option value="<%= entrenador.getId() %>"><%= entrenador.getNombre() %></option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="form-group mt-2">
                    <label for="dietista">Dietista</label>
                    <select id="dietista" name="dietistaId" class="form-control">
                        <option selected>Seleccionar...</option>
                        <%
                            List<Usuario> dietistas = (List<Usuario>) request.getAttribute("dietista");
                            for (Usuario dietista : dietistas) {
                        %>
                            <option value="<%= dietista.getId() %>"><%= dietista.getNombre() %></option>
                        <%
                            }
                        %>
                    </select>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary mt-3">Asignar Entrenador</button>
    </form>

    <!-- Tabla de asignaciones -->
    <h2 class="my-4">Asignaciones Actuales</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Cliente</th>
            <th>Entrenador Asignado</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody id="asignaciones">

        <!-- TODO -->

        </tbody>
    </table>
</div>


</body>
</html>
