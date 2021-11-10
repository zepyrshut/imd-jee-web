package com.arelance.servlets.commands;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPal;
import com.arelance.domain.Tarjeta;
import com.arelance.domain.Transferencia;
import com.arelance.domain.Usuario;
import com.arelance.service.MetodoPagoService;
import com.arelance.service.PaypalService;
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
    private PaypalService paypalService;
    @Inject
    private MetodoPagoService metodoPagoService;
    @Inject
    private UsuarioService usuarioService;

    @Inject
    private Usuario usuario;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        // TODO - Mejorar el algoritmo de if/else con patrón estrategia, comando o estado.
    
 // TODO - Mejorar el algoritmo de if/else con patrón estrategia, comando o estado.
        usuario = (Usuario) request.getSession().getAttribute("usuario");
        String metodoPago = request.getParameter("metodopago");
        String descripcion = request.getParameter("descripcion");
        MetodoPago mp = null;
        // PASAR SETEO DE METODOPAGO A USUARIO AL FINAL PARA QUITAR     
        switch (metodoPago) {
            case "paypal":
                String correopaypal=request.getParameter("correopaypal");
                PayPal payPal = new PayPal();
                payPal.setCorreoPayPal(correopaypal);
                
                
                PayPal payPal2=paypalService.findPaypalByEmail(payPal);
                
                
                if (payPal2 == null) {
                    
                    //aqui se inserta
                    mp = new PayPal(correopaypal, descripcion);
                    mp.setUsuario(usuario);
                    usuario.getMetodoPago().add(mp);
                    usuarioService.updateUsuario(usuario);
                    
                    
                    return "/preindex";
                } else {
                    //aqui manda error
                    
                    return "/perfilusuario.jsp";
                }
            case "tarjeta":
                String numero = request.getParameter("numerotarjeta");
                String cvv = request.getParameter("cvv");
                mp = new Tarjeta(numero, cvv, descripcion);
                mp.setUsuario(usuario);
                usuario.getMetodoPago().add(mp);
                usuarioService.updateUsuario(usuario);
                break;
            case "transferencia":
                String iban = request.getParameter("iban");
                mp = new Transferencia(iban, descripcion);
                mp.setUsuario(usuario);
                usuario.getMetodoPago().add(mp);
                usuarioService.updateUsuario(usuario);
                break;
            default:
                break;
        }

//        mp.setUsuario(usuario);
//        usuario.getMetodoPago().add(mp);
//        usuarioService.updateUsuario(usuario);

        return "/preindex";
    }

}
