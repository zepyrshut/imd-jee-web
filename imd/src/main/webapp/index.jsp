    
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!doctype html> <!-- meter el charset utf en un header aparte-->
<html lang="es">
    <!-- HTML head -->
    <%@ include file="/jspf/head.jspf" %>
    <body>
        <!-- Barra navegación -->
        <%@ include file="/jspf/navbar.jspf" %>   
        <main class="uk-container uk-container-large">
            <section class="uk-child-width-1-3@m uk-child-width-1-2@s uk-grid-match uk-padding" uk-grid id="pocosarticulos">
                <c:forEach var="actividad" items="${listaActividad}">  
                    <section>
                        <article class="uk-card uk-card-default uk-box-shadow-hover-xlarge">
                            <section class="uk-background-cover" data-src="img/<c:out value="${actividad.nombreActividad}"/>.jpg" uk-img>
                                <header class="uk-card-header uk-overlay uk-overlay-default">
                                    <figure class="uk-grid-small uk-flex-middle" uk-grid>
                                        <div class="uk-width-expand">
                                            <h3 class="uk-card-title uk-margin-remove-bottom font-merriweather"><c:out value="${actividad.nombreActividad}"/></h3>
                                            <p class="uk-text-meta uk-margin-remove-top font-ubuntu"><c:out value="${actividad.categoriaActividad}"/></p>
                                        </div>
                                    </figure>
                                </header>
                            </section>
                            <article class="uk-card-body font-ubuntu">
                                <p><c:out value="${actividad.descripcionActividad}"/>
                                </p>
                                <p>Entrenador: <c:out value="${actividad.entrenadorTieneActividad.entrenador.nombre}"/>.</p>
                            </article>
                            <footer class="uk-card-footer">
                                <a href="actividad?idActividad=${actividad.idActividad}" class="uk-button uk-button-text font-ubuntu">VER MÁS SOBRE <c:out value="${actividad.nombreActividad}"/></a>
                            </footer>
                        </article>
                    </section>
                </c:forEach> 
            </section>
        </main>        
        <!-- Pie de página -->
        <%@ include file="/jspf/footer.jspf" %> 
        <script src="extensionarticulos.js"></script>
    </body>
</html>
