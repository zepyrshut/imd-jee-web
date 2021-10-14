<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error page</title>
    <meta charset="utf-8">
</head>
<body>
    
    <h1>error 404 encontrado</h1>
    <br />
    <p><b>Codigo de error:</b> ${pageContext.errorData.statusCode}</p>
    <p><b>URI pedida:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
    <br />
</body>
</html>