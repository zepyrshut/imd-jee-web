package com.arelance.servlets.commands;

import com.arelance.domain.PayPal;
import com.arelance.domain.DebitCard;
import com.arelance.domain.BankAccount;
import com.arelance.domain.User;
import com.arelance.service.factory.Crud;
import com.arelance.service.factory.UserFactory;
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
public class PaymentMethod implements ActionsController {
    
    @Inject
    private Crud crudUser;
    
    @Inject
    private UserFactory userFactory;

    @Inject
    private User user;

    private com.arelance.domain.PaymentMethod paymentMethodUser;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        crudUser = userFactory.createCrud();

        user = (User) request.getSession().getAttribute("usuario");
        String metodoPagoSeleccionado = request.getParameter("metodopago");
        String descripcion = request.getParameter("descripcion");
        
        // TODO - Mejorar sentencia switch, reemplazando por patrón comando.

        switch (metodoPagoSeleccionado) {
            case "paypal":
                String correopaypal = request.getParameter("correopaypal");
                paymentMethodUser = new PayPal(correopaypal, descripcion);
                break;
            case "tarjeta":
                String numero = request.getParameter("numerotarjeta");
                String cvv = request.getParameter("cvv");
                paymentMethodUser = new DebitCard(numero, cvv, descripcion);
                break;
            case "transferencia":
                String iban = request.getParameter("iban");
                paymentMethodUser = new BankAccount(iban, descripcion);
                break;
            default:
        }

        paymentMethodUser.setUsuario(user);
        user.getMetodoPago().add(paymentMethodUser);
        crudUser.updateEntity(this);

        return "/preindex";
    }

}
