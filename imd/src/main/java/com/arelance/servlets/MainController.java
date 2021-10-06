package com.arelance.servlets;

import com.arelance.servlets.commands.IndexLoader;
import com.arelance.servlets.commands.LogIn;
import com.arelance.servlets.commands.LogOut;
import java.io.IOException;
import java.util.*;
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

    public MainController() {
        actions.put("logout", new LogOut());
        actions.put("indexloader", new IndexLoader());
        actions.put("login", new LogIn());
        
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
