
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

  
    <div>

    <%--  <form class="form-signin" action="RegistroUsuario">
        <div class="text-center mb-4">
      
          <h1 class="h3 mb-3 font-weight-normal">Registrarse (pendiente, obligar a poner metodos pago)</h1>
    
        </div>
    
        <div class="form-label-group">    <label for="inputEmail">Dato 1</label>
          <input type="email" id="inputEmail" class="form-control" placeholder="aaa" required autofocus>
      
        </div>

        <div class="form-label-group">        <label for="inputPassword">Dato 2</label>
          <input type="password" id="inputPassword" class="form-control" placeholder="aaa" required>
  
        </div>
    
       
    
        <button class="btn btn-lg btn-primary btn-block" type="submit">Registarse</button>
    
      </form>
    --%>
              <form action="RegistroUsuario" method="GET">
                  <p>Datos personales:</p>
            <p>Nombre: <input type="text" name="nombre"></p>
            <p>Apellido 1: <input type="text" name="apellidoa"></p>
          <!--    <p>Apellido 2: <input type="text" name="apellidob"></p> -->
                <p>Telefono<input type="text" name="telefono"></p>
                  <p>Correo<input type="text" name="correo"></p>
               <p>Datos de sesion:</p>
            <p>Usuario: <input type="text" name="usuario"></p>    
            <p>Contraseña: <input type="text" name="contrasena"></p> 
            
            <p> 
                <input type="submit" value="Registrar">
                <input type="reset" value="Borrar">
            </p>
        </form>   

        <% if (request.getAttribute("yaExiste") != null) {
        %> <p>${yaExiste}</p> <% }%>
        
        
    </div>


    
  </body>
</html>
