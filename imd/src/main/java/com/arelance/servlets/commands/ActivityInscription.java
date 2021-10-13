package com.arelance.servlets.commands;

import com.arelance.domain.Actividad;
import com.arelance.servlets.commands.qualifiers.ActivityInscriptionQ;
import com.arelance.domain.Usuario;
import com.arelance.service.ActividadService;
import com.arelance.service.UsuarioService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@ActivityInscriptionQ
public class ActivityInscription implements ActionsController {

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private ActividadService actividadService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Actividad actividad = (Actividad) request.getSession().getAttribute("actividad");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        // alta usuario actividad
        // usuario.addActivity(actividad);  
        // usuarioService.updateUsuario(usuario);
        // baja usuario actividad
        actividad.eliminarUsuario(usuario);

        actividadService.updateActividad(actividad);

        return "/detalleactividad.jsp";

    }

}
