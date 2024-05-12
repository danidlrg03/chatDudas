<%@ page import="libroswebapp.entity.AdministradorEntity" %><%--
  Created by IntelliJ IDEA.
  User: guzman
  Date: 24/4/24
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AdministradorEntity usuario = (AdministradorEntity)session.getAttribute("usuario");

%>


<table width="100%">
    <tr>
        <td><a href="/libros/">Libros</a></td>
        <td>Escritores</td>
        <td>Géneros</td>
        <td>Editoriales</td>
        <td>Bienvenido: <%= usuario.getEmail() %> al sistema (<a href="/salir">Salir</a>)</td>
    </tr>
</table>


<br/><br/>