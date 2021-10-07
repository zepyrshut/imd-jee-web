package com.arelance.servlets.commands;

import com.arelance.dao.UsuarioTieneActividadDAO;
import com.arelance.dao.UsuarioTieneActividadPKDAO;
import com.arelance.domain.Actividad;
import com.arelance.servlets.commands.qualifiers.ActivityInscriptionQ;
import com.arelance.domain.Usuario;
import com.arelance.domain.UsuarioTieneActividad;
import com.arelance.domain.UsuarioTieneActividadPK;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@ActivityInscriptionQ
public class ActivityInscription implements ActionsController {

    @Inject
    UsuarioTieneActividadDAO usuarioTieneActividadDAO;
    
    @Inject
    UsuarioTieneActividadPKDAO usuarioTieneActividadPKDAO;
    
    @Inject
    UsuarioTieneActividadPK usuarioTieneActividadPK;
    
    @Inject
    UsuarioTieneActividad usuarioTieneActividad;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Actividad actividad = (Actividad) request.getSession().getAttribute("actividad");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        usuarioTieneActividad.setActividad(actividad);
        usuarioTieneActividad.setUsuario(usuario);
        usuarioTieneActividadPK.setIdActividad(actividad.getIdActividad());
        usuarioTieneActividadPK.setIdUsuario(usuario.getIdUsuario());
        usuarioTieneActividad.setUsuarioTieneActividadPK(usuarioTieneActividadPK);
        usuarioTieneActividadDAO.addUsuarioTieneActividad(usuarioTieneActividad);

        return "/detalleactividad.jsp";

    }

}
