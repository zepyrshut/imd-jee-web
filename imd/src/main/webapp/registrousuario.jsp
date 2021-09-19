<%-- 
    Document   : registrousuario
    Created on : 19 sept. 2021, 0:36:56
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
       <!-- HTML head -->
    <%@ include file="/jspf/head.jspf" %>
    <body>
        <!-- Barra navegaciÃ³n -->
        <%@ include file="/jspf/navbar.jspf" %>   
        
        <main>





            <!-- Registro usuario -->

            <div class="uk-container uk-container-small  uk-padding">

                <div class="uk-align-center uk-padding-small uk-text-center">

                    <h1>¡Bienvenidos a IMD!</h1>
                </div>
           
            <form class="uk-grid-small" uk-grid method="GET" action="registro">
             
                    <div  class="uk-width-1-3@s">
                    <label class="uk-form-label" for="form-stacked-text">Nombre:</label>
                    <div class="uk-form-controls">
                        <input class="uk-input" id="form-stacked-text" type="text" name="nombre" required>
                    </div>
                </div>
                    <div  class="uk-width-1-3@s">
                    <label class="uk-form-label" for="form-stacked-text">Primer apellido:</label>
                    <div class="uk-form-controls">
                        <input class="uk-input" id="form-stacked-text" type="text" name="apellido_a" required>
                    </div>
                </div>
                    <div  class="uk-width-1-3@s">
                    <label class="uk-form-label" for="form-stacked-text">Segundo apellido:</label>
                    <div class="uk-form-controls">
                        <input class="uk-input" id="form-stacked-text" name="apellido_b" type="text">
                    </div>
                </div>
                    <div  class="uk-width-1-2@s">
                    <label class="uk-form-label" for="form-stacked-text">Teléfono:</label>
                    <div class="uk-form-controls">
                        <input class="uk-input" id="form-stacked-text" name="telefono" type="text">
                    </div>
                </div>
                    <div  class="uk-width-1-2@s">
                    <label class="uk-form-label" for="form-stacked-text">Correo electrónico:</label>
                    <div class="uk-form-controls">
                        <input class="uk-input" id="form-stacked-text" name="email" type="text"  required>
                    </div>
                </div>
                    <div  class="uk-width-1-2@s">
                    <label class="uk-form-label" for="form-stacked-text">Nombre de usuario:</label>
                    <div class="uk-form-controls">
                        <input class="uk-input" id="form-stacked-text" name="usuario" type="text" required>
                    </div>
                </div>

                    <div  class="uk-width-1-2@s">
                    <label class="uk-form-label" for="form-stacked-text">Contraseña:</label>
                    <div class="uk-form-controls">
                        <input class="uk-input" id="form-stacked-text" name="contrasena" type="password" required>
                    </div>
                </div> 
              
                <div class="uk-align-center  uk-padding-small">
                <input type="submit" class="uk-button uk-button-primary" value="Registrarse">
                <input type="reset" class="uk-button uk-button-danger" value="Borrar">        
            </div>



            
               <!--  <div class="uk-margin">
                    <label class="uk-form-label" for="form-stacked-select">Select</label>
                    <div class="uk-form-controls">
                        <select class="uk-select" id="form-stacked-select">
                            <option>Option 01</option>
                            <option>Option 02</option>
                        </select>
                    </div>
                </div>
            
                <div class="uk-margin">
                    <div class="uk-form-label">Radio</div>
                    <div class="uk-form-controls">
                        <label><input class="uk-radio" type="radio" name="radio1"> Option 01</label><br>
                        <label><input class="uk-radio" type="radio" name="radio1"> Option 02</label>
                    </div>
                </div> -->
            
            </form>

        
        
    </body>
</html>
