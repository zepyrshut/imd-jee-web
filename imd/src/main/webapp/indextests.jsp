<%-- 
    Document   : indextests
    Created on : 28-oct-2021, 13:45:48
    Author     : George_Fullstack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INDEX TEST</title>
    </head>
    <body>
        <h1>Paginacion de actividades</h1>
        <c:forEach var="actividad" items="${listaActividad}" begin="0" end="5">  


                            <c:out value="${actividad.nombreActividad}"/>.jpg" uk-img>


                                        <c:out value="${actividad.nombreActividad}"/>
                                      <c:out value="${actividad.categoriaActividad}"/></p>

                                <c:out value="${actividad.descripcionActividad}"/>
                       
                                <p>Entrenador: <c:out value="${actividad.entrenadorTieneActividad.entrenador.nombre}"/>.</p>
                            </div>
                            <div class="uk-card-footer">
                                <a href="actividad?idActividad=${actividad.idActividad}" class="uk-button uk-button-text font-ubuntu">VER MÁS SOBRE <c:out value="${actividad.nombreActividad}"/></a>
                            </div>
                        </div>
                    </div>
                </c:forEach> 
         
    </body>
</html>
