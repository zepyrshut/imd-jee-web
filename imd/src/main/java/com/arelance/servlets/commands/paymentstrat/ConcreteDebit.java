package com.arelance.servlets.commands.paymentstrat;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.Tarjeta;
import com.arelance.domain.Usuario;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 */
public class ConcreteDebit implements PaymentStrategy {
    
    private String numero;
    private String cvv;

    @Override
    public void collectPaymentDetails(HttpServletRequest request) {
        numero = request.getParameter("numerotarjeta");
        cvv = request.getParameter("cvv");
    }

    @Override
    public MetodoPago execute(String nombrePago, Usuario usuario) {
        return new Tarjeta(numero, cvv, nombrePago, usuario);
    }

}
