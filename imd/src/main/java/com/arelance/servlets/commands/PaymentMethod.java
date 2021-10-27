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

    private MetodoPago metodoPagoUsuario;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        usuario = (Usuario) request.getSession().getAttribute("usuario");
        String metodoPagoSeleccionado = request.getParameter("metodopago");
        String descripcion = request.getParameter("descripcion");
        
        // TODO - Mejorar sentencia switch, reemplazando por patrón comando.

        switch (metodoPagoSeleccionado) {
            case "paypal":
                String correopaypal = request.getParameter("correopaypal");
                metodoPagoUsuario = new PayPal(correopaypal, descripcion);
                break;
            case "tarjeta":
                String numero = request.getParameter("numerotarjeta");
                String cvv = request.getParameter("cvv");
                metodoPagoUsuario = new Tarjeta(numero, cvv, descripcion);
                break;
            case "transferencia":
                String iban = request.getParameter("iban");
                metodoPagoUsuario = new Transferencia(iban, descripcion);
                break;
            default:
        }

        metodoPagoUsuario.setUsuario(usuario);
        usuario.getMetodoPago().add(metodoPagoUsuario);
        usuarioService.updateUsuario(usuario);

        return "/preindex";
    }

}
