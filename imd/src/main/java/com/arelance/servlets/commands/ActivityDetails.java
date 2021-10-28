package com.arelance.servlets.commands;

import com.arelance.domain.Activity;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import com.arelance.qualifiers.ActivityDetailsQ;
import com.arelance.qualifiers.ActivityFactoryQ;
import com.arelance.service.ActivityCrud;
import com.arelance.service.factory.Factory;

/**
 *
 * @author Pedro
 */
@ActivityDetailsQ
public class ActivityDetails implements ActionsController {
        
    @Inject
    @ActivityFactoryQ
    private Factory<ActivityCrud> activityFactory;

    @Inject
    private Activity activity;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer idActividad = Integer.parseInt(request.getParameter("idactividad"));

        if (idActividad < 0) {
            request.getSession().setAttribute("activity", activityFactory.buildCrud().findById(idActividad));
        } else {
            request.getSession().removeAttribute("activity");
        }
        return "/activitydetails.jsp";
    }

}
