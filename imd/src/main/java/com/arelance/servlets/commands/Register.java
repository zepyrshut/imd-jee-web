package com.arelance.servlets.commands;

import com.arelance.domain.DatosSesion;
import com.arelance.domain.Usuario;
import com.arelance.service.DatosSesionService;
import com.arelance.service.UsuarioService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Pedro
 */
@Stateless
@Named(value = "register")
public class Register implements ActionsController {

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private DatosSesionService datosSesionService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setApellidoA(request.getParameter("apellido_a"));
        usuario.setApellidoB(request.getParameter("apellido_b"));
        usuario.setTelefono(request.getParameter("telefono"));
        usuario.setEmail(request.getParameter("email"));

        if (usuarioService.findUsuarioByEmail(usuario) != null) {
            String emailRepetido = "Ya existe este correo electrónico, pruebe otro.";
            request.setAttribute("emailRepetido", emailRepetido);

        } else {

            DatosSesion datosSesion = new DatosSesion();
            datosSesion.setUsuario(request.getParameter("usuario"));

            if (datosSesionService.findDatosSesionByUsuario(datosSesion) != null) {
                String usuarioRepetido = "Ya existe este usuario, pruebe otro.";
                request.setAttribute("usuarioRepetido", usuarioRepetido);
                
            } else {
                datosSesion.setContrasena(request.getParameter("contrasena"));
                datosSesion.setUsuarioSocio(usuario);
                usuarioService.addUsuario(usuario);
                datosSesionService.addDatosSesion(datosSesion);
                String usuarioRegistrado = "Usuario registrado con éxito, ya puedes iniciar sesión.";
                request.setAttribute("usuarioRegistrado", usuarioRegistrado);

            }

        }

        return "/registrousuario.jsp";

    }

}
