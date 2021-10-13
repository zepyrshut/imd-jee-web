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
                <c:if test="${datoIncorrecto == null}">
                    <h1 class="font-merriweather">¡Hola de nuevo!</h1>
                </c:if>
                <c:if test="${datoIncorrecto != null}">
                    <h1 class="font-merriweather">¡Oops!</h1>
                </c:if>
            </div>
            <main class="uk-text-center uk-padding-small">
                <section>         
                    <c:if test="${datoIncorrecto != null}">
                        <article class="uk-alert-danger  uk-text-left"  id="mensajeError"  uk-alert>
                            <a class="uk-alert-close" uk-close></a>
                            <p><c:out value="${datoIncorrecto}"/></p>
                        </article>                
                    </c:if>            
                </section>
                <!-- Inicio de formulario -->
                <form class="uk-grid-small" method="POST" action="actions?action=login">
                    <div class="uk-form-controls uk-padding-small">
                        <article class="uk-inline">
                            <span class="uk-form-icon" uk-icon="icon: user"></span>
                            <input class="uk-input uk-form-width-large" id="usuario-login" onclick="cambioNeutral()"  type ="text"
                                   placeholder="Usuario" name="usuario" required />
                        </article>
                    </div>
                    <div class="uk-form-controls uk-padding-small">
                        <article class="uk-inline">
                            <span class="uk-form-icon" uk-icon="icon: lock"></span>
                            <input class="uk-input uk-form-width-large" id="contrasena-login" onclick="cambioNeutral()" type ="password"
                                   placeholder="Contraseña" name="contrasena" required />
                        </article>
                    </div>
                    <footer class="uk-padding">
                        <input type="submit" class="uk-button uk-button-primary" value="Iniciar sesión" />
                        <input type="reset" class="uk-button uk-button-danger" value="Borrar" />
                    </footer>
                </form>
                <!-- Fin de formulario -->
            </main>
            <c:if test="${datoIncorrecto != null}">
                <script>
                    var usuario = document.getElementById('usuario-login');
                    var contrasena = document.getElementById('contrasena-login');
                    usuario.classList.add('uk-form-danger');
                    contrasena.classList.add('uk-form-danger');
                </script>
                <script>
                    function cambioNeutral() {
                        var usuario = document.getElementById('usuario-login');
                        var contrasena = document.getElementById('contrasena-login');
                        var mensajeError = document.getElementById('mensajeError');
                        usuario.classList.remove('uk-form-danger');
                        contrasena.classList.remove('uk-form-danger');
                        mensajeError.parentNode.removeChild(mensajeError);
                    }
                </script>
            </c:if>
            <!-- Pie de página -->
            <%@ include file="/jspf/footer.jspf" %> 
    </body>
</html>
