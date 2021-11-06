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
                <c:forEach var="activity" items="${activitiesList}" begin="0" end="5">  
                    <div>
                        <div class="uk-card uk-card-default uk-box-shadow-hover-xlarge">
                            <div class="uk-background-cover" data-src="img/<c:out value="${activity.activityName}"/>.jpg" uk-img>
                                <div class="uk-card-header uk-overlay uk-overlay-default">
                                    <div class="uk-grid-small uk-flex-middle" uk-grid>
                                        <div class="uk-width-expand">
                                            <h3 class="uk-card-title uk-margin-remove-bottom font-merriweather"><c:out value="${activity.activityName}"/></h3>
                                            <p class="uk-text-meta uk-margin-remove-top font-ubuntu"><c:out value="${activity.activityCategory}"/></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="uk-card-body font-ubuntu">
                                <p><c:out value="${activity.activityDescription}"/>
                                </p>
                                <p>Entrenador: <c:out value="${activity.trainerHasActivity.trainer.nameTrainer}"/>.</p>
                            </div>
                            <div class="uk-card-footer">
                                <a href="actions?action=activitydescription&amp;idactividad=${activity.activityId}" class="uk-button uk-button-text font-ubuntu">VER MÁS SOBRE <c:out value="${activity.activityName}"/></a>
                            </div>
                        </div>
                    </div>
                </c:forEach> 
            </div>
        </main>        
        <!-- Pie de página -->
        <%@ include file="/jspf/footer.jspf" %> 
      
     
        <script src="extensionarticulos.js"></script>
    </body>
</html>
