    
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!doctype html> <!-- meter el charset utf en un header aparte-->
<html lang="en">
  <head>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Index</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/pricing/">

    

    <!-- Bootstrap core CSS -->
<!--<link href="css/bootstrap.min.css" rel="stylesheet">-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">


    
    <!-- Custom styles for this template -->
    <link href="css/pricing.css" rel="stylesheet">
  </head>
  <body>
    


<div class="container py-3">
  <jsp:include page="header.jsp" />
  
    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
      <h1 class="display-4 fw-normal">Bienvenido user1.000.000 reclama tu iphone</h1>
      <p class="fs-5 text-muted">Las mejores actividades por el mejor precio promocionadas por el Instituto
        Municipal de Deportes</p>
    </div>
                  
   
            
           
 
  <main>
        <c:forEach var="actividad" items="${listaActividad}">  
            
    <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
      <div class="col">
        <div class="card mb-4 rounded-3 shadow-sm">
          <div class="card-header py-3">
            <h4 class="my-0 fw-normal">         <c:out value="${actividad.nombreActividad}"/>  </h4>
          </div>
          <div class="card-body">
            <h1 class="card-title pricing-card-title">$10<small class="text-muted fw-light">/mo</small></h1>
            <ul class="list-unstyled mt-3 mb-4">
              <li>descripcion</li>
              <li>instructor</li>
              <li>actividad.x</li>
              <li>actividad.y</li>
            </ul>
            
            <a href="descripcionactividad.jsp">  <button type="button" class="w-100 btn btn-lg btn-outline-primary">Ver más</button></a>
          </div>
        </div>
      </div>
      <div class="col">
        <div class="card mb-4 rounded-3 shadow-sm">
          <div class="card-header py-3">
            <h4 class="my-0 fw-normal">Actividad 2</h4>
          </div>
          <div class="card-body">
            <h1 class="card-title pricing-card-title">$15<small class="text-muted fw-light">/mo</small></h1>
            <ul class="list-unstyled mt-3 mb-4">
                <li>descripcion</li>
                <li>instructor</li>
                <li>actividad.x</li>
                <li>actividad.y</li>
              </ul>
              <button type="button" class="w-100 btn btn-lg btn-outline-primary">Ver más</button>
          </div>
        </div>
      </div>
      <div class="col">
        <div class="card mb-4 rounded-3 shadow-sm border-primary">
          <div class="card-header py-3 text-white bg-primary border-primary">
            <h4 class="my-0 fw-normal">Actividad 3</h4>
          </div>
          <div class="card-body">
            <h1 class="card-title pricing-card-title">$29<small class="text-muted fw-light">/mo</small></h1>
            <ul class="list-unstyled mt-3 mb-4">
                <li>descripcion</li>
                <li>instructor</li>
                <li>actividad.x</li>
                <li>actividad.y</li>
              </ul>
              <button type="button" class="w-100 btn btn-lg btn-outline-primary">Ver más</button>
          </div>
        </div>
      </div>
    </div>

</div>
 </c:forEach>  
</main>
  <br> lista users <br>
        <c:forEach var="usuario" items="${lista}">  
            <c:out value="${usuario.nombreUsuario}"/>  
            
            </c:forEach>  
    <br>lista actividades<br>
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
