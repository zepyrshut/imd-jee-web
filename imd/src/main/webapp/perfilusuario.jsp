
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
      
  <div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
          
        </div>
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Perfil</h4>
                </div>
                <div class="row mt-2">
                    <div class="col-md-6"><label class="labels">Nick</label><input type="text" class="form-control" placeholder="(deshabilitado)" value=""></div>
                    <div class="col-md-6"><label class="labels">Nombre</label><input type="text" class="form-control" value="" placeholder="obligatorio"></div>
                    
                </div>
                <div class="row mt-3">
                    <div class="col-md-12"><label class="labels">Apellido 1</label><input type="text" class="form-control" placeholder="obligatorio" value=""></div>
                    <div class="col-md-12"><label class="labels">Apellido 2</label><input type="text" class="form-control" placeholder="opcional" value=""></div>
                    <div class="col-md-12"><label class="labels">Telefono</label><input type="text" class="form-control" placeholder="obligatorio" value=""></div>
                    <div class="col-md-12"><label class="labels">Email</label><input type="text" class="form-control" placeholder="obligatorio" value=""></div>
                </div>

                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Guardar cambios</button></div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="p-3 py-5">
                <a class="me-3 py-2 text-dark text-decoration-none" href="metodospago.jsp">METODOS PAGO</a>
                <div class="d-flex justify-content-between align-items-center experience"><span>Metodos de pago</span></div><br>
                <div class="col-md-12"><label class="labels">Pago 1</label><input type="text" class="form-control" placeholder="pago 1" value=""></div> <br>
                <div class="col-md-12"><label class="labels">Pago 2</label><input type="text" class="form-control" placeholder="pago 2" value=""></div>
                <div class="col-md-12"><label class="labels">Pago 3</label><input type="text" class="form-control" placeholder="pago 3" value=""></div>
            </div>
        </div>
    </div>
</div>
</div>
</div>

 

</main>
  </body>
</html>
