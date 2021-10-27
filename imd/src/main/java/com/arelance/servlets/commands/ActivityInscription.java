package com.arelance.servlets.commands;

import com.arelance.domain.Activity;
import com.arelance.domain.PaymentMethod;
import com.arelance.domain.UserImd;
import com.arelance.domain.UserHasActivity;
import com.arelance.domain.UserHasActivityPK;
import com.arelance.service.impl.UserCrud;
import com.arelance.qualifiers.ActivityInscriptionQ;
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
@ActivityInscriptionQ
public class ActivityInscription implements ActionsController {

    @Inject
    @UserCrudQ
    private UserCrud userCrud;

    @Inject
    private UserHasActivity userHasActivity;

    @Inject
    private UserHasActivityPK userHasActivityPK;

    @Inject
    private UserImd userImd;

    @Inject
    private Activity activity;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        activity = (Activity) request.getSession().getAttribute("actividad");
        userImd = (UserImd) request.getSession().getAttribute("usuario");
        int index = Integer.parseInt(request.getParameter("metodoPago"));
        PaymentMethod metodoPago = userImd.getPaymentMethod().get(index);

        userHasActivityPK.setActivityId(activity.getActivityId());
        userHasActivityPK.setUserId(userImd.getUserId());
        userHasActivityPK.setPaymentId(metodoPago.getPaymentId());

        userHasActivity.setActivity(activity);
        userHasActivity.setUserImd(userImd);
        userHasActivity.setPaymentMethod(metodoPago);

        userHasActivity.setUserHasActivityPK(userHasActivityPK);
        userImd.getUserHasActivity().add(userHasActivity);
        userCrud.updateEntity(userImd);

        return "/preindex";

    }

}
