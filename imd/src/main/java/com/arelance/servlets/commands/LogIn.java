package com.arelance.servlets.commands;

import com.arelance.qualifiers.LogInQ;
import com.arelance.domain.SessionData;
import com.arelance.domain.UserImd;
import com.arelance.service.SessionDataCrud;
import com.arelance.service.factory.Factory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 * The {@code LogIn} class is an implementation of the login command pattern.
 * 
 * The factory interface is injected with the SessionDataFactory class and the
 * SessionData class.
 * 
 * The {@code execute} method collects the username parameter and the password
 * parameter, for further validation.
 * 
 * It returns a {@code String} type data that in case of login failure, 
 * redirects you to "/login.jsp" and in case of success, redirects you to
 * "/preindex".
 *
 * @author Pedro
 * @since 1.0
 */
@LogInQ
public class LogIn implements ActionsController {

    @Inject
    private Factory<SessionDataCrud> sessionDataFactory;
    
    @Inject
    private UserImd userImd;

    @Inject
    private SessionData sessionData;

    /**
     * 
     * @param request
     * @param response
     * @return String -A- "/login.jsp" -B- "/preindex"
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("user");
        String password = request.getParameter("password");

        if (sessionData == null) {
            sessionData = new SessionData();
        }

        sessionData.setUser(name);
        sessionData.setPassword(password);
        sessionData = sessionDataFactory.buildCrud().logIn(sessionData);
        
        

        if (sessionData == null) {
            String invalidData = "Datos de sesión incorrectos, inténtelo de nuevo.";
            request.setAttribute("invalidData", invalidData);
            return "/login.jsp";
        } else {
            userImd = sessionData.getUserSessionData();
            HttpSession userSession = request.getSession(true);
            userSession.setAttribute("user", userImd);
            return "/preindex";
        }

    }

}
