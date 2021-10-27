package com.arelance.servlets.ocultos;

import com.arelance.domain.Activity;
import com.arelance.service.factory.ActivityFactory;
import com.arelance.service.factory.Crud;
import com.arelance.servlets.commands.qualifiers.ActivityCrudQ;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 * 
 * Primer servlet que carga cuando se inicia la página por primera vez. También
 * es cargada cuando se inicia sesión o cierra sesión.
 */
@WebServlet("/preindex")
public class PreIndexLoader extends HttpServlet {
    
    @Inject
    @ActivityCrudQ
    private Crud<Activity> crudActivity;
    
    @Inject
    private ActivityFactory activityFactory;
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     * 
     * Método que recoge ambas solicitudes y son gestionadas según como proceda,
     * su función es cargar la página inicial con todas las actividades deporti-
     * vas.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        crudActivity = activityFactory.createCrud();

        request.setAttribute("listaActividad", crudActivity.readAllEntity());
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
