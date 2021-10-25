package com.arelance.servlets.commands;

import com.arelance.domain.Actividad;
import com.arelance.domain.MetodoPago;
import com.arelance.domain.Paypal;
import com.arelance.domain.Usuario;
import com.arelance.domain.UsuarioTieneActividad;
import com.arelance.domain.UsuarioTieneActividadPK;
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
        String metodoPagoUsuario = usuario.getMetodoPago().get(0).getClass().getSimpleName();
        
        // TODO - Mejorar sistema direccionamiento. Uso de patrón comando o patrón estrategia.

        if (metodoPagoUsuario.equals("Paypal")) {
          //  paypal = usuario.getMetodoPago().get(0);
        } else if (metodoPagoUsuario.equals("Tarjeta")) {
          //  tarjeta = usuario.getMetodoPago().get(0);
        }

        //Paypal paypal = new Paypal():
        // paypal = usuario.getMetodoPago().get(0);
        usuarioTieneActividad.setActividad(actividad);
        usuarioTieneActividad.setUsuario(usuario);
        // usuarioTieneActividad.setMetodoPago(paypal);

        usuarioTieneActividadPK.setIdActividad(actividad.getIdActividad());
        usuarioTieneActividadPK.setIdUsuario(usuario.getIdUsuario());
        // usuarioTieneActividadPK.setIdPago(paypal.getIdMetodoPago());

        usuarioTieneActividad.setUsuarioTieneActividadPK(usuarioTieneActividadPK);
        usuario.getUsuarioTieneActividad().add(usuarioTieneActividad);
        usuarioService.updateUsuario(usuario);

        return "/detalleactividad.jsp";

    }

}
