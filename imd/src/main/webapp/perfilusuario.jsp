<%-- 
    Document   : perfilUsuario
    Created on : 24-sep-2021, 21:06:54
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@ include file="/jspf/head.jspf" %>
    <body>
        <!-- Barra navegación -->
        <%@ include file="/jspf/navbar.jspf" %>   
        <h1>User Profile - (This could be Edit Profile or both)</h1>
        
        <p>Actividades de usuario:</p>
        <c:forEach items="${usuario.usuarioTieneActividadCollection}" var="usuario">
            <p>${usuario.actividad.nombreActividad}</p>
         
            
            </c:forEach>
    <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>

    </tr>
  </thead>
  <c:forEach items="${usuario.usuarioTieneActividadCollection}" var="usuario">
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>${usuario.actividad.nombreActividad}</td></c:forEach>

    </tr>
  
  </tbody>
</table>

        <div class="container rounded bg-white mt-5">
            <div class="row">
                <div class="col-md-4 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5"><span>Some side info, may swap for profile content and use payments on the right</span><span class="font-weight-bold">${usuario.nombre}</span><span class="text-black-50">${usuario.email}</span></div>
                </div>
                <div class="col-md-8">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <div class="d-flex flex-row align-items-center back"><i class="fa fa-long-arrow-left mr-1 mb-1"></i>
                                <h6>Back to home</h6>
                            </div>
                            <h6 class="text-right">Edit Profile</h6>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-6">
                                <label for="html">First Name</label><input type="text" class="form-control" placeholder="first name" value="${usuario.nombre}"></div>

                            <div class="col-md-6"> <label for="html">Middle Name</label>
                                <input type="text" class="form-control" value="${usuario.apellidoA}" placeholder="Doe"></div>
                            <div class="col-md-6"> <label for="html">Last Name</label>
                                <input type="text" class="form-control" value="${usuario.apellidoB}" placeholder="Doe"></div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-6"> <label for="html">Email</label>
                                <input type="text" class="form-control" placeholder="Email" value="${usuario.email}"></div>
                            <div class="col-md-6"> <label for="html">Phone number</label>
                                <input type="text" class="form-control" value="${usuario.telefono}" placeholder="Phone number"></div>
                        </div>

                        <div class="mt-5 text-right"><button class="btn btn-primary profile-button" type="button">Save Profile(Pending)</button></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
