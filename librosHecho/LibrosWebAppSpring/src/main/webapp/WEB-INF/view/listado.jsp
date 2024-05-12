<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="libroswebapp.entity.LibroEntity" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: guzman
  Date: 20/3/24
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<LibroEntity> lista = (List<LibroEntity>) request.getAttribute("lista");
    String filtro = request.getParameter("filtro");
    String anyo = request.getParameter("anyo");
    if (filtro == null) filtro = "";
    if (anyo == null) anyo = "";
%>


<html>
<head>
    <title>Title</title>
</head>
<body>


<jsp:include page="cabecera.jsp"/>

<form:form method="post" action="/libros/filtrar" modelAttribute="filtro">
Contiene: <form:input path="titulo" />
y fue publicado después de: <form:input path="anyo"  />
    <form:button>Filtrar</form:button>

</form:form>


<table border="1 ">

<tr>
    <th>ID</th>
    <th>TITULO</th>
    <th>AÑO PUBLICACIÓN</th>
    <th>EDITORIAL</th>
    <th></th>
    <th></th>
</tr>

<%
    for (LibroEntity libro: lista) {
%>
<tr>
    <td><%= libro.getLibroid() %></td>
    <td><%= libro.getLibroname() %></td>
    <td><%= libro.getYearreleased() %></td>
    <td><%= libro.getEditorialid().getEditorialname() %></td>
    <td><a href="/libros/borrar?id=<%= libro.getLibroid()  %>">Borrar</a> </td>
    <td><a href="/libros/editar?id=<%= libro.getLibroid()  %>">Editar</a> </td>


</tr>
<%
    }
%>
</table>
<a href="/libros/crear">Nuevo libro ... </a>

</body>
</html>
