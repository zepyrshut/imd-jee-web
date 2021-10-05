package com.arelance.servlets;

import com.arelance.service.ActividadService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet("/principal")
public class Principal extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private ActividadService actividadService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("listaActividad", actividadService.listarActividades());
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

}
