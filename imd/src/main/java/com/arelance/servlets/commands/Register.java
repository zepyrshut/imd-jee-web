package com.arelance.servlets.commands;

import com.arelance.qualifiers.RegisterQ;
import com.arelance.domain.SessionData;
import com.arelance.domain.UserImd;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import com.arelance.service.SessionDataCrud;
import com.arelance.service.UserCrud;
import com.arelance.service.factory.Factory;

/**
 *
 * @author Pedro
 */
@RegisterQ
public class Register implements ActionsController {

    @Inject
    private Factory<UserCrud> userFactory;

    @Inject
    private Factory<SessionDataCrud> sessionDataFactory;

    @Inject
    private UserImd userImd;

    @Inject
    private SessionData sessionData;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        userImd.setName(request.getParameter("name"));
        userImd.setSurnameA(request.getParameter("surname_a"));
        userImd.setSurnameB(request.getParameter("surname_b"));
        userImd.setPhone(request.getParameter("photne"));
        userImd.setEmail(request.getParameter("email"));

        if (userFactory.buildCrud().findUserByEmail(userImd) != null) {
            String emailExists = "Ya existe este correo electrónico, pruebe otro.";
            request.setAttribute("emailExists", emailExists);
        } else {
            sessionData.setUser(request.getParameter("user"));
            if (sessionDataFactory.buildCrud().findSessionDataByUser(sessionData) != null) {
                String userExists = "Ya existe este usuario, pruebe otro.";
                request.setAttribute("userExists", userExists);

            } else {
                sessionData.setPassword(request.getParameter("password"));
                sessionData.setUserSessionData(userImd);
                userFactory.buildCrud().createEntity(userImd);
                sessionDataFactory.buildCrud().createEntity(sessionData);
                String success = "Usuario registrado con éxito, ya puedes iniciar sesión.";
                request.setAttribute("success", success);//
            }

        }
        return "/sigin.jsp";

    }

}
