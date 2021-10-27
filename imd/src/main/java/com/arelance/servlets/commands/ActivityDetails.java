package com.arelance.servlets.commands;

import com.arelance.domain.Activity;
import com.arelance.service.factory.ActivityFactory;
import com.arelance.service.factory.Crud;
import com.arelance.servlets.commands.qualifiers.ActivityCrudQ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import com.arelance.servlets.commands.qualifiers.ActivityDetailsQ;

/**
 *
 * @author Pedro
 */
@ActivityDetailsQ
public class ActivityDetails implements ActionsController {
    
    @Inject
    @ActivityCrudQ
    private Crud<Activity> crudActivity;

    @Inject
    private ActivityFactory activityFactory;

    @Inject
    private Activity activity;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        crudActivity = activityFactory.createCrud();

        String idActividad = request.getParameter("idactividad");
        activity.setIdActividad(Integer.parseInt(idActividad));

        if (idActividad != null) {
            request.getSession().setAttribute("actividad", crudActivity.readEntity(activity.getIdActividad()));
        } else {
            request.getSession().removeAttribute("actividad");
        }
        return "/detalleactividad.jsp";
    }

}
