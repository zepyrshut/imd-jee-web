package com.arelance.servlets.commands;

import com.arelance.servlets.commands.qualifiers.LogInQ;
import com.arelance.domain.SessionData;
import com.arelance.domain.User;
import com.arelance.service.factory.SessionDataFactory;
import com.arelance.service.impl.SessionDataCrud;
import com.arelance.servlets.commands.qualifiers.SessionDataCrudQ;
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
    @SessionDataCrudQ
    private SessionDataCrud sessionDataCrud;

    @Inject
    private SessionDataFactory sessionDataFactory;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        sessionDataCrud =  (SessionDataCrud) sessionDataFactory.createCrud();

        SessionData datosSesion = new SessionData();
        String nombre = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        datosSesion.setUsuario(nombre);
        datosSesion.setContrasena(contrasena);
        datosSesion = sessionDataCrud.logIn(datosSesion);
        
        if (datosSesion == null) {
            String datoIncorrecto = "Datos de sesión incorrectos, inténtelo de nuevo.";
            request.setAttribute("datoIncorrecto", datoIncorrecto);
            return "/iniciosesion.jsp";
        } else {
            User usuario = datosSesion.getUsuarioSocio();
            HttpSession sesionUsuario = request.getSession(true);
            sesionUsuario.setAttribute("usuario", usuario);
            return "/preindex";
        }

    }

}
