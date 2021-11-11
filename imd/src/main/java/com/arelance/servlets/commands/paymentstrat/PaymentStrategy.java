package com.arelance.servlets.commands.paymentstrat;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.Usuario;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 */
public interface PaymentStrategy {
    
    void collectPaymentDetails(HttpServletRequest request);
    
    MetodoPago execute(String nombrePago, Usuario usuario);
    
    
}
