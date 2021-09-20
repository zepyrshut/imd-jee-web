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

        <div class="uk-container uk-container-small uk-padding">
            <div class="uk-align-center uk-padding-small uk-text-center padding-top-medium">
                <h1 class="font-merriweather">¡Bienvenidos a IMD!</h1>
            </div>
            <form class="uk-grid-small uk" uk-grid>
                <div class="uk-width-1-3@s">
                    <div class="uk-inline uk-text-center">
                        <span class="uk-form-icon" uk-icon="icon: user"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                            placeholder="Nombre" required />
                    </div>
                </div>
                <div class="uk-width-1-3@s">
                    <div class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon: user"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                            placeholder="Primer apellido" required />
                    </div>
                </div>
                <div class="uk-width-1-3@s">
                    <div class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon: user"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                            placeholder="Segundo apellido" required />
                    </div>
                </div>
                <div class="uk-width-1-2@s">
                    <div class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon: mail"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                            placeholder="Correo electrónico" required />
                    </div>
                </div>
                <div class="uk-width-1-2@s">
                    <div class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon:  receiver"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                            placeholder="Teléfono" required />
                    </div>
                </div>
                <div class="uk-width-1-2@s">
                    <div class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon: user"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                            placeholder="Usuario" required />
                    </div>
                </div>
                <div class="uk-width-1-2@s">
                    <div class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon:  lock"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="password"
                            placeholder="Contraseña" required />
                    </div>
                </div>
                <div class="uk-align-center uk-padding-small">
                    <input type="submit" class="uk-button uk-button-primary" value="Registrarse" />
                    <input type="reset" class="uk-button uk-button-danger" value="Borrar" />
                </div>
            </form>
        </div>
        <!-- Fin registro usuario -->
    </main>
        
                  <!-- Pie de página -->
        <%@ include file="/jspf/footer.jspf" %> 

        
        
    </body>
</html>
