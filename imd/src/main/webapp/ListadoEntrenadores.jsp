   
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
                <c:forEach var="entrenador" items="${listaEntrenadores}">  
                 
                    <p>   ${entrenador.nombre}" </p>
                       
                    
                </c:forEach> 
            </div>
              
         
        </main>        
        <!-- Pie de página -->
        <%@ include file="/jspf/footer.jspf" %> 
      
     
        <script src="extensionarticulos.js"></script>
    </body>
</html>