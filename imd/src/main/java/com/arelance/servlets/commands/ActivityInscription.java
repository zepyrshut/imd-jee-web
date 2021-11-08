package com.arelance.servlets.commands;

import com.arelance.domain.Activity;
import com.arelance.domain.PaymentMethod;
import com.arelance.domain.UserImd;
import com.arelance.domain.UserHasActivity;
import com.arelance.domain.UserHasActivityPK;
import com.arelance.service.UserCrud;
import com.arelance.qualifiers.ActivityInscriptionQ;
import com.arelance.service.factory.Factory;
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
    private Factory<UserCrud> userFactory;

    @Inject
    private UserHasActivity userHasActivity;

    @Inject
    private UserHasActivityPK userHasActivityPK;

    @Inject
    private UserImd userImd;

    @Inject
    private Activity activity;
    
    private PaymentMethod paymentMethod;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        activity = (Activity) request.getSession().getAttribute("activity");
        userImd = (UserImd) request.getSession().getAttribute("user");
        int index = Integer.parseInt(request.getParameter("paymentMethod"));
        //paymentMethod = userImd.getPaymentMethod().get(index);

        userHasActivityPK.setActivityId(activity.getActivityId());
        userHasActivityPK.setUserId(userImd.getUserId());
        userHasActivityPK.setPaymentId(paymentMethod.getPaymentId());

        userHasActivity.setActivity(activity);
        userHasActivity.setUserImd(userImd);
        userHasActivity.setPaymentMethod(paymentMethod);

        userHasActivity.setUserHasActivityPK(userHasActivityPK);
        userImd.getUserHasActivity().add(userHasActivity);
        userFactory.buildCrud().updateEntity(userImd);

        return "/preindex";

    }

}
