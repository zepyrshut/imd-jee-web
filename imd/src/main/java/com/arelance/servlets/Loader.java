package com.arelance.servlets;

import com.arelance.service.ActividadService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
public class Loader implements ServletAction {

    @Inject
    private ActividadService actividadService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setAttribute("listaActividad", actividadService.listarActividades());
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        return "loader";
    }

}
