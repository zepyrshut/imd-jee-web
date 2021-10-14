package com.arelance.servlets.commands;

import com.arelance.domain.Actividad;
import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPalQ;
import com.arelance.domain.TarjetaQ;
import com.arelance.domain.TransferenciaQ;
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
    @PayPalQ
    private MetodoPago paypal;
        
    @Inject
    @TarjetaQ
    private MetodoPago tarjeta;
    
    @Inject
    @TransferenciaQ
    private MetodoPago transferencia;
    
    @Inject
    private Usuario usuario;
    
    @Inject
    private Actividad actividad;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        actividad = (Actividad) request.getSession().getAttribute("actividad");
        usuario = (Usuario) request.getSession().getAttribute("usuario");        
        paypal = usuario.getMetodoPago().get(0);
        
        usuarioTieneActividad.setActividad(actividad);
        usuarioTieneActividad.setUsuario(usuario);
        usuarioTieneActividad.setMetodoPago(paypal);

        usuarioTieneActividadPK.setIdActividad(actividad.getIdActividad());
        usuarioTieneActividadPK.setIdUsuario(usuario.getIdUsuario());
        usuarioTieneActividadPK.setIdPago(paypal.getIdMetodoPago());
        
        usuarioTieneActividad.setUsuarioTieneActividadPK(usuarioTieneActividadPK);        
        
        usuario.getUsuarioTieneActividadCollection().add(usuarioTieneActividad);

        
        usuarioService.updateUsuario(usuario);

        return "/detalleactividad.jsp";

    }

}
