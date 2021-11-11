package com.arelance.servlets.commands.paymentstrat;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.Transferencia;
import com.arelance.domain.Usuario;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 */
public class ConcreteAccount implements PaymentStrategy {
    
    private String iban;

    @Override
    public void collectPaymentDetails(HttpServletRequest request) {
        iban = request.getParameter("iban");
    }

    @Override
    public MetodoPago execute(String nombrePago, Usuario usuario) {
        return new Transferencia(iban, nombrePago, usuario);
    }

}
