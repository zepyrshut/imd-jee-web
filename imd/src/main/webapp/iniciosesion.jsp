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

                <div class="uk-container uk-container-small  uk-padding font-ubuntu">
            <div class="uk-align-center uk-text-center padding-top-medium">
                <h1 class="font-merriweather">¡Hola de nuevo!</h1>
            </div>
        
        
    <main>
        <!-- Inicio de formulario -->
        <div class="uk-text-center uk-padding-small">
            <form>
                <div class="uk-form-controls uk-padding-small">
                    <div class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon: user"></span>
                        <input class="uk-input uk-form-width-large" id="form-stacked-text" type="text"
                            placeholder="Usuario" required />
                    </div>
                </div>
                <div class="uk-form-controls  uk-padding-small">
                    <div class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon: lock"></span>
                        <input class="uk-input uk-form-width-large" id="form-stacked-text" type="password"
                            placeholder="Contraseña" required />
                    </div>
                </div>
                <div class="uk-padding">
                    <input type="submit" class="uk-button uk-button-primary" value="Iniciar sesión" />
                    <input type="reset" class="uk-button uk-button-danger" value="Borrar" />
                </div>
            </form>
        </div>
        <!-- Fin de formulario -->
    </main>
        
                <!-- Pie de página -->
        <%@ include file="/jspf/footer.jspf" %> 

    </body>
</html>
