<%-- 
    Document   : index2mostrararticulos
    Created on : 13-sep-2021, 19:49:23
    Author     : Jorge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de articulos</h1>
         <h1>listado articulos</h1>
        <c:forEach var="persona" items="${lista}">  
            <c:out value="${persona.nombre}"/>  
                <c:out value="${persona.apellido}"/>
                    <c:out value="${persona.email}"/>
                          <c:out value="${persona.telefono}"/><p>  
        </c:forEach>  
    </body>
</html>
