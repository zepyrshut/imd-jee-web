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
        <main class="uk-container uk-container-small uk-padding uk-padding-small">
            <!-- Registro usuario -->
            <header class="padding-top-medium uk-text-center uk-padding">
                <h1 class="">¡Bienvenidos a IMD!</h1>
            </header>
            <section>
                <c:if test="${usuarioRepetido != null}">
                    <article class="uk-alert-danger uk-text-left" uk-alert>
                        <a class="uk-alert-close" uk-close></a>
                        <p><c:out value="${usuarioRepetido}"/></p>
                    </article>                
                </c:if>
                <c:if test="${emailRepetido != null}">
                    <article class="uk-alert-danger uk-text-left" uk-alert>
                        <a class="uk-alert-close" uk-close></a>
                        <p><c:out value="${emailRepetido}"/></p>
                    </article>                
                </c:if>
                <c:if test="${usuarioRegistrado != null}">
                    <article class="uk-alert-success uk-text-left" uk-alert>
                        <a class="uk-alert-close" uk-close></a>
                        <p><c:out value="${usuarioRegistrado}"/></p>
                    </article>                
                </c:if>
            </section>
            <form class="uk-grid-small uk" uk-grid method="POST" action="actions?action=register">
                <div class="uk-width-1-3@s">
                    <article class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon: user"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                               placeholder="Nombre" name="nombre" required />
                    </article>
                </div>
                <div class="uk-width-1-3@s">
                    <article class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon: user"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                               placeholder="Primer apellido" name="apellido_a" required />
                    </article>
                </div>
                <div class="uk-width-1-3@s">
                    <article class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon: user"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                               placeholder="Segundo apellido" name="apellido_b" />
                    </article>
                </div>
                <div class="uk-width-1-2@s">
                    <article class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon: mail"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                               placeholder="Correo electrónico" name="email" required />
                    </article>
                </div>
                <div class="uk-width-1-2@s">
                    <article class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon:  receiver"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                               placeholder="Teléfono" name="telefono" />
                    </article>
                </div>
                <div class="uk-width-1-2@s">
                    <article class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon: user"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="text"
                               placeholder="Usuario" name="usuario" required />
                    </article>
                </div>
                <div class="uk-width-1-2@s">
                    <article class="uk-inline">
                        <span class="uk-form-icon" uk-icon="icon:  lock"></span>
                        <input class="uk-input form-width-xlarge" id="form-stacked-text" type="password"
                               placeholder="Contraseña" name="contrasena" required />
                    </article>
                </div>
                <footer class="uk-align-center uk-padding-small">
                    <input type="submit" class="uk-button uk-button-primary" value="Registrarse" />
                    <input type="reset" class="uk-button uk-button-danger" value="Borrar" />
                </footer>
            </form>
        </div>
        <!-- Fin registro usuario -->
    </main>
    <!-- Pie de página -->
    <%@ include file="/jspf/footer.jspf" %> 
</body>
</html>
