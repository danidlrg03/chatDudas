<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="libroswebapp.entity.LibroEntity" %>
<%@ page import="libroswebapp.entity.EscritorEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="libroswebapp.entity.EditorialEntity" %>
<%@ page import="libroswebapp.entity.GeneroEntity" %><%--
  Created by IntelliJ IDEA.
  User: guzman
  Date: 3/4/24
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    LibroEntity libro = (LibroEntity) request.getAttribute("libro");
    boolean esEditar = (libro.getLibroid() != -1);
    String titulo = "", anyo = "";
    List<EscritorEntity> escritores = (List<EscritorEntity>) request.getAttribute("escritores");
    List<EditorialEntity> editoriales = (List<EditorialEntity>) request.getAttribute("editoriales");
    List<GeneroEntity> generos = (List<GeneroEntity>) request.getAttribute("generos");

    if (esEditar) {
        titulo = libro.getLibroname();
        anyo = libro.getYearreleased() + "";
    }
%>
<html>
<head>
    <title>Datos del libro</title>
</head>
<body>
<jsp:include page="cabecera.jsp"/>
<h1>Datos del libro</h1>
<form method="post" action="/libros/guardar">
 <input type="hidden" name="id" value="<%= libro.getLibroid() %>">
 <table border="0">
 <tr>
    <td>Título:</td>
     <td><input type="text" name="titulo" size="100" maxlength="100" value="<%= titulo %>" /> </td>
 </tr>
  <tr>
      <td>Año de publicación:</td>
      <td><input type="number" name="anyo" size="4"  maxlength="4" value="<%= anyo %>" /></td>
  </tr>
  <tr>
     <td>Escritores:</td>
      <td>
<%
   for (EscritorEntity autor: escritores) {
       String esta = "";
       if (esEditar && libro.getEscritorList().contains(autor)) {
           esta = "checked";
       }
%>
    <input type="checkbox" name="escritores" <%= esta %>  value="<%= autor.getEscritorid() %>"><%= autor.getEscritorname()  %> <br/>

<%
    }
%>
      </td>
  </tr>
  <tr>
    <td>Editorial:</td>
    <td>
<select name="editorial">
<%
    for (EditorialEntity editorial: editoriales) {
        String seleccionado = "";
        if (esEditar && editorial.equals(libro.getEditorialid())) {
            seleccionado = "selected";
        }
%>
    <option value="<%=editorial.getEditorialid() %>"  <%=seleccionado %>  ><%= editorial.getEditorialname() %></option>

<%
    }
%>
</select>
    </td>
  <tr>
     <td>Géneros:</td>
     <td>
 <%
     for (GeneroEntity genero: generos) {
         String esta = "";
         if (esEditar && libro.getGeneroList().contains(genero)) {
             esta = "checked";
         }
 %>
 <input type="checkbox" name="generos" <%= esta %>  value="<%= genero.getGeneroid() %>"><%= genero.getGeneroname()  %> <br/>

 <%
     }
 %>
     </td>
 </tr>
  <tr>
    <td colspan="2"> <button>Enviar</button></td>
 </tr>
 </table>
</form>


</body>
</html>
