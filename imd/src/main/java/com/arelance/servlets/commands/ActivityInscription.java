package com.arelance.servlets.commands;

import com.arelance.domain.Actividad;
import com.arelance.servlets.commands.qualifiers.ActivityUnsubcriptionQ;
import com.arelance.domain.Usuario;
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
@ActivityUnsubcriptionQ
public class ActivityInscription implements ActionsController {

    @Inject
    private UsuarioService usuarioService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Actividad actividad = (Actividad) request.getSession().getAttribute("actividad");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        usuario.addActivity(actividad);
        usuarioService.updateUsuario(usuario);

        return "/detalleactividad.jsp";

    }

}
