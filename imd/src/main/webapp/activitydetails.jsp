    
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!doctype html>
<html lang="es">
    <!-- HTML head -->
    <%@ include file="/jspf/head.jspf" %>
    <body>
        <!-- Barra navegación -->
        <%@ include file="/jspf/navbar.jspf" %>   

        <main class="uk-container uk-container-small">
            <header class="uk-text-center padding-top-medium">
                <figure class="uk-background-cover uk-margin-remove"
                        data-src="img/<c:out value="${actividad.nombreActividad}"/>.jpg" uk-img>
                    <figcaption class="uk-height-medium uk-overlay uk-overlay-default uk-flex uk-flex-middle uk-flex-center blur">
                        <h1><c:out value="${actividad.nombreActividad}"/></h1>
                    </figcaption>
                </figure>
            </header>
            <section>
                <article class="uk-child-width-expand@s padding-top-small" uk-grid>
                    <div>
                        <p class="uk-text-lead">Horarios</p>
                        <p>Horario de mañanas:</p>
                        <ul>
                            <li>Niños: no aplica en esta temporada.</li>
                            <li>Adolescentes: no aplica en esta temporada.</li>
                            <li>Adultos: Sábados de 11:00 a 12:00</li>   
                            <li>Senior: Sábados de 10:00 a 11:00</li>                 
                        </ul>
                        <p>Horario de tardes:</p>
                        <ul>
                            <li>Niños: Lunes a viernes de 16:00 a 17:00</li>
                            <li>Adolescentes: Lunes a viernes de 17:00 a 18:00</li>
                            <li>Adultos: Lunes a viernes de 18:00 a 19:00</li>
                            <li>Senior: no aplica en esta temporada.</li>
                        </ul>
                    </div>
                    <div>
                        <p class="uk-text-lead">Descripción y entrenador</p>
                        <p class="uk-text-justify">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam debitis voluptatem libero nisi.
                            Sed harum numquam nam autem quidem, sapiente totam incidunt, repellendus maxime praesentium
                            tempore optio voluptatem voluptate necessitatibus.</p>
                        <p>Apto para todas las edades.</p>
                        <p>El entrenador de esta actividad es <c:out value="${actividad.entrenadorTieneActividad.entrenador.nombre}"/>.</p>
                    </div>
                    </div>
                </article>
            </section>
            <section>
                <c:if test="${usuario == null}">    
                    <article>
                        <p> Para poder inscribirse en la actividad, debes primero <a href="login">iniciar sesión</a>.</p>
                    </article>
                </c:if>
                <c:if test="${usuario != null}">
                    <form action="actions?action=activityinscription" method="POST">
                                        <label for="metodoPago">Elige método de pago:</label>
                    <select name="metodoPago">
                        <c:forEach items="${usuario.metodoPago}" var="metodoPago" varStatus="forLoop">
                            <option value=${forLoop.index}>${metodoPago.nombrepago}</option>
                        </c:forEach>
                    </select>
                                        
                                       <input type="submit" class="uk-button uk-button-primary" value="Inscribirse" />
                    </form>
                    
                    
                    <article class="uk-grid-small uk-child-width-auto padding-top-small" uk-grid>
                        <p><a class="uk-button uk-button-primary" href="actions?action=activityinscription">¡Inscribirse!</a></p>
                        <p><a class="uk-button uk-button-secondary" href="#">¿Tienes dudas?, escríbenos.</a></p>
                    </article>
                    <aside class="uk-margin">
                        <p class="uk-text-lead">Detalles de pago</p>
                        <p>Seleccione el método de pago deseado para la inscripción de la actividad.</p>
                    </aside>

                    <c:forEach items="${usuario.metodoPago}" var="metodoPago" varStatus="forLoop">
                        <p>${metodoPago.nombrepago} ${forLoop.index}</p>
                    </c:forEach>




                </c:if>
            </section>
        </main>
        <!-- Pie de página -->
        <%@ include file="/jspf/footer.jspf" %> 
    </body>
</html>
