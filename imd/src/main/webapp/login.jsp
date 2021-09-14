
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
  <jsp:include page="header.jsp" />
  
    <div>

      <form class="form-signin" action="index.jsp">
        <div class="text-center mb-4">
      
          <h1 class="h3 mb-3 font-weight-normal">iniciar sesión</h1>
    
        </div>
    
        <div class="form-label-group">
          <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
          <label for="inputEmail">Email address</label>
        </div>
    
        <div class="form-label-group">
          <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
          <label for="inputPassword">Password</label>
        </div>
    
       
    
        <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar sesión</button>
    
      </form>
    </div>


    
  </body>
</html>
