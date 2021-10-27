package com.arelance.servlets.commands;

import com.arelance.domain.Activity;
import com.arelance.qualifiers.ActivityCrudQ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import com.arelance.qualifiers.ActivityDetailsQ;
import com.arelance.service.Crud;

/**
 *
 * @author Pedro
 */
@ActivityDetailsQ
public class ActivityDetails implements ActionsController {
    
    @Inject
    @ActivityCrudQ
    private Crud<Activity> activityCrud;

    @Inject
    private Activity activity;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idActividad = request.getParameter("idactividad");
        activity.setActivityId(Integer.parseInt(idActividad));

        if (idActividad != null) {
            request.getSession().setAttribute("actividad", activityCrud.readEntity(activity.getActivityId()));
        } else {
            request.getSession().removeAttribute("actividad");
        }
        return "/detalleactividad.jsp";
    }

}
