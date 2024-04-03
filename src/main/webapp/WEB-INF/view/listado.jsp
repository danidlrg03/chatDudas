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
%>


<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1 ">

<tr>
    <th>ID</th>
    <th>TITULO</th>
    <th>AÑO PUBLICACIÓN</th>
    <th>EDITORIAL</th>
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
    <td><a href="/borrar?id=<%= libro.getLibroid()  %>">Borrar</a> </td>

</tr>
<%
    }
%>


</body>
</html>
