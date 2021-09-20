<%-- 
    Document   : PerfilUser
    Created on : 19-sep-2021, 16:27:22
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
    <%    if((request.getSession(false).getAttribute("User")== null) )
{
%>
<jsp:forward page="index.jsp"></jsp:forward>
<%} %>

<p> si ves esto, estas logeado  <%=request.getAttribute("userName") %>
    
</p>

    </body>
</html>
