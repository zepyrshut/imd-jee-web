
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
  


 
  <main>
   
<section class="mb-5">

    <div class="row">
      <div class="col-md-6 mb-4 mb-md-0">
  
        <div id="mdb-lightbox-ui"></div>
  
        <div class="mdb-lightbox">
  
          <div class="row product-gallery mx-1">
  
            <div class="col-12 mb-0">
              <figure class="view overlay rounded z-depth-1 main-img">
                <a href="https://www.aecc.es/sites/default/files/inline-images/actividad-fisica_0.jpg"
                  data-size="710x823">
                  <img src="https://www.aecc.es/sites/default/files/inline-images/actividad-fisica_0.jpg"
                    class="img-fluid z-depth-1">
                </a>
              </figure>
            
             
            </div>
          </div>
  
        </div>
  
      </div>
      <div class="col-md-6">
   <c:forEach var="actividad" items="${listaActividad}">  
            
            
         
        <h5> <c:out value="${actividad.nombreActividad}"/> </h5>
        <p class="mb-2 text-muted text-uppercase small"> Categoria</p>

        <p><span class="mr-1"><strong>$12.99</strong></span></p>
        <p class="pt-1">Descripcion actividad</p>
        <div class="table-responsive">
          <table class="table table-sm table-borderless mb-0">
            <tbody>
              <tr>
                <th class="pl-0 w-25" scope="row"><strong>Entrenador</strong></th>
                <td>Nombre entrenador</td>
              </tr>
              <tr>
                <th class="pl-0 w-25" scope="row"><strong>Fecha 1</strong></th>
                <td>Info fecha 1</td>
              </tr>
              <tr>
                <th class="pl-0 w-25" scope="row"><strong>Fecha 2</strong></th>
                <td>Info fecha 2</td>
              </tr>
            </tbody>
          </table>
        </div>
        <hr>
        <div class="table-responsive mb-2">
          <table class="table table-sm table-borderless">
            <tbody>
              <tr>
              
                <td class="pb-0">Tipo de pago</td>
              </tr>
              <tr>

                <td>
                  <div class="mt-1">
                    <div class="form-check form-check-inline pl-0">
                      <input type="radio" class="form-check-input" id="small" name="materialExampleRadios"
                        checked>
                      <label class="form-check-label small text-uppercase card-link-secondary"
                        for="small">Pago 1</label>
                    </div>
                    <div class="form-check form-check-inline pl-0">
                      <input type="radio" class="form-check-input" id="medium" name="materialExampleRadios">
                      <label class="form-check-label small text-uppercase card-link-secondary"
                        for="medium">Pago 2</label>
                    </div>
                    <div class="form-check form-check-inline pl-0">
                      <input type="radio" class="form-check-input" id="large" name="materialExampleRadios">
                      <label class="form-check-label small text-uppercase card-link-secondary"
                        for="large">Pago 3</label>
                    </div>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <button type="button" class="btn btn-primary btn-md mr-1 mb-2">Pagar</button>
         </c:forEach>  
      </div>
    </div>
  
  </section>
  

</main>
    
  </body>
</html>
