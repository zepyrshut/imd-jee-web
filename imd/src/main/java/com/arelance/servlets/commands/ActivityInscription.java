package com.arelance.servlets.commands;

import com.arelance.domain.Actividad;
import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPal;
import com.arelance.domain.Tarjeta;
import com.arelance.domain.Transferencia;
import com.arelance.domain.Usuario;
import com.arelance.domain.UsuarioTieneActividad;
import com.arelance.domain.UsuarioTieneActividadPK;
import com.arelance.service.UsuarioService;
import com.arelance.servlets.commands.qualifiers.ActivityInscriptionQ;
import com.arelance.servlets.commands.qualifiers.PayPalQ;
import com.arelance.servlets.commands.qualifiers.TarjetaQ;
import com.arelance.servlets.commands.qualifiers.TransferenciaQ;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@ActivityInscriptionQ
public class ActivityInscription implements ActionsController {

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private UsuarioTieneActividad usuarioTieneActividad;

    @Inject
    private UsuarioTieneActividadPK usuarioTieneActividadPK;

    @Inject
    private Usuario usuario;

    @Inject
    private Actividad actividad;

    @Inject
    @PayPalQ
    private PayPal paypal;

    @Inject
    @TarjetaQ
    private Tarjeta tarjeta;

    @Inject
    @TransferenciaQ
    private Transferencia transferencia;
    
    MetodoPago mp;

    private final Map<String, MetodoPago> metodosPago = new HashMap<>();

    public void buildMap() {
        metodosPago.put("PayPal", paypal);
        metodosPago.put("Tarjeta", tarjeta);
        metodosPago.put("Transferencia", transferencia);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
        
        buildMap();
        
        // TODO - Mejorar el método execute(), es muy largo.

        actividad = (Actividad) request.getSession().getAttribute("actividad");
        usuario = (Usuario) request.getSession().getAttribute("usuario");
        String test = request.getParameter("metodoPago");
        int index = Integer.parseInt(request.getParameter("metodoPago"));
        String metodoPagoUsuario = usuario.getMetodoPago().get(index).getClass().getSimpleName();

        usuarioTieneActividad.setUsuario(usuario);
        usuarioTieneActividadPK.setIdActividad(actividad.getIdActividad());
        usuarioTieneActividadPK.setIdUsuario(usuario.getIdUsuario());

        mp = metodosPago.get(metodoPagoUsuario);
        mp = usuario.getMetodoPago().get(index);
        usuarioTieneActividad.setMetodoPago(mp);
        usuarioTieneActividadPK.setIdPago(mp.getIdMetodoPago());

        usuarioTieneActividad.setActividad(actividad);
        usuarioTieneActividad.setUsuarioTieneActividadPK(usuarioTieneActividadPK);
        usuario.getUsuarioTieneActividad().add(usuarioTieneActividad);
        usuarioService.updateUsuario(usuario);

        return "/preindex";

    }

}
