package com.arelance.servlets.commands;

import com.arelance.domain.PayPal;
import com.arelance.domain.DebitCard;
import com.arelance.domain.BankAccount;
import com.arelance.domain.UserImd;
import com.arelance.service.UserCrud;
import com.arelance.qualifiers.PaymentMethodQ;
import com.arelance.qualifiers.UserFactoryQ;
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
@PaymentMethodQ
public class PaymentMethod implements ActionsController {
    
    @Inject
    @UserFactoryQ
    private Factory<UserCrud> userFactory;    
    
    @Inject
    private UserImd userImd;
    
    // TODO - Mejorar esto
    private com.arelance.domain.PaymentMethod paymentMethodUser;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        userImd = (UserImd) request.getSession().getAttribute("user");
        String selectedPaymentMethod = request.getParameter("paymentmethod");
        String description = request.getParameter("description");
        
        // TODO - Mejorar sentencia switch, reemplazando por patrón comando.

        switch (selectedPaymentMethod) {
            case "paypal":
                String email = request.getParameter("email");
                paymentMethodUser = new PayPal(email, description);
                break;
            case "debit":
                String number = request.getParameter("number");
                String cvv = request.getParameter("cvv");
                paymentMethodUser = new DebitCard(number, cvv, description);
                break;
            case "bank":
                String iban = request.getParameter("iban");
                paymentMethodUser = new BankAccount(iban, description);
                break;
            default:
        }

        paymentMethodUser.setUserImd(userImd);
        userImd.getPaymentMethod().add(paymentMethodUser);
        userFactory.buildCrud().updateEntity(userImd);

        return "/preindex";
    }

}
