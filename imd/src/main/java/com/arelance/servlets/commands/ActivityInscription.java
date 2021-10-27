package com.arelance.servlets.commands;

import com.arelance.domain.Activity;
import com.arelance.domain.PaymentMethod;
import com.arelance.domain.User;
import com.arelance.domain.UserHasActivity;
import com.arelance.domain.UserHasActivityPK;
import com.arelance.service.factory.Crud;
import com.arelance.service.factory.UserFactory;
import com.arelance.servlets.commands.qualifiers.ActivityInscriptionQ;
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
@ActivityInscriptionQ
public class ActivityInscription implements ActionsController {

    @Inject
    @UserCrudQ
    private Crud<User> crudUser;

    @Inject
    private UserFactory userFactory;

    @Inject
    private UserHasActivity userHasActivity;

    @Inject
    private UserHasActivityPK userHasActivityPK;

    @Inject
    private User user;

    @Inject
    private Activity activity;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        crudUser = userFactory.createCrud();

        activity = (Activity) request.getSession().getAttribute("actividad");
        user = (User) request.getSession().getAttribute("usuario");
        int index = Integer.parseInt(request.getParameter("metodoPago"));
        PaymentMethod metodoPago = user.getMetodoPago().get(index);

        userHasActivityPK.setIdActividad(activity.getIdActividad());
        userHasActivityPK.setIdUsuario(user.getIdUsuario());
        userHasActivityPK.setIdPago(metodoPago.getIdMetodoPago());

        userHasActivity.setActividad(activity);
        userHasActivity.setUsuario(user);
        userHasActivity.setMetodoPago(metodoPago);

        userHasActivity.setUsuarioTieneActividadPK(userHasActivityPK);
        user.getUsuarioTieneActividad().add(userHasActivity);
        crudUser.updateEntity(user);

        return "/preindex";

    }

}
