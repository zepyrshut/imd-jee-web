package com.arelance.servlets;

import com.arelance.domain.Actividad;
import com.arelance.service.ActividadService;
import com.arelance.service.UsuarioService;
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
@WebServlet("/cargadescripcionactividades")
public class DescripcionActividades extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private ActividadService actividadService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idActividad = request.getParameter("idActividad");
        Actividad actividad = new Actividad();
        actividad.setIdActividad(Integer.parseInt(idActividad));

        if (idActividad != null) {
            request.getSession().setAttribute("actividad", actividadService.findActividadById(actividad));
        } else {
            request.getSession().removeAttribute("actividad");
        }
        request.getRequestDispatcher("detalleactividad.jsp").forward(request, response);
    }

}
