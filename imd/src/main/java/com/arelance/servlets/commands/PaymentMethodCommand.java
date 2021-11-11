package com.arelance.servlets.commands;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.Usuario;
import com.arelance.enums.PaymentMethodsEnum;
import com.arelance.service.PaymentMethodService;
import com.arelance.servlets.commands.paymentstrat.ConcreteAccount;
import com.arelance.servlets.commands.paymentstrat.ConcreteDebit;
import com.arelance.servlets.commands.paymentstrat.ConcretePaypal;
import com.arelance.servlets.commands.paymentstrat.ContextStrategyPayment;
import com.arelance.servlets.commands.qualifiers.PaymentMethodQ;
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

    MetodoPago metodoPago;

    @Inject
    private PaymentMethodService paymentMethodService;

    @Inject
    private Usuario usuario;

    @Inject
    private ContextStrategyPayment contextStrategyPayment;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        usuario = (Usuario) request.getSession().getAttribute("usuario");
        String selectedPayment = (String) request.getSession().getAttribute("metodopago");
        PaymentMethodsEnum getMetodoPago = Enum.valueOf(PaymentMethodsEnum.class, selectedPayment);
        String descripcion = request.getParameter("descripcion");

        switch (getMetodoPago) {
            case PAYPAL:
                contextStrategyPayment.setPaymentStrategy(new ConcretePaypal(), request);
                break;
            case DEBIT:
                contextStrategyPayment.setPaymentStrategy(new ConcreteDebit(), request);
                break;
            case ACCOUNT:
                contextStrategyPayment.setPaymentStrategy(new ConcreteAccount(), request);
                break;
            default:

        }

        metodoPago = contextStrategyPayment.executePaymentStrategy(descripcion, usuario);
        metodoPago.setUsuario(usuario);
        usuario.getMetodoPago().add(metodoPago);
        paymentMethodService.addPaymentMethod(metodoPago);

        return "/userprofile";
    }

}
