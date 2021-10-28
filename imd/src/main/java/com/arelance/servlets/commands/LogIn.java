package com.arelance.servlets.commands;

import com.arelance.qualifiers.LogInQ;
import com.arelance.domain.SessionData;
import com.arelance.domain.UserImd;
import com.arelance.service.SessionDataCrud;
import com.arelance.qualifiers.SessionDataFactoryQ;
import com.arelance.service.factory.Factory;
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
    @SessionDataFactoryQ
    private Factory<SessionDataCrud> sessionDataFactory;
    
    @Inject
    private SessionData sessionData;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("usuario");
        String password = request.getParameter("contrasena");

        sessionData.setUser(name);
        sessionData.setPassword(password);
        sessionData = sessionDataFactory.buildCrud().logIn(sessionData);

        
        if (sessionData == null) {
            String invalidData = "Datos de sesión incorrectos, inténtelo de nuevo.";
            request.setAttribute("invalidData", invalidData);
            return "/iniciosesion.jsp";
        } else {
            UserImd userImd = sessionData.getUserSessionData();
            HttpSession sesionUsuario = request.getSession(true);
            sesionUsuario.setAttribute("usuario", userImd);
            return "/preindex";
        }

    }

}
