package com.arelance.servlets.ocultos;

import com.arelance.service.ActivityCrud;
import com.arelance.service.factory.Factory;
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

    private static final long serialVersionUID = 1L;

    @Inject
    private Factory<ActivityCrud> activityFactory;

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

        request.setAttribute("activitiesList", activityFactory.buildCrud().readAllEntities());
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
