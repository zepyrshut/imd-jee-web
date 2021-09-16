package com.arelance.servlets;

import com.arelance.service.ActividadService;
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
 */
@WebServlet("/mainservlet")
public class MainServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ActividadService actividadService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setAttribute("listaActividades", actividadService.listarActividades());
        request.getRequestDispatcher("lista.jsp").forward(request, response);

    }

}
