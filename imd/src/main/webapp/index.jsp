    
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
            <div class="uk-child-width-1-3@m uk-child-width-1-2@s uk-grid-match uk-padding" uk-grid id="pocosarticulos">
                <c:forEach var="actividad" items="${listaActividad}">  
                   
                        <c:out value="${actividad.nombreActividad}"/>
                            
           <c:out value="${actividad.nombreActividad}"/>
           <c:out value="${actividad.categoriaActividad}"/>


                       
                                <c:out value="${actividad.descripcionActividad}"/>
                              
                                <c:out value="${actividad.entrenadorTieneActividad.entrenador.nombre}"/>.
                        
                        
                                <a href="actividad?idActividad=${actividad.idActividad}">VER MÁS SOBRE <c:out value="${actividad.nombreActividad}"/></a>
                      

                </c:forEach> 
            </div>
            <p>-COMIENZO TEST PAGINACION </p>
             <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Nombre act</th>
            <th>categoriaActividad</th>
            <th>descripcionActividad</th>
            <th>idActividad</th>
        </tr>
 
        <c:forEach var="actividad" items="${listaActividad}">
            <tr>
                <td>${actividad.nombreActividad}</td>
                <td>${actividad.categoriaActividad}</td>
                <td>${actividad.descripcionActividad}</td>
                <td>${actividad.idActividad}</td>
            </tr>
        </c:forEach>
    </table>
 
    <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <td><a href="actividad.principal?page=${currentPage - 1}">Previous</a></td>
    </c:if>
 
    <%--For displaying Page numbers.
    The when condition does not display a link for the current page--%>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="actividad.principal?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
 
    <%--For displaying Next link --%>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="actividad.principal?page=${currentPage + 1}">Next</a></td>
    </c:if>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            <p>FIN Test paginacion </p>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
                        <div class="uk-child-width-1-3@m uk-child-width-1-2@s uk-grid-match uk-padding" uk-grid id="muchosarticulos" style="display:none"> <%-- pasar style a css --%>
                <c:forEach var="actividad" items="${listaActividad}" >  
                    <div>
                        <div class="uk-card uk-card-default uk-box-shadow-hover-xlarge">
                            <div class="uk-background-cover" data-src="img/<c:out value="${actividad.nombreActividad}"/>.jpg" uk-img>
                                <div class="uk-card-header uk-overlay uk-overlay-default">
                                    <div class="uk-grid-small uk-flex-middle" uk-grid>
                                        <div class="uk-width-expand">
                                            <h3 class="uk-card-title uk-margin-remove-bottom font-merriweather"><c:out value="${actividad.nombreActividad}"/></h3>
                                            <p class="uk-text-meta uk-margin-remove-top font-ubuntu"><c:out value="${actividad.categoriaActividad}"/></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="uk-card-body font-ubuntu">
                                <p><c:out value="${actividad.descripcionActividad}"/>
                                </p>
                                <p>Entrenador: <c:out value="${actividad.entrenadorTieneActividad.entrenador.nombre}"/>.</p>
                            </div>
                            <div class="uk-card-footer">
                                <a href="detalleactividad.html" class="uk-button uk-button-text font-ubuntu">VER MÁS SOBRE <c:out value="${actividad.nombreActividad}"/></a>
                            </div>
                        </div>
                    </div>
                </c:forEach> 
            </div>
                   <div>
                       <button onclick="mostrar_ocultar()" id="mostrarmenosmas">Mostrar mas contenido</button>
        </div>
        </main>        
        <!-- Pie de página -->
        <%@ include file="/jspf/footer.jspf" %> 
      
     
        <script src="extensionarticulos.js"></script>
    </body>
</html>
