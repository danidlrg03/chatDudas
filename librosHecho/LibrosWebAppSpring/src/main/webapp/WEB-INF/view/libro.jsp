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

<html>
<head>
    <title>Datos del libro</title>
</head>
<body>
<jsp:include page="cabecera.jsp"/>
<h1>Datos del libro</h1>
<form:form method="post" action="/libros/guardar" modelAttribute="libro">
    <form:hidden path="libroid" />
 <table border="0">
 <tr>
    <td>Título:</td>
     <td> <form:input path="libroname" size="100" maxlength="100"  />
         </td>
 </tr>
  <tr>
      <td>Año de publicación:</td>
      <td><form:input path="yearreleased" size="4"  maxlength="4" />
          </td>
  </tr>
  <tr>
     <td>Escritores:</td>
      <td>
          <form:checkboxes path="idescritores" items="${escritores}" itemLabel="escritorname" itemValue="escritorid" />
      </td>
  </tr>
  <tr>
    <td>Editorial:</td>
    <td>
        <form:checkboxes path="idgeneros" items="${generos}" itemLabel="generoname" itemValue="generoid" />
    </td>
  <tr>
     <td>Géneros:</td>
     <td>
         <form:select path="ideditorial" items="${editoriales}" itemLabel="editorialname" itemValue="editorialid" />
     </td>
 </tr>
  <tr>
    <td colspan="2"> <button>Enviar</button></td>
 </tr>
 </table>
</form:form>


</body>
</html>
