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
        <h1>Perfil de usuario</h1>

        <p>Datos usuario:</p>
        <p>${user.name}</p>
        
        <a href="paymentmethod.jsp">AÑADIR METODO DE PAGO</a>
     

          <c:forEach items="${user.paymentMethod}" var="paymentMethod">
              <p>${paymentMethod.paymentId}</p> 
              <p>${paymentMethod.paymentName}</p> 
              
          </c:forEach>
     

            <div class="container rounded bg-white mt-5">
                <div class="row">
                    <div class="col-md-4 border-right">
                        <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                            <span>Metodos de pago disponibles</span>
                    <%--    <c:out value="Correo de paypal: ${empty usuario.paypal.correo ? 'Añadir paypal(formulario JS)' : usuario.paypal.correo}" />

                        <br>
                        <c:out value="numero de tarjeta: ${empty usuario.tarjeta.numero ? 'Añadir tarjeta de credito(formulario JS)' : usuario.tarjeta.numero}" />

                        <br>

                        <c:out value="numero de iban: ${empty usuario.transferencia.iban ? 'Añadir datos bancarios(formulario JS)' : usuario.transferencia.iban}" /> --%>

                        <span class="text-black-50">${user.email}</span></div>
                </div>
                <div class="col-md-8">
                    <div class="p-3 py-5">
                        <form action="PostUpdateDescripcionUsuario">
                            <div class="row mt-3">
                                <div class="col-md-6">
                                    <label for="html">Nombre</label><input type="text" class="form-control" value="${user.name}" name="name"></div>

                                <div class="col-md-6"> 
                                    <label for="html">Apellido 1</label><input type="text" class="form-control" value="${user.surnameA}" name="profilemiddlename"></div>
                                <div class="col-md-6"> <label for="html">Apellido 2</label><input type="text" class="form-control" value="${user.surnameB}" name="profilelastname"></div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-6"> <label for="html">Correo</label>
                                    <input type="text" class="form-control" value="${user.email}" name="profilemail"></div>
                                <div class="col-md-6"> <label for="html">Telefono</label>
                                    <input type="text" class="form-control" value="${user.phone}" name="profilephone"></div>
                            </div>

                            <div class="mt-5 text-right"><button class="btn btn-primary profile-button" type="submit">Guardar cambios</button></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
