package com.arelance.servlets;

import java.io.IOException;
import java.util.*;
import javax.inject.Inject;
import javax.inject.Named;
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
@WebServlet("/maincontroller")
public class MainController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final Map<String, MainCommand> actions = new HashMap<>();

    @Inject
    @Named("indexloader")
    private MainCommand indexLoader;

    @Inject
    @Named("login")
    private MainCommand logIn;

    @Inject
    @Named("logout")
    private MainCommand logOut;

    @Override
    public void init() throws ServletException {
        super.init();
        actions.put("indexloader", indexLoader);
        actions.put("logout", logOut);
        actions.put("login", logIn);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String actionKey = request.getParameter("action");

        if (actionKey == null) {
            actionKey = "indexloader";
        }

        MainCommand action = actions.get(actionKey);
        String page = action.execute(request, response);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }
}
