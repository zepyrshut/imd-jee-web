package com.arelance.servlets.commands;

import com.arelance.domain.Actividad;
import com.arelance.service.ActividadService;
import com.arelance.servlets.commands.qualifiers.ActivityDescriptionQ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@ActivityDescriptionQ
public class ActivityDescription implements ActionsController {

    @Inject
    private ActividadService actividadService;

    @Inject
    private Actividad actividad;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idActividad = request.getParameter("idactividad");
        actividad.setIdActividad(Integer.parseInt(idActividad));

        if (idActividad != null) {
            request.getSession().setAttribute("actividad", actividadService.findActividadById(actividad));
        } else {
            request.getSession().removeAttribute("actividad");
        }
        return "/detalleactividad.jsp";
    }

}
