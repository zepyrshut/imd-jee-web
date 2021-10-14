package com.arelance.servlets.commands;

import com.arelance.domain.Actividad;
import com.arelance.domain.Usuario;
import com.arelance.service.ActividadService;
import com.arelance.servlets.commands.qualifiers.ActivityUnsubcriptionQ;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@ActivityUnsubcriptionQ
public class ActivityUnsubscription implements ActionsController {

    @Inject
    private ActividadService actividadService;
        
    @Inject
    private Actividad actividad;
    
    @Inject
    private Usuario usuario;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        actividad = (Actividad) request.getSession().getAttribute("actividad");
        usuario = (Usuario) request.getSession().getAttribute("usuario");

        actividad.eliminarUsuario(usuario);
        actividadService.updateActividad(actividad);

        return "/detalleactividad.jsp";

    }

}
