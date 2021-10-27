package com.arelance.servlets.commands;

import com.arelance.qualifiers.LogInQ;
import com.arelance.domain.SessionData;
import com.arelance.domain.UserImd;
import com.arelance.service.impl.SessionDataCrud;
import com.arelance.qualifiers.SessionDataCrudQ;
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

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SessionData datosSesion = new SessionData();
        String name = request.getParameter("usuario");
        String password = request.getParameter("contrasena");

        datosSesion.setUser(name);
        datosSesion.setPassword(password);
        datosSesion = sessionDataCrud.logIn(datosSesion);
        
        if (datosSesion == null) {
            String invalidData = "Datos de sesión incorrectos, inténtelo de nuevo.";
            request.setAttribute("invalidData", invalidData);
            return "/iniciosesion.jsp";
        } else {
            UserImd userImd = datosSesion.getUserSessionData();
            HttpSession sesionUsuario = request.getSession(true);
            sesionUsuario.setAttribute("usuario", userImd);
            return "/preindex";
        }

    }

}
