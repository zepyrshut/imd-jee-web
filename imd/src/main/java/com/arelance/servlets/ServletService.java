package com.arelance.servlets;

import java.io.IOException;
import java.util.*;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@WebServlet("/service")
public class ServletService extends HttpServlet {

    private final Map<String, ServletAction> actionMap = new HashMap<>();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        actionMap.put("logout", new LogOut());
        actionMap.put("loader", new Loader());

        String actionKey = request.getParameter("action");
        ServletAction servletAction = actionMap.get(actionKey);
        servletAction.execute(request, response);

    }

}
