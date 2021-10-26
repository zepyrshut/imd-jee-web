package com.arelance.servlets.commands;

import com.arelance.domain.Actividad;
import com.arelance.domain.Paypal;
import com.arelance.domain.Tarjeta;
import com.arelance.domain.Transferencia;
import com.arelance.domain.Usuario;
import com.arelance.domain.UsuarioTieneActividad;
import com.arelance.domain.UsuarioTieneActividadPK;
import com.arelance.service.ActividadService;
import com.arelance.service.UsuarioService;
import com.arelance.servlets.commands.qualifiers.ActivityInscriptionQ;
import java.io.IOException;
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

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        actividad = (Actividad) request.getSession().getAttribute("actividad");
        usuario = (Usuario) request.getSession().getAttribute("usuario");
        int index = 0;
        String metodoPagoUsuario = usuario.getMetodoPago().get(index).getClass().getSimpleName();

        usuarioTieneActividad.setUsuario(usuario);
        usuarioTieneActividadPK.setIdActividad(actividad.getIdActividad());
        usuarioTieneActividadPK.setIdUsuario(usuario.getIdUsuario());

        // TODO - Mejorar sistema direccionamiento. Uso de patrón comando o patrón estrategia.
        if (metodoPagoUsuario.equals("Paypal")) {
            Paypal paypal;
            paypal = (Paypal) usuario.getMetodoPago().get(index);
            usuarioTieneActividad.setMetodoPago(paypal);
            usuarioTieneActividadPK.setIdPago(paypal.getIdMetodoPago());

        } else if (metodoPagoUsuario.equals("Tarjeta")) {
            Tarjeta tarjeta;
            tarjeta = (Tarjeta) usuario.getMetodoPago().get(index);
            usuarioTieneActividad.setMetodoPago(tarjeta);
            usuarioTieneActividadPK.setIdPago(tarjeta.getIdMetodoPago());
        } else {
            Transferencia transferencia;
            transferencia = (Transferencia) usuario.getMetodoPago().get(index);
            usuarioTieneActividad.setMetodoPago(transferencia);
            usuarioTieneActividadPK.setIdPago(transferencia.getIdMetodoPago());
        }

        usuarioTieneActividad.setActividad(actividad);
        usuarioTieneActividad.setUsuarioTieneActividadPK(usuarioTieneActividadPK);
        usuario.getUsuarioTieneActividad().add(usuarioTieneActividad);
        usuarioService.updateUsuario(usuario);

        return "/preindex";

    }

}
