package com.arelance.servlets.commands;

import com.arelance.domain.Activity;
import com.arelance.domain.User;
import com.arelance.service.factory.Crud;
import com.arelance.service.factory.UserFactory;
import com.arelance.servlets.commands.qualifiers.ActivityUnsubcriptionQ;
import com.arelance.servlets.commands.qualifiers.UserCrudQ;
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
    private Crud<User> crudUser;

    @Inject
    private UserFactory userFactory;

    @Inject
    private Activity activity;

    @Inject
    private User user;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        crudUser = userFactory.createCrud();

        activity = (Activity) request.getSession().getAttribute("actividad");
        user = (User) request.getSession().getAttribute("usuario");

        boolean remove = user.getUsuarioTieneActividad().remove(activity);

        if (remove) {
            // TODO - Revisar.
            //crudUser.updateEntity(user);
            crudUser.updateEntity(user);
        } else {
            // TODO - Añadir mensajes de error.
        }

        return "/detalleactividad.jsp";

    }

}
