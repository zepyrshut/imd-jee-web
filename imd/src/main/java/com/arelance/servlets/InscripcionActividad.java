package com.arelance.servlets;

import com.arelance.dao.UsuarioTieneActividadDAO;
import com.arelance.domain.Actividad;
import com.arelance.domain.Usuario;
import com.arelance.domain.UsuarioTieneActividad;
import com.arelance.domain.UsuarioTieneActividadPK;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.arelance.dao.UsuarioTieneActividadPKDAO;

/**
 *
 * @author Pedro
 */
@WebServlet("/inscripcionactividad")
public class InscripcionActividad extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Inject
    UsuarioTieneActividadDAO usuarioTieneActividadDAO;
    @Inject
    UsuarioTieneActividadPKDAO usuarioTieneActividadPKDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Actividad actividad = (Actividad) request.getSession().getAttribute("actividad");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");        
        

        UsuarioTieneActividad usuarioTieneActividad = new UsuarioTieneActividad();
        usuarioTieneActividad.setActividad(actividad);
        usuarioTieneActividad.setUsuario(usuario);
        UsuarioTieneActividadPK usuarioTieneActividadPK = new UsuarioTieneActividadPK();
        usuarioTieneActividadPK.setIdActividad(actividad.getIdActividad());
        usuarioTieneActividadPK.setIdUsuario(usuario.getIdUsuario());
        usuarioTieneActividad.setUsuarioTieneActividadPK(usuarioTieneActividadPK);
        
     //   usuarioTieneActividad.setPaypal(usuario.getPaypal());
        usuarioTieneActividadDAO.addUsuarioTieneActividad(usuarioTieneActividad);

//        if (idActividad != null) {
//            request.getSession().setAttribute("actividad", actividadService.findActividadById(actividad));
//        } else {
//            request.getSession().removeAttribute("actividad");
//        }
        request.getRequestDispatcher("detalleactividad.jsp").forward(request, response);
    }

}
