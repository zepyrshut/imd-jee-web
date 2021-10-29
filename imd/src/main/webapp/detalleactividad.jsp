    
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!doctype html>
<html lang="es">
    <!-- HTML head -->
    <%@ include file="/jspf/head.jspf" %>
    <body>
        <!-- Barra navegación -->
        <%@ include file="/jspf/navbar.jspf" %>   
        <main class="uk-container uk-container-small font-ubuntu">
            <figure class="uk-align-center uk-text-center padding-top-medium">
                <div class="uk-height-medium uk-flex uk-flex-center uk-flex-middle uk-background-cover uk-light"
                     data-src="img/<c:out value="${actividad.nombreActividad}"/>.jpg" uk-img>
                    <h1 class="font-merriweather uk-overlay uk-overlay-primary"><c:out value="${actividad.nombreActividad}"/></h1>
                </div>
            </figure>
            <table style="width: 100%; border: 1px solid black "  class="uk-child-width-expand@s" uk-grid>
                <tr>
                    <td style="width: 50%; border: 1px solid black">
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
                    </td>
                    <td style="width: 50%; ; border: 1px solid black">
                        <p class="uk-text-lead">Descripción y entrenador</p>
                        <p class="uk-text-justify">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam debitis voluptatem libero nisi.
                            Sed harum numquam nam autem quidem, sapiente totam incidunt, repellendus maxime praesentium
                            tempore optio voluptatem voluptate necessitatibus.</p>
                        <p>Apto para todas las edades.</p>
                        <p>El entrenador de esta actividad es <c:out value="${actividad.entrenadorTieneActividad.entrenador.nombre}"/>.</p>
                    </td>
                </tr>           
                <c:if test="${usuario == null}">
                    <tr>
                    <p> Para poder inscribirse en la actividad, debes primero <a href="login">iniciar sesión</a>.</p>
                    </tr>
                </c:if>
                <c:if test="${usuario != null}">
                    <tr class="uk-grid-small uk-child-width-auto padding-top-small" uk-grid>
                        <td style="width: 50%; ; border: 1px solid black">
                            <p class="uk-text-lead">Detalles de pago</p>
                            <p>Seleccione el método de pago deseado para la inscripción de la actividad.</p>
                        </td>
                        <td style="width: 50%; ; border: 1px solid black"> 
                            <form>
                                <button class="uk-button uk-button-primary" href="inscripcionactividad">¡Inscribirse!</button>
                            </form>
                        </td>
                        <td> 
                            <a class="uk-button uk-button-secondary" href="#">¿Tienes dudas?, escríbenos.</a>
                        </td>
                    </tr>
                </c:if> 
            </table>
        </main>
        <!-- Pie de página -->
        <%@ include file="/jspf/footer.jspf" %> 
    </body>
</html>
