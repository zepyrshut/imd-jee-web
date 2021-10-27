package com.arelance.servlets.commands;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPal;
import com.arelance.domain.Tarjeta;
import com.arelance.domain.Transferencia;
import com.arelance.domain.Usuario;
import com.arelance.service.UsuarioService;
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
    private UsuarioService usuarioService;

    @Inject
    private Usuario usuario;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO - Mejorar el algoritmo de if/else con patrón estrategia, comando o estado.
        usuario = (Usuario) request.getSession().getAttribute("usuario");
        String metodoPago = request.getParameter("metodopago");
        String descripcion = request.getParameter("descripcion");
        MetodoPago mp = null;

        if (metodoPago.equals("paypal")) {
            String correopaypal = request.getParameter("correopaypal");
            mp = new PayPal(correopaypal, descripcion);
        } else if (metodoPago.equals("tarjeta")) {
            String numero = request.getParameter("numerotarjeta");
            String cvv = request.getParameter("cvv");
            mp = new Tarjeta(numero, cvv, descripcion);
        } else if (metodoPago.equals("transferencia")) {
            String iban = request.getParameter("iban");
            mp = new Transferencia(iban, descripcion);
        }

        mp.setUsuario(usuario);
        usuario.getMetodoPago().add(mp);
        usuarioService.updateUsuario(usuario);

        return "/preindex";
    }

}
