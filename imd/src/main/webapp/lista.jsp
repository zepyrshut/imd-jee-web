<%-- 
    Document   : lista
    Created on : 16 sept. 2021, 21:55:22
    Author     : Pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>   <c:forEach var="lista" items="${listaActividades}">           
                <li>   <c:out value="${lista.nombreActividad}"/></li>
            </c:forEach> </ul>
    </body>
</html>
