package com.arelance.servlets.commands.paymentstrat;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPal;
import com.arelance.domain.Usuario;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 */
public class ConcretePaypal implements PaymentStrategy {
    
    private String email;
    
    @Override
    public void collectPaymentDetails(HttpServletRequest request) {
        email = request.getParameter("correopaypal");
    }

    @Override
    public MetodoPago execute(String nombrePago, Usuario usuario) {
        return new PayPal(email, nombrePago, usuario);
        
    }




  

    

    
}
