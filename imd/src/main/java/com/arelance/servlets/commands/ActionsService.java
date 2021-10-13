package com.arelance.servlets.commands;

import com.arelance.servlets.commands.qualifiers.ActivityDescriptionQ;
import com.arelance.servlets.commands.qualifiers.ActivityInscriptionQ;
import com.arelance.servlets.commands.qualifiers.ActivityUnsubcriptionQ;
import com.arelance.servlets.commands.qualifiers.LogInQ;
import com.arelance.servlets.commands.qualifiers.RegisterQ;
import com.arelance.servlets.commands.qualifiers.LogOutQ;
import java.io.IOException;
import java.util.*;
import javax.inject.Inject;
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
    @LogInQ
    private ActionsController logIn;

    @Inject
    @LogOutQ
    private ActionsController logOut;

    @Inject
    @RegisterQ
    private ActionsController register;
    
    @Inject
    @ActivityDescriptionQ
    private ActionsController activityDescription;
    
    @Inject
    @ActivityInscriptionQ
    private ActionsController activityInscription;
    
    @Inject
    @ActivityUnsubcriptionQ
    private ActionsController activityUnsubcription;
    
    @Override
    public void init() throws ServletException {
        super.init();
        actions.put("logout", logOut);
        actions.put("login", logIn);
        actions.put("register", register);
        actions.put("activitydescription", activityDescription);
        actions.put("activityinscription", activityInscription);  
        actions.put("activityubsubcription", activityUnsubcription);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String actionKey = request.getParameter("action");
        
        ActionsController action = actions.get(actionKey);
        String page = action.execute(request, response);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }

}
