package com.arelance.servlets.commands;

import com.arelance.servlets.commands.qualifiers.LogInQ;
import com.arelance.dao.DatosSesionDAO;
import com.arelance.domain.DatosSesion;
import com.arelance.domain.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@LogInQ
public class LogIn implements ActionsController {

    @Inject
    private DatosSesionDAO datosSesionDAO;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DatosSesion datosSesion = new DatosSesion();
        String nombre = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        datosSesion.setUsuario(nombre);
        datosSesion.setContrasena(contrasena);
        datosSesion = datosSesionDAO.inicioSesion(datosSesion);

        if (datosSesion == null) {
            String datoIncorrecto = "Datos de sesión incorrectos, inténtelo de nuevo.";
            request.setAttribute("datoIncorrecto", datoIncorrecto);
            return "/iniciosesion.jsp";
        } else {
            Usuario usuario = datosSesion.getUsuarioSocio();
            HttpSession sesionUsuario = request.getSession(true);
            sesionUsuario.setAttribute("usuario", usuario);
            return "/preindex";
        }

    }

}
