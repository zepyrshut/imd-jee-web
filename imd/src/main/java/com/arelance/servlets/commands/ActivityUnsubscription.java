package com.arelance.servlets.commands;

import com.arelance.domain.Activity;
import com.arelance.domain.UserImd;
import com.arelance.service.factory.Crud;
import com.arelance.qualifiers.ActivityUnsubcriptionQ;
import com.arelance.qualifiers.UserCrudQ;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@ActivityUnsubcriptionQ
public class ActivityUnsubscription implements ActionsController {

    @Inject
    @UserCrudQ
    private Crud<UserImd> userCrud;

    @Inject
    private Activity activity;

    @Inject
    private UserImd userImd;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        activity = (Activity) request.getSession().getAttribute("actividad");
        userImd = (UserImd) request.getSession().getAttribute("usuario");

        boolean remove = userImd.getUserHasActivity().remove(activity);

        if (remove) {
            userCrud.updateEntity(userImd);
        } else {
            // TODO - Añadir mensajes de error.
        }

        return "/detalleactividad.jsp";

    }

}
