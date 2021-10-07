package com.arelance.servlets.commands;

import java.io.IOException;
import java.util.*;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Qualifier;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@WebServlet("/actions")
public class ActionsService extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final Map<String, ActionsController> actions = new HashMap<>();

    @Inject
    @Named("login")
    private ActionsController logIn;

    @Named("logout")
    @Inject
    private ActionsController logOut;

    @Named("register")
    @Inject
    private ActionsController register;

    @Override
    public void init() throws ServletException {
        super.init();
        actions.put("logout", logOut);
        actions.put("login", logIn);
        actions.put("register", register);
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String actionKey = request.getParameter("action");

        ActionsController action = actions.get(actionKey);
        String page = action.execute(request, response);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }

}
