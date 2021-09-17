<%-- 
    Document   : index
    Created on : 7 sept. 2021, 18:44:28
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>

 
    
        
    
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    
    
        <!-- Favicons -->
    <link rel="apple-touch-icon" href="/docs/5.0/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="/docs/5.0/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="/docs/5.0/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
    <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon.ico">
    <meta name="theme-color" content="#7952b3">
    
    
        <style>
          body {background-color: #aabae7;}
          .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
          }
    
          @media (min-width: 768px) {
            .bd-placeholder-img-lg {
              font-size: 3.5rem;
            }
          }
        </style>

        
             <div class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">


              <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
                <a class="me-3 py-2 text-dark text-decoration-none" href="login.jsp">Login</a>
                <a class="me-3 py-2 text-dark text-decoration-none" href="registro.jsp">Registrarse</a>
                <a class="me-3 py-2 text-dark text-decoration-none" href="perfilusuario.jsp">Perfil Usuario</a>
                <a class="py-2 text-dark text-decoration-none" href="">Cerrar Sesion</a>
              </nav>
            </div> 
        
        <!-- Custom styles for this template -->
        <link href="/css/pricing.css" rel="stylesheet">
      </head>
      <body>
        
    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;"></svg>
      <symbol id="check" viewBox="0 0 16 16">
        <title>Check</title>
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
      </symbol>
    </svg>
    <span class="fs-4">IMD</span>
    <div class="container py-3">
      <header>

        

    
        <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
          <p class="fs-5 text-muted">Las mejores actividades por el mejor precio promocionadas por el Instituto 
            Municipal de Deportes
          </p>
        </div>
      </header>
      


      
      <main>
        
        <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
          
          <div class="col">
            <div class="card mb-4 rounded-3 shadow-sm">
              <div class="card-header py-3">
                <h4 class="my-0 fw-normal">Titulo Actividad1</h4>
              </div>
              <div class="card-body">
                <h1 class="card-title pricing-card-title">Subtitulo<small class="text-muted fw-light"></small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                  <li>Descripcionactividad1</li>
                  <li>Descripcionactividad2</li>
                  <li>Descripcionactividad3</li>
                  <li>Descripcionactividad4</li>
                </ul>
                <button type="button" class="w-100 btn btn-lg btn-outline-primary">Más información</button>
              </div>
            </div>
          </div>
          <div class="card mb-4 box-shadow">
            <div class="card-header">
              <h4 class="my-0 font-weight-normal">Pro</h4>
            </div>
            <div class="card-body">
              <h1 class="card-title pricing-card-title">$15 <small class="text-muted">/ mo</small></h1>
              <ul class="list-unstyled mt-3 mb-4">
                <li>20 users included</li>
                <li>10 GB of storage</li>
                <li>Priority email support</li>
                <li>Help center access</li>
              </ul>
              <button type="button" class="btn btn-lg btn-block btn-primary">Get started</button>
            </div>
          </div>
          <div class="col">
            <div class="card mb-4 rounded-3 shadow-sm">
              <div class="card-header py-3">
                <h4 class="my-0 fw-normal">Titulo Actividad2</h4>
              </div>
              <div class="card-body">
                <h1 class="card-title pricing-card-title">Subtitulo<small class="text-muted fw-light"></small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                  <li>Descripcionactividad1</li>
                  <li>Descripcionactividad2</li>
                  <li>Descripcionactividad3</li>
                  <li>Descripcionactividad4</li>
                </ul>
                <button type="button" class="w-100 btn btn-lg btn-primary">Más información</button>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card mb-4 rounded-3 shadow-sm border-primary">
              <div class="card-header py-3 text-white bg-primary border-primary">
                <h4 class="my-0 fw-normal">Titulo Actividad3</h4>
              </div>
              <div class="card-body">
                <h1 class="card-title pricing-card-title">Subtitulo<small class="text-muted fw-light"></small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                  <li>Descripcionactividad1</li>
                  <li>Descripcionactividad2</li>
                  <li>Descripcionactividad3</li>
                  <li>Descripcionactividad4</li>
                </ul>
                <button type="button" class="w-100 btn btn-lg btn-primary">Más información</button>
              </div>
            </div>
          </div>
        </div>
    
        <h2 class="display-6 text-center mb-4">¿Listado de actividades de usuario logeado?</h2>
    
        <div class="table-responsive">
          <!-- <table class="table text-center">
            <thead>
              <tr>
                <th style="width: 34%;"></th>
                <th style="width: 22%;">Free</th>
                <th style="width: 22%;">Pro</th>
                <th style="width: 22%;">Enterprise</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row" class="text-start">Public</th>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
              </tr>
              <tr>
                <th scope="row" class="text-start">Private</th>
                <td></td>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
              </tr>
            </tbody>
    
            <tbody>
              <tr>
                <th scope="row" class="text-start">Permissions</th>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
              </tr>
              <tr>
                <th scope="row" class="text-start">Sharing</th>
                <td></td>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
              </tr>
              <tr>
                <th scope="row" class="text-start">Unlimited members</th>
                <td></td>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
              </tr>
              <tr>
                <th scope="row" class="text-start">Extra security</th>
                <td></td>
                <td></td>
                <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
              </tr>
            </tbody>
          </table> -->
        </div>
      </main>
    
      <!-- <footer class="pt-4 my-md-5 pt-md-5 border-top">
        <div class="row">
          <div class="col-12 col-md">
            <img class="mb-2" src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="24" height="19">
            <small class="d-block mb-3 text-muted">&copy; 2017–2021</small>
          </div>
          <div class="col-6 col-md">
            <h5>Features</h5>
            <ul class="list-unstyled text-small">
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Cool stuff</a></li>
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Random feature</a></li>
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Team feature</a></li>
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Stuff for developers</a></li>
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Another one</a></li>
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Last time</a></li>
            </ul>
          </div>
          <div class="col-6 col-md">
            <h5>Resources</h5>
            <ul class="list-unstyled text-small">
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Resource</a></li>
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Resource name</a></li>
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Another resource</a></li>
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Final resource</a></li>
            </ul>
          </div>
          <div class="col-6 col-md">
            <h5>About</h5>
            <ul class="list-unstyled text-small">
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Team</a></li>
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Locations</a></li>
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Privacy</a></li>
              <li class="mb-1"><a class="link-secondary text-decoration-none" href="#">Terms</a></li>
            </ul>
          </div>
        </div>
      </footer> -->
    </div>
    
    
        
      </body>
</html>
