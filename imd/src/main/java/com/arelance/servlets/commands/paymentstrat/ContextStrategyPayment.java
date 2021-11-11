package com.arelance.servlets.commands.paymentstrat;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.Usuario;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 */
public class ContextStrategyPayment {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy, HttpServletRequest request) {
        this.paymentStrategy = paymentStrategy;
        paymentStrategy.collectPaymentDetails(request);
    }

    public MetodoPago executePaymentStrategy(String nombrePago, Usuario usuario) {
        return paymentStrategy.execute(nombrePago, usuario);
    }

}
