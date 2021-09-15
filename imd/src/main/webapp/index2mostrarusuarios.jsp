<%-- 
    Document   : index2mostrararticulos
    Created on : 13-sep-2021, 19:49:23
    Author     : jorge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index2mostrarusuarios</title>
    </head>
    <body>
    
         <h1>listado usuarios</h1>
        <c:forEach var="usuario" items="${lista}">  
            <c:out value="${usuario.nombreUsuario}"/>  
            
            </c:forEach>  

                    <c:forEach var="actividad" items="${listaActividad}">  
            <c:out value="${actividad.nombreActividad}"/>  
            
            </c:forEach>  
         <c:forEach var="usuario" items="${lista}">  
            <hr>
         
                <c:out value="${usuario.nombreUsuario}"/><p></a>
                <c:forEach var="actividad" items="${usuario.actividades}">  
                 <c:out value="${actividad.nombreActividad}"/> 
           
            </c:forEach>  
            <hr>
        </c:forEach>  
         
    </body>
</html>
