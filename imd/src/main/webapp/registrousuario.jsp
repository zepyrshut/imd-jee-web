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
        <!-- Barra navegación -->
        <%@ include file="/jspf/navbar.jspf" %>   

        <main>
            <!-- Registro usuario -->

            <section class="uk-container uk-container-small uk-padding">
                <div class="uk-align-center uk-padding-small uk-text-center padding-top-medium">
                    <h1 class="font-merriweather">¡Bienvenidos a IMD!</h1>
                </div>
                <c:if test="${usuarioRepetido != null}">
                    <div class="uk-alert-danger" uk-alert>
                        <a class="uk-alert-close" uk-close></a>
                        <p><c:out value="${usuarioRepetido}"/></p>
                    </div>                
                </c:if>
                <c:if test="${emailRepetido != null}">
                    <section class="uk-alert-danger" uk-alert>
                        <a class="uk-alert-close" uk-close></a>
                        <p><c:out value="${emailRepetido}"/></p>
                    </section>                
                </c:if>
                <c:if test="${usuarioRegistrado != null}">
                    <div class="uk-alert-success" uk-alert>
                        <a class="uk-alert-close" uk-close></a>
                        <p><c:out value="${usuarioRegistrado}"/></p>
                    </div>                
                </c:if>

                <form class="uk-grid-small uk" uk-grid method="POST" action="registro">
                    <div class="uk-width-1-3@s">
                        <div class="uk-inline uk-text-center">
                            <span class="uk-form-icon" uk-icon="icon: user"></span>
                            <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                                   placeholder="Nombre" name="nombre" required />
                        </div>
                    </div>
                    <div class="uk-width-1-3@s">
                        <div class="uk-inline">
                            <span class="uk-form-icon" uk-icon="icon: user"></span>
                            <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                                   placeholder="Primer apellido" name="apellido_a" required />
                        </div>
                    </div>
                    <div class="uk-width-1-3@s">
                        <div class="uk-inline">
                            <span class="uk-form-icon" uk-icon="icon: user"></span>
                            <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                                   placeholder="Segundo apellido" name="apellido_b" />
                        </div>
                    </div>
                    <div class="uk-width-1-2@s">
                        <div class="uk-inline">
                            <span class="uk-form-icon" uk-icon="icon: mail"></span>
                            <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                                   placeholder="Correo electrónico" name="email" required />
                        </div>
                    </div>
                    <div class="uk-width-1-2@s">
                        <span class="uk-inline">
                            <span class="uk-form-icon" uk-icon="icon:  receiver"></span>
                            <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                                   placeholder="Teléfono" name="telefono" />
                        </span>
                    </div>
                    <div class="uk-width-1-2@s">
                        <span class="uk-inline">
                            <span class="uk-form-icon" uk-icon="icon: user"></span>
                            <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                                   placeholder="Usuario" name="usuario" required />
                        </span>
                    </div>
                    <div class="uk-width-1-2@s">
                        <span class="uk-inline">
                            <span class="uk-form-icon" uk-icon="icon:  lock"></span>
                            <input class="uk-input form-width-xlarge" id="form-stacked-text" type="password"
                                   placeholder="Contraseña" name="contrasena" required />
                        </span>
                    </div>
                    <span class="uk-align-center uk-padding-small">
                        <input type="submit" class="uk-button uk-button-primary" value="Registrarse" />
                        <input type="reset" class="uk-button uk-button-danger" value="Borrar" />
                    </span>
                </form>
            </section>
            <!-- Fin registro usuario -->
        </main>

        <!-- Pie de página -->
        <%@ include file="/jspf/footer.jspf" %> 



    </body>
</html>
