package com.arelance.servlets.commands;

import com.arelance.domain.Actividad;
import com.arelance.domain.Usuario;
import com.arelance.service.UsuarioService;
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
    private UsuarioService usuarioService;

    @Inject
    private Actividad actividad;

    @Inject
    private Usuario usuario;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        actividad = (Actividad) request.getSession().getAttribute("actividad");
        usuario = (Usuario) request.getSession().getAttribute("usuario");
       usuario.getUsuarioTieneActividad();
//        boolean remove = usuario.getUsuarioTieneActividad().remove(actividad);
//        if (remove) {
//        usuarioService.updateUsuario(usuario);
//        } else {
//            // TODO - Añadir mensajes de error.
//            usuarioService.updateUsuario(usuario);
//        }

        return "/detalleactividad.jsp";

    }

}
