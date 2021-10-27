package com.arelance.servlets.commands;

import com.arelance.domain.Actividad;
import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPalRename;
import com.arelance.domain.Tarjeta;
import com.arelance.domain.Transferencia;
import com.arelance.domain.Usuario;
import com.arelance.domain.UsuarioTieneActividad;
import com.arelance.domain.UsuarioTieneActividadPK;
import com.arelance.service.UsuarioService;
import com.arelance.servlets.commands.qualifiers.ActivityInscriptionQ;
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

    private final Map<String, MetodoPago> metodosPago = crearMetodosPago();

    private static Map<String, MetodoPago> crearMetodosPago() {
        Map<String, MetodoPago> metodosPago = new HashMap<>();
        metodosPago.put("PayPal", new PayPalRename());
        metodosPago.put("Tarjeta", new Tarjeta());
        metodosPago.put("Transferencia", new Transferencia());
        return metodosPago;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MetodoPago metodopago;
        
        actividad = (Actividad) request.getSession().getAttribute("actividad");
        usuario = (Usuario) request.getSession().getAttribute("usuario");
        int index = Integer.parseInt(request.getParameter("metodoPago"));
        String metodoPagoUsuario = usuario.getMetodoPago().get(index).getClass().getSimpleName();

        usuarioTieneActividad.setUsuario(usuario);
        usuarioTieneActividadPK.setIdActividad(actividad.getIdActividad());
        usuarioTieneActividadPK.setIdUsuario(usuario.getIdUsuario());

        metodosPago.get(metodoPagoUsuario);
        metodopago = usuario.getMetodoPago().get(index);
        usuarioTieneActividad.setMetodoPago(metodopago);
        usuarioTieneActividadPK.setIdPago(metodopago.getIdMetodoPago());

        usuarioTieneActividad.setActividad(actividad);
        usuarioTieneActividad.setUsuarioTieneActividadPK(usuarioTieneActividadPK);
        usuario.getUsuarioTieneActividad().add(usuarioTieneActividad);
        usuarioService.updateUsuario(usuario);

        return "/preindex";

    }

}
