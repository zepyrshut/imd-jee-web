    
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!doctype html> <!-- meter el charset utf en un header aparte-->
<html lang="es">
    <!-- HTML head -->
    <%@ include file="/jspf/head.jspf" %>
    <body>
        <!-- Barra navegación -->
        <%@ include file="/jspf/navbar.jspf" %>   
        <main>
            
            <div class="uk-child-width-1-1 uk-child-width-1-3@m uk-grid-match uk-padding" uk-grid>    
                <c:forEach var="actividad" items="${listaActividad}" begin="0" end="5">  
                    <div>
                        <div class="uk-card uk-card-default uk-box-shadow-hover-xlarge">
                            <div class="uk-background-cover" data-src="img/<c:out value="${actividad.nombreActividad}"/>.jpg" uk-img>
                                <div class="uk-card-header uk-overlay uk-overlay-default">                                
                                    <div class="uk-grid-small uk-flex-middle" uk-grid>

                                        <div class="uk-width-expand">                       
                                            <h3 class="uk-card-title uk-margin-remove-bottom"><c:out value="${actividad.nombreActividad}"/></h3>
                                            <p class="uk-text-meta uk-margin-remove-top"><c:out value="${actividad.categoriaActividad}"/></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="uk-card-body">
                                <p><c:out value="${actividad.descripcionActividad}"/></p>
                                <p>Entrenador: <c:out value="${actividad.entrenadorTieneActividad.entrenador.nombre}"/>.</p>
                            </div>
                            <div class="uk-card-footer">
                                <a href="#" class="uk-button uk-button-text">VER MÁS SOBRE <c:out value="${actividad.nombreActividad}"/></a>
                            </div>
                        </div>
                    </div>
                </c:forEach> 
            </div>
        </main>        
        <!-- Pie de página -->
        <%@ include file="/jspf/footer.jspf" %> 
    </body>
</html>
