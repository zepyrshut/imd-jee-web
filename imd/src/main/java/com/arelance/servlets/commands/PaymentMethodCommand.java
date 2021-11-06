package com.arelance.servlets.commands;

import com.arelance.domain.PayPal;
import com.arelance.domain.DebitCard;
import com.arelance.domain.BankAccount;
import com.arelance.domain.PaymentMethod;
import com.arelance.domain.UserImd;
import com.arelance.service.UserCrud;
import com.arelance.qualifiers.PaymentMethodQ;
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
public class PaymentMethodCommand implements ActionsController {

    @Inject
    private Factory<UserCrud> userFactory;

    @Inject
    private UserImd userImd;

    private PaymentMethod paymentMethodUser;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String addOrDelete = request.getParameter("actionPayment");
        userImd = (UserImd) request.getSession().getAttribute("user");
        userImd = userFactory.buildCrud().findById(userImd.getUserId());

        switch (addOrDelete) {
            case "add":
                String selectedPaymentMethod = request.getParameter("paymentmethod");
                String description = request.getParameter("description");

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
                request.getSession().setAttribute("user", userImd);
                break;
            case "delete":
                System.out.println("alcanzado");
                Integer index = Integer.parseInt(request.getParameter("index"));
                userImd.getPaymentMethod().remove(index);
                userFactory.buildCrud().updateEntity(userImd);
                break;

            default:

        }

        return "/profile";

    }

}
