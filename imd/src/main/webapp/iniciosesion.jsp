<%-- 
    Document   : iniciosesion
    Created on : 19 sept. 2021, 0:42:37
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <!-- HTML head -->
    <%@ include file="/jspf/head.jspf" %>
    <body>
        <!-- Barra navegación -->
        <%@ include file="/jspf/navbar.jspf" %>   

        <main>


            <div class="uk-container uk-container-small  uk-padding">

                <div class="uk-align-center uk-padding-small uk-text-center">
                    <h1>¡Hola de nuevo!</h1>
                </div>


                <form class="uk-grid-small" uk-grid>



                    <div  class="uk-width-1-1">
                        <label class="uk-form-label" for="form-stacked-text">Usuario:</label>
                        <div class="uk-form-controls">
                            <input class="uk-input" id="form-stacked-text" type="text" required>
                        </div>
                    </div>
                    <div  class="uk-width-1-1">
                        <label class="uk-form-label" for="form-stacked-text">Contraseña:</label>
                        <div class="uk-form-controls">
                            <input class="uk-input" id="form-stacked-text" type="password" required>
                        </div>
                    </div>


                    <div class="uk-align-center  uk-padding-small">

                        <input type="submit" class="uk-button uk-button-primary" value="Iniciar sesión">
                        <input type="reset" class="uk-button uk-button-danger" value="Borrar">        
                    </div>

                </form>




            </div>















        </main>

    </body>
</html>
